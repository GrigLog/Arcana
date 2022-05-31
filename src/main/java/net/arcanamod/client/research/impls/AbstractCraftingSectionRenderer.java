package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import javafx.scene.control.Tooltip;
import net.arcanamod.aspects.Aspect;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.gui.ResearchEntryScreen;
import net.arcanamod.client.research.EntrySectionRenderer;
import net.arcanamod.systems.research.ResearchBook;
import net.arcanamod.systems.research.ResearchBooks;
import net.arcanamod.systems.research.impls.AbstractCraftingSection;
import net.minecraft.client.Minecraft;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.gui.GuiUtils;

import javax.annotation.Nonnull;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public abstract class AbstractCraftingSectionRenderer<T extends AbstractCraftingSection> extends EntrySectionRenderer<T>{
	protected ResourceLocation textures = null;

	public void render(MatrixStack stack, T section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		// if recipe exists: render result at specified position, defer drawing recipe
		// otherwise: render error message
		ResearchBook book = ResearchBooks.getEntry(section.getEntry()).category().book();
		// don't make a new RLoc every frame
		if(textures == null || !textures.getNamespace().equals(book.getKey().getNamespace()))
			textures = new ResourceLocation(book.getKey().getNamespace(), "textures/gui/research/" + book.getPrefix() + ResearchEntryScreen.OVERLAY_SUFFIX);
		Optional<? extends IRecipe<?>> optRecipe = player.world.getRecipeManager().getRecipe(section.getRecipe());
		optRecipe.ifPresent(recipe -> {
			// draw result
			ItemStack result = recipe.getRecipeOutput();
			renderResult(stack, x, y, result, screenWidth, screenHeight);
			renderRecipe(stack, recipe, section, pageIndex, x, y, screenWidth, screenHeight, mouseX, mouseY, player);
		});
		// else display error
		if(!optRecipe.isPresent())
			error();
	}

	abstract void renderRecipe(MatrixStack matrices, IRecipe<?> recipe, T section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player);

	private void renderResult(MatrixStack stack, int x, int y, ItemStack result, int screenWidth, int screenHeight){
		mc().getTextureManager().bindTexture(textures);
		int centerX = x + PAGE_WIDTH / 2;
		int centerY = y + 30;
		ClientUiUtil.drawScalable(stack, TEXTURE_SCALING, centerX, centerY, 1, 167, 58, 20);
		ClientUiUtil.itemCentered(result, centerX, centerY);
		tooltips.add(new ItemTooltip(result, centerX, centerY));
		int textX = centerX - fr().getStringWidth(result.getTextComponent().getString()) / 2 + 5;
		int textY = y;
		fr().drawString(stack, result.getDisplayName().getString(), textX, textY, 0);
		RenderSystem.color4f(1f, 1f, 1f, 1f);
		RenderSystem.enableBlend();
		RenderSystem.disableLighting();
	}
	
	public int span(T section, PlayerEntity player){
		return 1;
	}
	
	protected void error(){
		// display error
	}
	
	protected int displayIndex(int max, @Nonnull Entity player){
		return (player.ticksExisted / 30) % max;
	}
}