package xiroc.doomcall.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;

public class ModelCable extends ModelBase{
	
	public static ModelCable instance = new ModelCable();
	
	ModelRenderer middle;
	ModelRenderer westClosing;
	ModelRenderer eastClosing;
	ModelRenderer east;
	ModelRenderer west;
	ModelRenderer north;
	ModelRenderer northClosed;
	ModelRenderer south;
	ModelRenderer southClosed;
	ModelRenderer up;
	ModelRenderer upClosed;
	ModelRenderer down;
	ModelRenderer downClosed;
	
	public ModelCable() {
		textureWidth = 32;
		textureHeight = 32;
		
		middle = new ModelRenderer(this, 0, 0);
		middle.addBox(0, 0, 0, 4, 4, 4);
		middle.setRotationPoint(-2F, 14F, -2F);
		middle.setTextureSize(32, 32);
		middle.mirror = true;
		setRotation(middle, 0F, 0F, 0F);
		westClosing = new ModelRenderer(this, 0, 0);
		westClosing.addBox(0, 0, 0, 1, 6, 6);
		westClosing.setRotationPoint(7F, 13F, -3F);
		westClosing.setTextureSize(32, 32);
		westClosing.mirror = true;
		setRotation(westClosing, 0, 0, 0);
	}
	
	public void setRotation(ModelRenderer modelRenderer, float x, float y, float z){
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}
