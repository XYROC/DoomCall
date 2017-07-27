package xiroc.doomcall.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class ModelHeavyCoalGenerator extends ModelBase
{
  //fields
    ModelRenderer Wall1;
    ModelRenderer Wall2;
    ModelRenderer Bottom;
    ModelRenderer Roof;
    ModelRenderer Back;
    ModelRenderer Front;
  
  public ModelHeavyCoalGenerator()
  {
    textureWidth = 64;
    textureHeight = 128;
    
      Wall1 = new ModelRenderer(this, 0, 0);
      Wall1.addBox(0F, 0F, 0F, 3, 10, 16);
      Wall1.setRotationPoint(-8F, 14F, -8F);
      Wall1.setTextureSize(64, 128);
      Wall1.mirror = true;
      setRotation(Wall1, 0F, 0F, 0F);
      Wall2 = new ModelRenderer(this, 0, 0);
      Wall2.addBox(0F, 0F, 0F, 3, 10, 16);
      Wall2.setRotationPoint(5F, 14F, -8F);
      Wall2.setTextureSize(64, 128);
      Wall2.mirror = true;
      setRotation(Wall2, 0F, 0F, 0F);
      Bottom = new ModelRenderer(this, 0, 68);
      Bottom.addBox(0F, 0F, 0F, 10, 2, 16);
      Bottom.setRotationPoint(-5F, 22F, -8F);
      Bottom.setTextureSize(64, 128);
      Bottom.mirror = true;
      setRotation(Bottom, 0F, 0F, 0F);
      Roof = new ModelRenderer(this, 0, 28);
      Roof.addBox(0F, 0F, 0F, 16, 2, 16);
      Roof.setRotationPoint(-8F, 12F, -8F);
      Roof.setTextureSize(64, 128);
      Roof.mirror = true;
      setRotation(Roof, 0F, 0F, 0F);
      Back = new ModelRenderer(this, 0, 58);
      Back.addBox(0F, 0F, 0F, 10, 8, 1);
      Back.setRotationPoint(-5F, 14F, -7F);
      Back.setTextureSize(64, 128);
      Back.mirror = true;
      setRotation(Back, 0F, 0F, 0F);
      Front = new ModelRenderer(this, 0, 48);
      Front.addBox(0F, 0F, 0F, 10, 8, 1);
      Front.setRotationPoint(-5F, 14F, 6F);
      Front.setTextureSize(64, 128);
      Front.mirror = true;
      setRotation(Front, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Wall1.render(f5);
    Wall2.render(f5);
    Bottom.render(f5);
    Roof.render(f5);
    Back.render(f5);
    Front.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
