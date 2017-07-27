package xiroc.doomcall.entity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityDriveable extends Entity{
	
	private EntityLivingBase mount;

	public EntityDriveable(World world, int x, int y, int z) {
		super(world);
		setPosition(x, y, z);
		preventEntitySpawning = true;
		this.isImmuneToFire = true;
		this.preventEntitySpawning = true;
		this.stepHeight = 1.5F;
		this.setSize(1F, 1F);
		
	}
	
	public EntityDriveable(World world) {
		super(world);
		preventEntitySpawning = true;
		this.isImmuneToFire = true;
		this.preventEntitySpawning = true;
		this.stepHeight = 1.5F;
		this.setSize(1F, 1F);
		
	}

	@Override
	public void entityInit() {
		
	}
	
	@Override
	public boolean interactFirst(EntityPlayer player) {
		if(ridingEntity == null){
			mount(player);
			return true;
		}
		return false;
		
		
	}
	
	private void mount(EntityPlayer player) {
		player.rotationYaw = this.rotationYaw;
		player.rotationPitch = this.rotationPitch;

		if (!this.worldObj.isRemote) {
			player.mountEntity(this);
		}
	}
	
	@Override
	public boolean attackEntityFrom(DamageSource damage, float amount) {
		if(worldObj.isRemote || isDead) return true;
		if(damage.damageType.equals("player") && damage.getEntity().onGround){
			return false;
		}
		return false;
	}
	
	@Override
	public void onEntityUpdate() {
		super.onEntityUpdate();
		if(ridingEntity != null){
			EntityPlayer p = (EntityPlayer) ridingEntity;
			this.moveEntity(p.motionX, 0, p.motionZ);
		}
	}
	
	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound p_70037_1_) {
		
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound p_70014_1_) {
		
	}
	
	public void breakBlock(World worldIn, int x, int y, int z, int fortune) {
	    Block block = worldIn.getBlock(x, y, z);
		ItemStack dropedItemStack = new ItemStack(block.getItemDropped(0, new Random(), fortune));
		EntityItem drop = new EntityItem(worldIn, x, y, z, dropedItemStack);
		worldIn.spawnEntityInWorld(drop);
		worldIn.setBlockToAir(x, y, z);
	}

}
