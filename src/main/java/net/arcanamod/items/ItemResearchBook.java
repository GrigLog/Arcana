package net.arcanamod.items;

import mcp.MethodsReturnNonnullByDefault;
import net.arcanamod.Arcana;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import javax.annotation.ParametersAreNonnullByDefault;

@MethodsReturnNonnullByDefault
@ParametersAreNonnullByDefault
public class ItemResearchBook extends ItemBase{
	
	ResourceLocation book;
	
	public ItemResearchBook(String name, ResourceLocation book){
		super(name);
		this.book = book;
		setMaxStackSize(1);
	}
	
	public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn){
		Arcana.proxy.openResearchBookUI(book);
		return new ActionResult<>(EnumActionResult.SUCCESS, playerIn.getHeldItem(handIn));
	}
}