package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.aspects.Aspect;
import net.arcanamod.aspects.Aspects;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.gui.ResearchEntryScreen;
import net.arcanamod.client.research.EntrySectionRenderer;
import net.arcanamod.systems.research.ResearchBook;
import net.arcanamod.systems.research.ResearchBooks;
import net.arcanamod.systems.research.impls.AspectCombosSection;
import net.arcanamod.util.Pair;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;

import java.util.List;

import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public class AspectCombosSectionRenderer extends EntrySectionRenderer<AspectCombosSection>{

	protected ResourceLocation textures = null;

	public void render(MatrixStack stack, AspectCombosSection section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		ResearchBook book = ResearchBooks.getEntry(section.getEntry()).category().book();
		// don't make a new rloc every frame
		if(textures == null || !textures.getNamespace().equals(book.getKey().getNamespace()))
			textures = new ResourceLocation(book.getKey().getNamespace(), "textures/gui/research/" + book.getPrefix() + ResearchEntryScreen.OVERLAY_SUFFIX);

		List<Pair<Aspect, Aspect>> list = Aspects.COMBOS_AS_LIST;
		x += 15;
		for(int i = pageIndex * 5, size = list.size(); i < size && i < (pageIndex + 1) * 5; i++){
			Pair<Aspect, Aspect> pair = list.get(i);
			int dispIndex = i - pageIndex * 5;
			ClientUiUtil.renderAspectScalable(stack, TEXTURE_SCALING, pair.getFirst(), x, y + 43 * dispIndex);
			ClientUiUtil.renderAspectScalable(stack, TEXTURE_SCALING, pair.getSecond(), x + 60, y + 43 * dispIndex);
			ClientUiUtil.renderAspectScalable(stack, TEXTURE_SCALING, Aspects.COMBINATIONS.get(pair), x + 120, y + 43 * dispIndex);
			mc().getTextureManager().bindTexture(textures);
			ClientUiUtil.drawScalable(stack, TEXTURE_SCALING, x + 30, y + 43 * dispIndex, 105, 161, 12, 13);
			ClientUiUtil.drawScalable(stack, TEXTURE_SCALING, x + 90, y + 43 * dispIndex, 118, 161, 12, 13);
			tooltips.add(new AspectTooltip(pair.getFirst(), x, y + 43 * dispIndex, 15));
			tooltips.add(new AspectTooltip(pair.getSecond(), x + 60, y + 43 * dispIndex, 15));
			tooltips.add(new AspectTooltip(Aspects.COMBINATIONS.get(pair), x + 120, y + 43 * dispIndex, 15));
		}
	}
	
	public int span(AspectCombosSection section, PlayerEntity player){
		// how many aspects fit on a page? lets say 3 for now
		return (int)Math.ceil(Aspects.COMBINATIONS.size() / 5f);
	}
}