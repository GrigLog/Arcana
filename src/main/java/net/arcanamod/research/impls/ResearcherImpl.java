package net.arcanamod.research.impls;

import net.arcanamod.research.Puzzle;
import net.arcanamod.research.ResearchBooks;
import net.arcanamod.research.ResearchEntry;
import net.arcanamod.research.Researcher;
import net.arcanamod.event.ResearchEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;

import java.util.*;

public class ResearcherImpl implements Researcher{
	
	protected Map<ResourceLocation, Integer> data = new HashMap<>();
	protected Set<ResourceLocation> completePuzzles = new HashSet<>();
	protected PlayerEntity player;
	
	public int entryStage(ResearchEntry entry){
		Objects.requireNonNull(entry, "Tried to get the stage of a null research entry. Does a research entry reference a parent that doesn't exist?");
		return data.getOrDefault(entry.key(), 0);
	}
	
	public boolean isPuzzleCompleted(Puzzle puzzle){
		return completePuzzles.contains(puzzle.getKey());
	}
	
	public void advanceEntry(ResearchEntry entry){
		// whether or not we can advance is already checked
		do{
			// increment stage
			data.put(entry.key(), entryStage(entry) + 1);
			// as long as there are more stages
			// and the current stage has no requirements
			// this ends up on entry.sections().size(); an entry with 1 section is on stage 0 by default and can be incremented to 1.
			// TODO: don't skip through addenda
		}while(entryStage(entry) < entry.sections().size() && entry.sections().get(entryStage(entry)).getRequirements().size() == 0);
		MinecraftForge.EVENT_BUS.post(new ResearchEvent(getPlayer(), this, entry, ResearchEvent.Type.ADVANCE));
		// if this research is being completed,
		// advance all children too, but only if they have no requirements on their first stage
		if(entryStage(entry) == entry.sections().size())
			ResearchBooks.streamChildrenOf(entry).filter(x -> x.sections().get(0).getRequirements().isEmpty()).filter(x -> entryStage(x) == 0).forEach(this::advanceEntry);
	}
	
	public void completePuzzle(Puzzle puzzle){
		completePuzzles.add(puzzle.getKey());
	}
	
	public void resetPuzzle(Puzzle puzzle){
		completePuzzles.remove(puzzle.getKey());
	}
	
	public void completeEntry(ResearchEntry entry){
		if(entryStage(entry) < entry.sections().size()){
			data.put(entry.key(), entry.sections().size());
			MinecraftForge.EVENT_BUS.post(new ResearchEvent(getPlayer(), this, entry, ResearchEvent.Type.COMPLETE));
		}
	}
	
	public void resetEntry(ResearchEntry entry){
		if(entryStage(entry) > 0){
			data.remove(entry.key());
			MinecraftForge.EVENT_BUS.post(new ResearchEvent(getPlayer(), this, entry, ResearchEvent.Type.RESET));
		}
	}
	
	public Map<ResourceLocation, Integer> getEntryData(){
		return Collections.unmodifiableMap(data);
	}
	
	public void setEntryData(Map<ResourceLocation, Integer> data){
		this.data.clear();
		this.data.putAll(data);
	}
	
	public Set<ResourceLocation> getPuzzleData(){
		return Collections.unmodifiableSet(completePuzzles);
	}
	
	public void setPuzzleData(Set<ResourceLocation> data){
		completePuzzles.clear();
		completePuzzles.addAll(data);
	}
	
	public void setPlayer(PlayerEntity player){
		this.player = player;
	}
	
	public PlayerEntity getPlayer(){
		return player;
	}
}
