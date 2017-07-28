package xiroc.doomcall.gui;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Mouse;

import doom.lib.gui.ElementDualScalePart;
import doom.lib.gui.ElementDualScaled;
import doom.lib.gui.ElementSimpleBar;
import doom.lib.gui.ElementSimpleScaled;
import doom.lib.gui.StringRenderer;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import xiroc.doomcall.energy.EnergyHelper;
import xiroc.doomcall.tileentity.TileEntityHVGenerator;

public class GuiHVGenerator extends GuiContainer {

	public static ResourceLocation gui = new ResourceLocation("doomcall:textures/gui/gui_generator_hv.png");
	public static ResourceLocation texture_nei = new ResourceLocation("doomcall:textures/gui/NEI_textures.png");

	private TileEntityHVGenerator te;

	public GuiHVGenerator(ContainerHVGenerator container, TileEntityHVGenerator tile) {
		super(container);
		this.te = tile;
	}

	@Override
	public void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		int x = Mouse.getX();
		int y = Mouse.getY();
		double maxRF = 500000;
		double rf = te.getEnergyStored(ForgeDirection.DOWN);
		double rf_p = rf / maxRF;
		int ySize_rf = (int) (rf_p * 40);
		double maxYellorium = 500;
		double yellorium = te.getYellorium();
		double yellorium_p = yellorium / maxYellorium;
		int ySize_yellorium = (int) (yellorium_p * 40);
		ElementSimpleScaled rf_bar = new ElementSimpleScaled(texture_nei, 16, 60 - ySize_rf, 12, ySize_rf, 17,
				1 + (40 - ySize_rf));
		rf_bar.drawElement(this);
		ElementSimpleScaled yellorium_bar = new ElementSimpleScaled(texture_nei, 34, 60 - ySize_yellorium, 12,
				ySize_yellorium, 46, 1 + (40 - ySize_yellorium));
		yellorium_bar.drawElement(this);
	}
	
	@Override
	public void drawScreen(int par1, int par2, float p_73863_3_) {
		super.drawScreen(par1, par2, p_73863_3_);
		int var5 = (this.width - this.xSize) / 2;
        int var6 = (this.height - this.ySize) / 2;
		if(par1 >= 15+var5 && par2 >= 19+var6 && par1 <= 28+var5 && par2 <= 60+var6){
			List t = new ArrayList<String>();
			t.add(te.getEnergyStored(ForgeDirection.DOWN)+"/"+te.getMaxEnergyStored(ForgeDirection.DOWN)+" RF");
			drawHoveringText(t, par1, par2, fontRendererObj);
		}
		
		if(par1 >= 33+var5 && par2 >= 19+var6 && par1 <= 47+var5 && par2 <= 60+var6){
			List t = new ArrayList<String>();
			t.add(te.getYellorium()+"/"+te.getMaxYellorium());
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
