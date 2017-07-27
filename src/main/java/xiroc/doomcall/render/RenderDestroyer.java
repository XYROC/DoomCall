package xiroc.doomcall.render;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import xiroc.doomcall.entity.EntityDestroyer;
import xiroc.doomcall.model.ModelDestroyer;

public class RenderDestroyer extends RenderLiving{

	public RenderDestroyer() {
		super(new ModelDestroyer(), 2);
	}

	@Override
	public ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("doomcall:textures/entity/texture_destroyer.png");
	}


}
