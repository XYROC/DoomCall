package xiroc.doomcall.tileentity;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import xiroc.doomcall.DoomCall;

public class TileEntityResourceGenerator extends TileEntity {

	private int ticker;

	@Override
	public void updateEntity() {
		ticker++;
		if (ticker == (Integer) DoomCall.config.variables.get("resourceGeneratorTime")) {
			ticker = 0;
			generate(new Random());
		}
		super.updateEntity();
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		NBTTagCompound tag = new NBTTagCompound();
		tag.setInteger("ticker", ticker);
		nbt.setTag("data", tag);
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		NBTTagCompound tag = nbt.getCompoundTag("data");
		ticker = tag.getInteger("ticker");
		System.out.println("ticker: " + ticker);
	}

	public void generate(Random random) {
		if (!worldObj.isRemote) {
			Block block = Blocks.coal_block;
			int type = 0;
			int i = random.nextInt(10);
			if (i > 5)
				type = 1;
			if (random.nextInt(2) == 0) {
				block = Blocks.iron_block;
			}
			if (type == 1) {
				int b = random.nextInt(8);
				if (b < 5)
					block = Blocks.iron_block;
				if (b == 5)
					block = Blocks.redstone_block;
				if (b == 6)
					block = Blocks.gold_block;
				if (b == 7)
					block = Blocks.diamond_ore;
			}
			switch (type) {
			case 0:
				if (this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == Blocks.air) {
					this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, block);
				}
				if (this.worldObj.getBlock(this.xCoord, this.yCoord + 2, this.zCoord) == Blocks.air) {
					this.worldObj.setBlock(this.xCoord, this.yCoord + 2, this.zCoord, block);
				}
				break;
			case 1:
				if (this.worldObj.getBlock(this.xCoord, this.yCoord + 1, this.zCoord) == Blocks.air) {
					this.worldObj.setBlock(this.xCoord, this.yCoord + 1, this.zCoord, block);
				}
				break;
			}
		}
		worldObj.playSoundEffect(xCoord + 0.5D, yCoord + 0.5D, zCoord + 0.5D, "random.fizz", 1.0F, 1.0F);
	}

	public int getSecondsToNextResource() {
		int i = (Integer) DoomCall.config.variables.get("resourceGeneratorTime");
		int maxTicks = i / 20;
		return maxTicks - (ticker / 20);
	}

	public String getNextResourceString() {
		int seconds = getSecondsToNextResource();
		String s = seconds + " seconds.";
		if(seconds == 1) s = "1 second.";
		if (seconds > 60) {
			double minutes = (double) seconds / 60.0D;
			String m = minutes+"";
			s = m.substring(0, 3)+" minutes.";
			if(minutes == 1.0) s = m.substring(0, 3)+" minute.";
		}
		return s;
	}

}
