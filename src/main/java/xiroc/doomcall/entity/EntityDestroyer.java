package xiroc.doomcall.entity;

import net.minecraft.block.BlockLog;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityDestroyer extends EntityDriveable{
	
	public EntityDestroyer(World world) {
		super(world);
		this.setSize(3.5F, 2.2F);
	}
	
	public EntityDestroyer(World world, int x, int y, int z) {
		super(world, x, y ,z);
		this.setSize(3.5F, 2.2F);
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource src, float amount) {
		return false;
	}

	@Override
	public boolean isPushedByWater() {
		return false;
	}

	@Override
	public boolean isInWater() {
		return false;
	}

	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if (!this.worldObj.isRemote && onGround) {
			World w = this.worldObj;
			int x = this.serverPosX;
			int y = this.serverPosY;
			int z = this.serverPosZ;
			for (int i = 0; i < 3; i++) {
				for (int l = 0; l < 3; l++) {
					if (w.getBlock(x, y, z) != null) {
						if (w.getBlock(x + i, y, z + l).getBlockHardness(w, x + i, y, z + l) <= 2.1) {
							breakBlock(w, x+1, y+1, z+1, 0);
						}
					}
				}
			}
		}
	}

	@Override
	public void entityInit() {
		super.entityInit();
	}



	@Override
	public void readEntityFromNBT(NBTTagCompound nbt) {
	}


	@Override
	public void writeEntityToNBT(NBTTagCompound nbt) {
	}

}
