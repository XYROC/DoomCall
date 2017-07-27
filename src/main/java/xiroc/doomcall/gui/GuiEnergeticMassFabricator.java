package xiroc.doomcall.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import doom.lib.gui.ElementSimpleScaled;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.ForgeDirection;
import scala.actors.threadpool.Arrays;
import xiroc.doomcall.tileentity.TileEntityEnergeticMassFabricator;

public class GuiEnergeticMassFabricator extends GuiContainer {

	public static ResourceLocation gui = new ResourceLocation(
			"doomcall:textures/gui/gui_energetic_mass_fabricator.png");
	public static ResourceLocation texture_nei = new ResourceLocation("doomcall:textures/gui/NEI_textures.png");

	private TileEntityEnergeticMassFabricator tile;

	public GuiEnergeticMassFabricator(ContainerEnergeticMassFabricator container,
			TileEntityEnergeticMassFabricator tile) {
		super(container);
		this.tile = tile;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		//GuiButton
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		int x = Mouse.getX();
		int y = Mouse.getY();
		double maxRF = 1000000;
		double rf = tile.getEnergyStored(ForgeDirection.DOWN);
		double rf_p = rf / maxRF;
		int ySize_rf = (int) (rf_p * 40);
		double burn_p = tile.getField(0);
		int xSize_burnTime = (int) (burn_p * 34);
		ElementSimpleScaled rf_bar = new ElementSimpleScaled(texture_nei, 13, 57 - ySize_rf, 12, ySize_rf, 17,
				1 + (40 - ySize_rf));
		ElementSimpleScaled burnTimeBar = new ElementSimpleScaled(gui, 92, 27, xSize_burnTime, 27, 176, 0);
		rf_bar.drawElement(this);
		burnTimeBar.drawElement(this);		
	}
	
	
	@Override
	public void drawScreen(int par1, int par2, float p_73863_3_) {
		super.drawScreen(par1, par2, p_73863_3_);
		int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
		if(par1 >= 12+var5 && par2 >= 17+var6 && par1 <= 25+var5 && par2 <= 58+var6){
			List t = new ArrayList<String>();
			t.add(tile.getEnergyStored(ForgeDirection.DOWN)+"/"+tile.getMaxEnergyStored(ForgeDirection.DOWN)+" RF");
			drawHoveringText(t, par1, par2, fontRendererObj);
		}
	}
	

	@Override
	public void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		mc.renderEngine.bindTexture(gui);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		drawTexturedModalRect(k, l, 0, 0, xSize, ySize);
	}

}
