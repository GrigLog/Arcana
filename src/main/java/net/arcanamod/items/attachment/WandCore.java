// Not an attachment, should refactor
// TODO: Why do we have common.items AND common.objects.items? I think we should go with the first only tbh, objects is meaningless.
package net.arcanamod.items.attachment;

import net.arcanamod.items.ItemWand;
import net.arcanamod.items.ArcanaItems;
import net.arcanamod.items.ItemBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class WandCore extends ItemBase{
	
	private final ItemWand wand;
	
	public WandCore(String name, ItemWand wand){
		super(name);
		this.wand = wand;
	}
	
	public ItemWand getWand(){
		return wand;
	}
	
	public ItemStack getWandWithAttachments(@Nonnull Cap cap){
		return getWandWithAttachments(cap, null);
	}
	
	public ItemStack getWandWithAttachments(@Nonnull Cap cap, @Nullable Focus focus){
		int c = cap.getID();
		int f = focus == null ? 0 : focus.getID();
		ItemStack stack = new ItemStack(getWand());
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new CompoundNBT());
		stack.getTagCompound().setInteger("cap", c);
		stack.getTagCompound().setInteger("focus", f);
		return stack;
	}
	
	public static ItemStack createWoodenWandWithAttachments(@Nonnull Cap cap){
		return createWoodenWandWithAttachments(cap, null);
	}
	
	public static ItemStack createWoodenWandWithAttachments(@Nonnull Cap cap, @Nullable Focus focus){
		int c = cap.getID();
		int f = focus == null ? 0 : focus.getID();
		ItemStack stack = new ItemStack(ArcanaItems.WOOD_WAND);
		if(stack.getTagCompound() == null)
			stack.setTagCompound(new CompoundNBT());
		stack.getTagCompound().setInteger("cap", c);
		stack.getTagCompound().setInteger("focus", f);
		return stack;
	}
}