package net.arcanamod.client.research.impls;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.research.EntrySectionRenderer;
import net.arcanamod.systems.research.impls.ImageSection;
import net.minecraft.entity.player.PlayerEntity;

import static net.arcanamod.client.gui.ResearchEntryScreen.*;

public class ImageSectionRenderer extends EntrySectionRenderer<ImageSection>{
	public void render(MatrixStack stack, ImageSection section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player) {
		mc().getTextureManager().bindTexture(section.getImage());
		ClientUiUtil.drawScalable(stack, TEXTURE_SCALING, x + PAGE_WIDTH / 2, y + PAGE_WIDTH / 2, 0, 0, 105, 155);
	}

	public int span(ImageSection section, PlayerEntity player){
		return 1;
	}
}