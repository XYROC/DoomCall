package doom.lib.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;

public class ElementSimpleBar {
	
	private ResourceLocation texture;
	
	private int xPos;
	private int yPos;
	private int xSize;
	private int ySize;
	private int textureX;
	private int textureY;
	
	public ElementSimpleBar(ResourceLocation texture, int xPos, int yPos, int xSize, int ySize, int textureX, int textureY) {
		this.texture = texture;
		this.xPos = xPos;
		this.yPos = yPos;
		this.xSize = xSize;
		this.ySize = ySize;
		this.textureX = textureX;
		this.textureY = textureY;
	}
	
	public void drawElement(GuiScreen screen){
		Minecraft mc = screen.mc;
		mc.renderEngine.bindTexture(texture);
		screen.drawTexturedModalRect(xPos, yPos, xSize, ySize, textureX, textureY);
	}
	
	public int getyPos() {
		return yPos;
	}
	
	public int getxPos() {
		return xPos;
	}
	
	public int getxSize() {
		return xSize;
	}
	
	public int getySize() {
		return ySize;
	}

}
