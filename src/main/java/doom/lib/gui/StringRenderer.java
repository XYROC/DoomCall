package doom.lib.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.util.ResourceLocation;

public class StringRenderer {

	private ResourceLocation background = new ResourceLocation("doomcall:textures/gui/NEI_textures.png");

	private String text;

	private int xPos;
	private int yPos;
	private int color;

	public StringRenderer(String text, int x, int y, int color) {
		this.text = text;
		this.xPos = x;
		this.yPos = y;
		this.color = color;
	}

	public void drawElement(GuiScreen screen) {
		Minecraft mc = screen.mc;
		mc.renderEngine.bindTexture(background);
		int length = text.length() * 2;
		screen.drawTexturedModalRect(xPos - 2, yPos - 2, 0, 42, 3, 12);
		for (int i = 0; i < length; i++) {
			screen.drawTexturedModalRect(xPos - 2 + (3 * i), yPos - 2, 3, 42, 3, 12);
		}
		screen.drawTexturedModalRect(xPos - 2, yPos - 2, 5, 42, 3, 12);
		screen.drawString(mc.fontRenderer, text, xPos, yPos, color);
	}

}
