package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.gui.ResearchEntryScreen;
import net.arcanamod.systems.research.impls.CraftingSection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.ICraftingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraftforge.common.crafting.IShapedRecipe;

import static net.arcanamod.client.gui.ClientUiUtil.drawTexturedModalRect;
import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public class CraftingSectionRenderer extends AbstractCraftingSectionRenderer<CraftingSection>{
	void renderRecipe(MatrixStack matrices, IRecipe<?> recipe, CraftingSection section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		if(recipe instanceof ICraftingRecipe){
			int centerX = x + PAGE_WIDTH / 2;
			int centerY = y + (int)(PAGE_HEIGHT * 0.54);
			ICraftingRecipe craftingRecipe = (ICraftingRecipe)recipe;
			mc().getTextureManager().bindTexture(textures);
			ClientUiUtil.drawScalable(matrices, TEXTURE_SCALING, centerX, centerY, 145, 1, 72, 72);

			int width = recipe instanceof IShapedRecipe ? ((IShapedRecipe<?>)craftingRecipe).getRecipeWidth() : 3;
			int height = recipe instanceof IShapedRecipe ? ((IShapedRecipe<?>)craftingRecipe).getRecipeHeight() : 3;

			for(int xx = 0; xx < width; xx++)
				for(int yy = 0; yy < height; yy++){
					int index = xx + yy * width;
					if(index < recipe.getIngredients().size()){
						int itemX = centerX + (xx - 1) * 34;
						int itemY = centerY + (yy - 1) * 34;
						ItemStack[] stacks = recipe.getIngredients().get(index).getMatchingStacks();
						if(stacks.length > 0) {
							ItemStack is = stacks[displayIndex(stacks.length, player)];
							ClientUiUtil.itemCentered(is, itemX, itemY);
							tooltips.add(new ItemTooltip(is, itemX, itemY));
						}
					}
				}
		}else
			error();
	}
}
