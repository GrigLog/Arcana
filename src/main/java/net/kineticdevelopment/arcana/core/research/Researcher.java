package net.kineticdevelopment.arcana.core.research;

import net.kineticdevelopment.arcana.common.event.ResearchEvent;
import net.kineticdevelopment.arcana.core.research.impls.ResearcherCapability;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;

import java.util.HashMap;
import java.util.Map;

public interface Researcher{
	
	/**
	 * Returns the last index of entry section unlocked for that research.
	 * Returns 0 for entries that have not been unlocked yet, or have no progress.
	 *
	 * @param entry
	 * 		The research entry to check the status of.
	 * @return The last index of entry section unlocked, or 0 if it hasn't been unlocked or progressed.
	 */
	int stage(ResearchEntry entry);
	
	boolean isPuzzleCompleted(Puzzle puzzle);
	
	/**
	 * Increments the stage for an entry.
	 *
	 * <p>If the new section has no requirements, this continues to increment the stage
	 * until it reaches either a section with requirements, or the end of the entry.
	 *
	 * <p>Fires {@link ResearchEvent} if the page is not already complete.
	 *
	 * <p>Has no effect if the page is already complete.
	 *
	 * <p>TODO: addenda.
	 *
	 * @param entry
	 * 		The research page to advance.
	 */
	void advance(ResearchEntry entry);
	
	void completePuzzle(Puzzle puzzle);
	
	/**
	 * Sets this researchers progress for an entry to its maximum progress
	 *
	 * <p>Fires {@link ResearchEvent} if the page is not already complete.
	 *
	 * <p>Has no effect if the page is already complete.
	 *
	 * @param entry
	 * 		The research entry to complete.
	 */
	void completeEntry(ResearchEntry entry);
	
	/**
	 * Removes all progress on the given entry.
	 *
	 * <p>Fires {@link ResearchEvent} if the page is not already incomplete.
	 *
	 * @param entry
	 * 		The research entry to reset.
	 */
	void reset(ResearchEntry entry);
	
	void setPlayer(EntityPlayer player);
	EntityPlayer getPlayer();
	
	/**
	 * Returns a map containing this researcher's data, where the keys are the keys of all sections
	 * that have a stage greater than 0 and the keys of every completed puzzle,and the values are the
	 * current stage of that entry, or "1" for a completed puzzle. Incomplete puzzles, and entries with
	 * 0 progress may be included in this map.
	 *
	 * @return A Map containing the data of this researcher.
	 */
	Map<ResourceLocation, Integer> getData();
	
	void setData(Map<ResourceLocation, Integer> data);
	
	default NBTBase serialize(){
		NBTTagCompound compound = new NBTTagCompound();
		getData().forEach((key, value) -> compound.setInteger(key.toString(), value));
		return compound;
	}
	
	default void deserialize(NBTTagCompound data){
		Map<ResourceLocation, Integer> dat = new HashMap<>();
		for(String s : data.getKeySet())
			dat.put(new ResourceLocation(s), data.getInteger(s));
		setData(dat);
	}
	
	static boolean canAdvance(Researcher r, ResearchEntry entry){
		if(visible(entry, r))
			if(entry.sections().size() > r.stage(entry))
				return entry.sections().get(r.stage(entry)).getRequirements().stream().allMatch(x -> x.satisfied(r.getPlayer()));
		// at maximum
		return false;
	}
	
	static void takeAndAdvance(Researcher r, ResearchEntry entry){
		if(canAdvance(r, entry)){
			entry.sections().get(r.stage(entry)).getRequirements().forEach(requirement -> requirement.take(r.getPlayer()));
			r.advance(entry);
		}
	}
	
	/**
	 * Returns a player's researcher capability, or null if there is no attached researcher capability.
	 *
	 * @param p
	 * 		The player to get a capability from.
	 * @return The player's researcher capability.
	 */
	static Researcher getFrom(EntityPlayer p){
		return p.getCapability(ResearcherCapability.RESEARCHER_CAPABILITY, null);
	}
	
	static boolean visible(ResearchEntry entry, Researcher r){
		// abridged version of ResearchBookGUI#style
		
		if(r.stage(entry) >= entry.sections().size())
			return true;
		if(r.stage(entry) > 0)
			return true;
		if(entry.meta().contains("root") && entry.parents().size() == 0)
			return true;
		if(!entry.meta().contains("hidden"))
			return entry.parents().stream().allMatch(x -> visible(ServerBooks.getEntry(x), r));
		return false;
	}
}