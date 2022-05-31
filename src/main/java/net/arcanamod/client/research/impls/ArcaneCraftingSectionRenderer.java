package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.aspects.Aspect;
import net.arcanamod.aspects.Aspects;
import net.arcanamod.aspects.UndecidedAspectStack;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.gui.ResearchEntryScreen;
import net.arcanamod.items.recipes.IArcaneCraftingRecipe;
import net.arcanamod.systems.research.impls.ArcaneCraftingSection;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.crafting.IShapedRecipe;

import java.util.Collections;

import static net.arcanamod.client.gui.ClientUiUtil.drawTexturedModalRect;
import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public class ArcaneCraftingSectionRenderer extends AbstractCraftingSectionRenderer<ArcaneCraftingSection>{
	void renderRecipe(MatrixStack matrices, IRecipe<?> recipe, ArcaneCraftingSection section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		if(recipe instanceof IArcaneCraftingRecipe){
			IArcaneCraftingRecipe craftingRecipe = (IArcaneCraftingRecipe)recipe;
			int centerX = x + PAGE_WIDTH / 2;
			int centerY = y + (int)(PAGE_HEIGHT * 0.54);
			mc().getTextureManager().bindTexture(textures);
			ClientUiUtil.drawScalable(matrices, TEXTURE_SCALING, centerX, centerY, 73, 75, 84, 84);

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
			// Display aspects
			UndecidedAspectStack[] stacks = craftingRecipe.getAspectStacks();
			// 1 aspect -> 0, 2-3 aspects -> 3 spacing, 4-5 aspects -> 2 spacing, 6 aspects -> 1 spacing
			int spacing = (stacks.length == 1) ? 0 : (stacks.length >= 6) ? 1 : (stacks.length < 4) ? 3 : 2;
			int aspectX = centerX - (craftingRecipe.getAspectStacks().length * (16 + spacing * 2)) / 2 - 4;
			int aspectY = centerY + 62;
			// Shadow behind the aspects for readability
			for(int i = 0, length = stacks.length; i < length; i++){
				UndecidedAspectStack stack = stacks[i];
				Aspect display = stack.any ? Aspects.EXCHANGE : stack.stack.getAspect();
				float amount = stack.stack.getAmount();
				int newAspectX = aspectX + i * (16 + 2 * spacing) + spacing;
				ClientUiUtil.renderAspectStack(matrices, display, amount, newAspectX, aspectY);
				tooltips.add(new AspectTooltip(display, newAspectX + 8, aspectY + 8));
			}
		}else
			error();
	}
}
