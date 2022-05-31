package net.arcanamod.client.research;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.arcanamod.aspects.Aspect;
import net.arcanamod.client.gui.ClientUiUtil;
import net.arcanamod.client.research.impls.*;
import net.arcanamod.systems.research.EntrySection;
import net.arcanamod.systems.research.impls.*;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.client.gui.GuiUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class EntrySectionRenderer<T extends EntrySection>{
	static Map<String, EntrySectionRenderer<?>> map = new HashMap<>();

	protected List<Tooltip> tooltips = new ArrayList<>();
	
	public static void init(){
		map.put(StringSection.TYPE, new StringSectionRenderer());
		map.put(CraftingSection.TYPE, new CraftingSectionRenderer());
		map.put(SmeltingSection.TYPE, new SmeltingSectionRenderer());
		map.put(AlchemySection.TYPE, new AlchemySectionRenderer());
		map.put(ArcaneCraftingSection.TYPE, new ArcaneCraftingSectionRenderer());
		map.put(ImageSection.TYPE, new ImageSectionRenderer());
		map.put(AspectCombosSection.TYPE, new AspectCombosSectionRenderer());
	}

	public abstract void render(MatrixStack stack, T section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player);

	public abstract int span(T section, PlayerEntity player);
	
	/**
	 * Called when the mouse is clicked anywhere on the screen while this section is visible.
	 *  @param section
	 * 		The section that is visible.
	 * @param pageIndex
	 * 		The index within the section that is visible.
	 * @param screenWidth
 * 		The width of the screen.
	 * @param screenHeight
* 		The height of the screen.
	 * @param mouseX
* 		The x location of the mouse.
	 * @param mouseY
* 		The y location of the mouse.
	 * @param right
* 		Whether the section that is visible is on the left or right.
	 * @param player
	 */
	public boolean onClick(T section, int pageIndex, int screenWidth, int screenHeight, double mouseX, double mouseY, boolean right, PlayerEntity player){
		return false;
	}

	public void renderAfter(MatrixStack stack, T section, int pageIndex, int x, int y, int screenWidth, int screenHeight, int mouseX, int mouseY, PlayerEntity player){
		tooltips.forEach(tooltip -> tooltip.tryRender(stack, mouseX, mouseY, screenWidth, screenHeight));
		tooltips.clear();
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends EntrySection> EntrySectionRenderer<T> get(String type){
		return (EntrySectionRenderer<T>)map.get(type);
	}
	
	@SuppressWarnings("unchecked")
	public static <T extends EntrySection> EntrySectionRenderer<T> get(EntrySection type){
		return (EntrySectionRenderer<T>)map.get(type.getType());
	}

	protected Minecraft mc(){
		return Minecraft.getInstance();
	}
	
	protected FontRenderer fr(){
		return mc().fontRenderer;
	}



	public static abstract class Tooltip{
		int centerX, centerY, size;

		public Tooltip(int centerX, int centerY, int size) {
			this.centerX = centerX;
			this.centerY = centerY;
			this.size = size;
		}

		void tryRender(MatrixStack ms, int mouseX, int mouseY, int screenWidth, int screenHeight){
			if(mouseX >= centerX - size && mouseX < centerX + size && mouseY >= centerY - size && mouseY < centerY + size)
				render(ms, mouseX, mouseY, screenWidth, screenHeight);
		}

		abstract void render(MatrixStack ms, int mouseX, int mouseY, int screenWidth, int screenHeight);
	}

	public static class ItemTooltip extends Tooltip{
		ItemStack stack;

		public ItemTooltip(ItemStack stack, int centerX, int centerY) {
			super(centerX, centerY, 8);
			this.stack = stack;
		}

		void render(MatrixStack ms, int mouseX, int mouseY, int screenWidth, int screenHeight) {
			Minecraft mc = Minecraft.getInstance();
			GuiUtils.drawHoveringText(ms, new ArrayList<>(stack.getTooltip(mc.player, mc.gameSettings.advancedItemTooltips ? ITooltipFlag.TooltipFlags.ADVANCED : ITooltipFlag.TooltipFlags.NORMAL)), mouseX, mouseY, screenWidth, screenHeight, -1, mc.fontRenderer);
		}
	}

	public static class AspectTooltip extends Tooltip{
		Aspect aspect;

		public AspectTooltip(Aspect aspect, int centerX, int centerY) {
			this(aspect, centerX, centerY, 8);
		}

		public AspectTooltip(Aspect aspect, int centerX, int centerY, int size) {
			super(centerX, centerY, size);
			this.aspect = aspect;
		}

		void render(MatrixStack ms, int mouseX, int mouseY, int screenWidth, int screenHeight) {
			ClientUiUtil.drawAspectTooltip(ms, aspect, "", mouseX, mouseY, screenWidth, screenHeight);
		}
	}
}