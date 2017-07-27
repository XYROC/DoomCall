package xiroc.doomcall.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

//hi

public class ModelDestroyer extends ModelBase
{
  //fields
    ModelRenderer caterpillar00;
    ModelRenderer caterpillar01;
    ModelRenderer caterpillar02;
    ModelRenderer caterpillar03;
    ModelRenderer caterpillar04;
    ModelRenderer caterpillar05;
    ModelRenderer caterpillar06;
    ModelRenderer caterpillar07;
    ModelRenderer caterpillar08;
    ModelRenderer caterpillar09;
    ModelRenderer caterpillar10;
    ModelRenderer caterpillar11;
    ModelRenderer caterpillar12;
    ModelRenderer caterpillar13;
    ModelRenderer caterpillar14;
    ModelRenderer cabin00;
    ModelRenderer cabin01;
    ModelRenderer cabin02;
    ModelRenderer cabin03;
    ModelRenderer cabin04;
    ModelRenderer cabin05;
    ModelRenderer cabin06;
    ModelRenderer shovel00;
    ModelRenderer shovel01;
    ModelRenderer shovel02;
  
  public ModelDestroyer()
  {
    textureWidth = 512;
    textureHeight = 512;
    
      caterpillar00 = new ModelRenderer(this, 0, 64);
      caterpillar00.addBox(0F, 0F, 0F, 16, 1, 48);
      caterpillar00.setRotationPoint(-24F, 23F, -24F);
      caterpillar00.setTextureSize(512, 512);
      caterpillar00.mirror = true;
      setRotation(caterpillar00, 0F, 0F, 0F);
      caterpillar01 = new ModelRenderer(this, 0, 64);
      caterpillar01.addBox(0F, 0F, 0F, 16, 1, 48);
      caterpillar01.setRotationPoint(8F, 23F, -24F);
      caterpillar01.setTextureSize(512, 512);
      caterpillar01.mirror = true;
      setRotation(caterpillar01, 0F, 0F, 0F);
      caterpillar02 = new ModelRenderer(this, 128, 0);
      caterpillar02.addBox(0F, 0F, 0F, 1, 10, 48);
      caterpillar02.setRotationPoint(-23F, 13F, -24F);
      caterpillar02.setTextureSize(512, 512);
      caterpillar02.mirror = true;
      setRotation(caterpillar02, 0F, 0F, 0F);
      caterpillar03 = new ModelRenderer(this, 128, 0);
      caterpillar03.addBox(0F, 0F, 0F, 1, 10, 48);
      caterpillar03.setRotationPoint(-10F, 13F, -24F);
      caterpillar03.setTextureSize(512, 512);
      caterpillar03.mirror = true;
      setRotation(caterpillar03, 0F, 0F, 0F);
      caterpillar04 = new ModelRenderer(this, 0, 64);
      caterpillar04.addBox(0F, 0F, 0F, 16, 1, 48);
      caterpillar04.setRotationPoint(-24F, 12F, -24F);
      caterpillar04.setTextureSize(512, 512);
      caterpillar04.mirror = true;
      setRotation(caterpillar04, 0F, 0F, 0F);
      caterpillar05 = new ModelRenderer(this, 0, 40);
      caterpillar05.addBox(0F, 0F, 0F, 12, 10, 1);
      caterpillar05.setRotationPoint(-22F, 13F, -25F);
      caterpillar05.setTextureSize(512, 512);
      caterpillar05.mirror = true;
      setRotation(caterpillar05, 0F, 0F, 0F);
      caterpillar06 = new ModelRenderer(this, 0, 40);
      caterpillar06.addBox(0F, 0F, 0F, 12, 10, 1);
      caterpillar06.setRotationPoint(-22F, 13F, 24F);
      caterpillar06.setTextureSize(512, 512);
      caterpillar06.mirror = true;
      setRotation(caterpillar06, 0F, 0F, 0F);
      caterpillar07 = new ModelRenderer(this, 128, 0);
      caterpillar07.addBox(0F, 0F, 0F, 1, 10, 48);
      caterpillar07.setRotationPoint(9F, 13F, -24F);
      caterpillar07.setTextureSize(512, 512);
      caterpillar07.mirror = true;
      setRotation(caterpillar07, 0F, 0F, 0F);
      caterpillar08 = new ModelRenderer(this, 128, 0);
      caterpillar08.addBox(0F, 0F, 0F, 1, 10, 48);
      caterpillar08.setRotationPoint(22F, 13F, -24F);
      caterpillar08.setTextureSize(512, 512);
      caterpillar08.mirror = true;
      setRotation(caterpillar08, 0F, 0F, 0F);
      caterpillar09 = new ModelRenderer(this, 0, 64);
      caterpillar09.addBox(0F, 0F, 0F, 16, 1, 48);
      caterpillar09.setRotationPoint(8F, 12F, -24F);
      caterpillar09.setTextureSize(512, 512);
      caterpillar09.mirror = true;
      setRotation(caterpillar09, 0F, 0F, 0F);
      caterpillar10 = new ModelRenderer(this, 0, 40);
      caterpillar10.addBox(0F, 0F, 0F, 12, 10, 1);
      caterpillar10.setRotationPoint(10F, 13F, -25F);
      caterpillar10.setTextureSize(512, 512);
      caterpillar10.mirror = true;
      setRotation(caterpillar10, 0F, 0F, 0F);
      caterpillar11 = new ModelRenderer(this, 0, 40);
      caterpillar11.addBox(0F, 0F, 0F, 12, 10, 1);
      caterpillar11.setRotationPoint(10F, 13F, 24F);
      caterpillar11.setTextureSize(512, 512);
      caterpillar11.mirror = true;
      setRotation(caterpillar11, 0F, 0F, 0F);
      caterpillar12 = new ModelRenderer(this, 0, 20);
      caterpillar12.addBox(0F, 0F, 0F, 18, 4, 7);
      caterpillar12.setRotationPoint(-9F, 16F, 8F);
      caterpillar12.setTextureSize(512, 512);
      caterpillar12.mirror = true;
      setRotation(caterpillar12, 0F, 0F, 0F);
      caterpillar13 = new ModelRenderer(this, 0, 20);
      caterpillar13.addBox(0F, 0F, 0F, 18, 4, 7);
      caterpillar13.setRotationPoint(-9F, 16F, -16F);
      caterpillar13.setTextureSize(512, 512);
      caterpillar13.mirror = true;
      setRotation(caterpillar13, 0F, 0F, 0F);
      caterpillar14 = new ModelRenderer(this, 0, 128);
      caterpillar14.addBox(0F, 0F, 0F, 8, 6, 46);
      caterpillar14.setRotationPoint(-4F, 10F, -23F);
      caterpillar14.setTextureSize(512, 512);
      caterpillar14.mirror = true;
      setRotation(caterpillar14, 0F, 0F, 0F);
      cabin00 = new ModelRenderer(this, 256, 0);
      cabin00.addBox(0F, 0F, 0F, 32, 2, 50);
      cabin00.setRotationPoint(-15F, 8F, -25F);
      cabin00.setTextureSize(512, 512);
      cabin00.mirror = true;
      setRotation(cabin00, 0F, 0F, 0F);
      cabin01 = new ModelRenderer(this, 0, 192);
      cabin01.addBox(0F, 0F, 0F, 2, 18, 50);
      cabin01.setRotationPoint(-15F, -10F, -25F);
      cabin01.setTextureSize(512, 512);
      cabin01.mirror = true;
      setRotation(cabin01, 0F, 0F, 0F);
      cabin02 = new ModelRenderer(this, 0, 192);
      cabin02.addBox(0F, 0F, 0F, 2, 18, 50);
      cabin02.setRotationPoint(15F, -10F, -25F);
      cabin02.setTextureSize(512, 512);
      cabin02.mirror = true;
      setRotation(cabin02, 0F, 0F, 0F);
      cabin03 = new ModelRenderer(this, 256, 0);
      cabin03.addBox(0F, 0F, 0F, 32, 2, 50);
      cabin03.setRotationPoint(-15F, -12F, -25F);
      cabin03.setTextureSize(512, 512);
      cabin03.mirror = true;
      setRotation(cabin03, 0F, 0F, 0F);
      cabin04 = new ModelRenderer(this, 192, 128);
      cabin04.addBox(0F, 0F, 0F, 28, 18, 2);
      cabin04.setRotationPoint(-13F, -10F, -27F);
      cabin04.setTextureSize(512, 512);
      cabin04.mirror = true;
      setRotation(cabin04, 0F, 0F, 0F);
      cabin05 = new ModelRenderer(this, 192, 128);
      cabin05.addBox(0F, 0F, 0F, 28, 18, 2);
      cabin05.setRotationPoint(-13F, -10F, 25.02222F);
      cabin05.setTextureSize(512, 512);
      cabin05.mirror = true;
      setRotation(cabin05, 0F, 0F, 0F);
      cabin06 = new ModelRenderer(this, 0, 8);
      cabin06.addBox(0F, 0F, 0F, 5, 4, 3);
      cabin06.setRotationPoint(-1F, -3F, -30F);
      cabin06.setTextureSize(512, 512);
      cabin06.mirror = true;
      setRotation(cabin06, 0F, 0F, 0F);
      shovel00 = new ModelRenderer(this, 0, 300);
      shovel00.addBox(0F, 0F, 0F, 29, 23, 2);
      shovel00.setRotationPoint(-13F, -7F, -32F);
      shovel00.setTextureSize(512, 512);
      shovel00.mirror = true;
      setRotation(shovel00, 0F, 0F, 0F);
      shovel01 = new ModelRenderer(this, 256, 256);
      shovel01.addBox(0F, 0F, 0F, 29, 10, 2);
      shovel01.setRotationPoint(-13F, -14F, -34F);
      shovel01.setTextureSize(512, 512);
      shovel01.mirror = true;
      setRotation(shovel01, 0F, 0F, 0F);
      shovel02 = new ModelRenderer(this, 256, 256);
      shovel02.addBox(0F, 0F, 0F, 29, 10, 2);
      shovel02.setRotationPoint(-13.02222F, 12F, -34F);
      shovel02.setTextureSize(512, 512);
      shovel02.mirror = true;
      setRotation(shovel02, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    caterpillar00.render(f5);
    caterpillar01.render(f5);
    caterpillar02.render(f5);
    caterpillar03.render(f5);
    caterpillar04.render(f5);
    caterpillar05.render(f5);
    caterpillar06.render(f5);
    caterpillar07.render(f5);
    caterpillar08.render(f5);
    caterpillar09.render(f5);
    caterpillar10.render(f5);
    caterpillar11.render(f5);
    caterpillar12.render(f5);
    caterpillar13.render(f5);
    caterpillar14.render(f5);
    cabin00.render(f5);
    cabin01.render(f5);
    cabin02.render(f5);
    cabin03.render(f5);
    cabin04.render(f5);
    cabin05.render(f5);
    cabin06.render(f5);
    shovel00.render(f5);
    shovel01.render(f5);
    shovel02.render(f5);
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
