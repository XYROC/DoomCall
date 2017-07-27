
package xiroc.doomcall.render;

import java.security.Security;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.API;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import xiroc.doomcall.model.ModelHeavyCoalGenerator;

public class RenderItemHeavyCoalGenerator implements IItemRenderer
{
	protected ModelHeavyCoalGenerator model = new ModelHeavyCoalGenerator();
	private final ResourceLocation texture = new ResourceLocation("doomcall:textures/blocks/heavy_coal_generator.png");
	
	@Override
	public boolean handleRenderType(ItemStack item, ItemRenderType type)
	{
		return true;
	}
	@Override
	public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
	{
		return true;
	}
	@Override
	public void renderItem(ItemRenderType type, ItemStack item, Object... data)
	{	
		if(type == ItemRenderType.INVENTORY)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(0.0F, -1.0F, 0.0F);
				GL11.glScalef(1.0F, 1.0F, 1.0F);
	
			    this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
			GL11.glPopMatrix();
		}
		else if(type == ItemRenderType.EQUIPPED)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(-0.5F, -2F, -0.2F);
				GL11.glScalef(1.5F, 1.5F, 1.5F);
	
	            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
	        GL11.glPopMatrix();
		}
		else if(type == ItemRenderType.EQUIPPED_FIRST_PERSON)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(-0.6F, -2.0F, -1.0F);
				GL11.glScalef(1.5F, 1.5F, 1.5F);
	
	            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
		}
		else if(type == ItemRenderType.ENTITY)
		{
			GL11.glPushMatrix();
				Minecraft.getMinecraft().renderEngine.bindTexture(texture);
				GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
				GL11.glRotatef(270F, 0.0F, -1.0F, 0.0F);
				GL11.glTranslatef(0.0F, -1.0F, -0.0F);
				GL11.glScalef(0.7F, 0.7F, 0.7F);
	
	            this.model.render((Entity)null, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);
            GL11.glPopMatrix();
		}
	}
}
