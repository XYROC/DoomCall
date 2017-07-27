package xiroc.doomcall.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import xiroc.doomcall.model.ModelHeavyCoalGenerator;

public class RenderHeavyCoalGenerator extends TileEntitySpecialRenderer{

	private final ResourceLocation texture = new ResourceLocation("doomcall:textures/blocks/heavy_coal_generator.png");
	private final ModelHeavyCoalGenerator model;
	
	public RenderHeavyCoalGenerator()
	{
		this.model = new ModelHeavyCoalGenerator();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileEntity, double x, double y, double z, float scale)
	{
		GL11.glPushMatrix();
	        GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
	        Minecraft.getMinecraft().renderEngine.bindTexture(texture);
	        GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
	        this.model.render((Entity)null, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GL11.glPopMatrix();
	}
}