package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.aspects.AspectStack;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.gui.ResearchEntryScreen;
import net.arcanamod.items.recipes.AlchemyRecipe;
import net.arcanamod.systems.research.impls.AlchemySection;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;

import java.util.List;

import static net.arcanamod.client.gui.ClientUiUtil.drawTexturedModalRect;
import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public class AlchemySectionRenderer extends AbstractCraftingSectionRenderer<AlchemySection>{
	void renderRecipe(MatrixStack matrices, IRecipe<?> recipe, AlchemySection section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		if(recipe instanceof AlchemyRecipe){
			AlchemyRecipe alchemyRecipe = (AlchemyRecipe)recipe;
			int centerX = x + PAGE_WIDTH / 2;
			int centerY = y + (int)(PAGE_HEIGHT * 0.6);
			mc().getTextureManager().bindTexture(textures);
			ClientUiUtil.drawScalable(matrices, TEXTURE_SCALING, centerX, centerY, 73, 1, 70, 70); //crucible
			ClientUiUtil.drawScalable(matrices, TEXTURE_SCALING, centerX - 20, centerY - 45, 23, 145, 17, 17); //arrow

			ItemStack[] stacks = alchemyRecipe.getIngredients().get(0).getMatchingStacks();
			ItemStack is = stacks[displayIndex(stacks.length, player)];
			ClientUiUtil.itemCentered(is, centerX - 45, centerY - 45);
			tooltips.add(new ItemTooltip(is, centerX - 45, centerY - 45));

			// Display aspects
			List<AspectStack> aspects = alchemyRecipe.getAspects();
			int aspectsWidth = Math.min(3, aspects.size());
			int aspectStartX = centerX - 10 * aspectsWidth;
			for(int i = 0, size = aspects.size(); i < size; i++){
				AspectStack aspect = aspects.get(i);
				int xx = aspectStartX + (i % aspectsWidth) * 20;
				int yy = centerY + (i / aspectsWidth) * 20;
				ClientUiUtil.renderAspectStack(matrices, aspect, xx, yy);
				tooltips.add(new AspectTooltip(aspect.getAspect(), xx + 8 , yy + 8));
			}
		}else
			error();
	}
}