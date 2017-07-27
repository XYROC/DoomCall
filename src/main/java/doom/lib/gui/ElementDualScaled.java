package doom.lib.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ElementDualScaled {
	
	// Vertical use only

	private ResourceLocation texture;

	private ElementDualScalePart background;
	private ElementDualScalePart foreground;

	private int xSize;
	private int ySize;
	private int xPos;
	private int yPos;
	private int maxAmount;
	private int amount;

	public ElementDualScaled(ResourceLocation texture, ElementDualScalePart background, ElementDualScalePart foreground, int xPos, int yPos, int xSize, int ySize, int maxAmount, int amount) {
		this.texture = texture;
		this.background = background;
		this.foreground = foreground;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.maxAmount = maxAmount;
		this.amount = amount;
	}


	public void drawElement(GuiScreen screen) {
		Minecraft mc = screen.mc;
		mc.renderEngine.bindTexture(texture);
		screen.drawTexturedModalRect(xPos, yPos, xSize, ySize, background.textureX, background.textureY);
		screen.drawTexturedModalRect(xPos, yPos+(maxAmount-amount), xSize, amount, foreground.textureX, foreground.textureY+amount);
		
	}

}
