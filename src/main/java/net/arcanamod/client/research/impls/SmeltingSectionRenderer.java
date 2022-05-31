package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.gui.ResearchEntryScreen;
import net.arcanamod.systems.research.impls.CraftingSection;
import net.arcanamod.systems.research.impls.SmeltingSection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;

import static net.arcanamod.client.gui.ClientUiUtil.drawTexturedModalRect;
import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public class SmeltingSectionRenderer extends AbstractCraftingSectionRenderer<SmeltingSection>{
	void renderRecipe(MatrixStack matrices, IRecipe<?> recipe, SmeltingSection section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		if(recipe instanceof AbstractCookingRecipe){
			AbstractCookingRecipe cookingRecipe = (AbstractCookingRecipe)recipe;
			int centerX = x + PAGE_WIDTH / 2;
			int centerY = y + (int)(PAGE_HEIGHT * 0.6);
			mc().getTextureManager().bindTexture(textures);
			ClientUiUtil.drawScalable(matrices, TEXTURE_SCALING, centerX, centerY, 219, 1, 34, 62);
			ItemStack[] stacks = cookingRecipe.getIngredients().get(0).getMatchingStacks();
			ItemStack is = stacks[displayIndex(stacks.length, player)];
			ClientUiUtil.itemCentered(is, centerX, centerY);
			tooltips.add(new ItemTooltip(is, centerX, centerY));
		}else
			error();
	}
}
