package xiroc.doomcall.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;

public class GuiItemCrate extends GuiContainer {

	public static final ResourceLocation res = new ResourceLocation("doomcall:textures/gui/gui_item_crate.png");

	public GuiItemCrate(Container p_i1072_1_) {
		super(p_i1072_1_);
	}

	@Override
	public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		mc.renderEngine.bindTexture(res);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

}
