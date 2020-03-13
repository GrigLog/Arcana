package net.kineticdevelopment.arcana.core.research;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.util.ResourceLocation;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

/**
 * Represents a whole research book, such as the Arcanum or Tainted Codex.
 * Contains a number of research categories, stored by key.
 */
public class ResearchBook{
	
	protected Map<ResourceLocation, ResearchCategory> categories;
	private ResourceLocation key;
	
	public ResearchBook(ResourceLocation key, Map<ResourceLocation, ResearchCategory> categories){
		this.categories = categories;
		this.key = key;
	}
	
	public ResearchCategory getCategory(ResourceLocation key){
		return categories.get(key);
	}
	
	public List<ResearchCategory> getCategories(){
		return new ArrayList<>(categories.values());
	}
	
	public Stream<ResearchCategory> streamCategories(){
		return categories.values().stream();
	}
	
	public Stream<ResearchEntry> streamEntries(){
		return streamCategories().flatMap(ResearchCategory::streamEntries);
	}
	
	public List<ResearchEntry> getEntries(){
		return streamEntries().collect(Collectors.toList());
	}
	
	public ResearchEntry getEntry(ResourceLocation key){
		return streamEntries().filter(entry -> entry.key().equals(key)).findFirst().orElse(null);
	}
	
	public ResourceLocation getKey(){
		return key;
	}
	
	public Map<ResourceLocation, ResearchCategory> getCategoriesMap(){
		return Collections.unmodifiableMap(categories);
	}
	
	
	public NBTTagCompound serialize(ResourceLocation tag){
		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setString("id", tag.toString());
		NBTTagList list = new NBTTagList();
		categories.forEach((location, category) -> list.appendTag(category.serialize(location)));
		nbt.setTag("categories", list);
		return nbt;
	}
	
	public static ResearchBook deserialize(NBTTagCompound nbt){
		ResourceLocation key = new ResourceLocation(nbt.getString("id"));
		NBTTagList categoryList = nbt.getTagList("categories", 10);
		// need to have a book to put them *in*
		// book isn't in ClientBooks until all categories have been deserialized, so this is needed
		Map<ResourceLocation, ResearchCategory> c = new LinkedHashMap<>();
		ResearchBook book = new ResearchBook(key, c);
		
		Map<ResourceLocation, ResearchCategory> categories = StreamSupport.stream(categoryList.spliterator(), false)
				.map(NBTTagCompound.class::cast)
				.map(nbt1 -> ResearchCategory.deserialize(nbt1, book))
				.collect(Collectors.toMap(ResearchCategory::getKey, Function.identity(), (a, b) -> a));
		
		// this could be replaced by adding c to ClientBooks before deserializing, but it wouldn't be very different
		// and would leave a broken book in if an exception occurs.
		c.putAll(categories);
		return book;
	}
}