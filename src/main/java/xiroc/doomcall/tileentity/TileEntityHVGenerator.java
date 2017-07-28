package xiroc.doomcall.tileentity;

import doom.lib.LibReference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.ForgeDirection;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.gui.ContainerHVGenerator;

public class TileEntityHVGenerator extends TileEntityBasicGenerator implements ISidedInventory {

	public ItemStack[] items = new ItemStack[3];

	private double yellorium = 0;
	private int maxYellorium = 500;
	private double rf = 0;
	
	boolean yelloriumE;
	boolean uranium;

	private int ticker = 0;

	public TileEntityHVGenerator() {
		super(570, 330, 500000);
		yelloriumE = OreDictionary.doesOreNameExist("ingotYellorium");
		uranium = OreDictionary.doesOreNameExist("ingotUranium");
	}

	public TileEntityHVGenerator(int output, int generated) {
		super(output, generated, 500000);
		yelloriumE = OreDictionary.doesOreNameExist("ingotYellorium");
		uranium = OreDictionary.doesOreNameExist("ingotUranium");
	}

	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public void generate() {
		// if (worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord)
		// > 7) {
		if (yellorium > 0 && getEnergyStored(ForgeDirection.DOWN) < 500000) {
			ticker++;
			if (ticker == 10) {
				ticker = 0;
				yellorium--;
			}
			storage.modifyEnergyStored(generated);
			return;
		}
	}
	

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		System.out.println("Saving to NBT: [" + yellorium + ";" + getEnergyStored(ForgeDirection.DOWN) + "]");
		nbt.setDouble(LibReference.yellorium_tag, getYellorium());
		nbt.setDouble(LibReference.rf_tag, getEnergyStored(ForgeDirection.DOWN));
		NBTTagList nbttaglist = new NBTTagList();

		for (int i = 0; i < this.items.length; ++i) {
			if (this.items[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.items[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		nbt.setTag("Items", nbttaglist);
	}

	public void setRF(double rf) {
		this.rf = rf;
	}

	public double getRF() {
		return rf;
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		//setYellorium(nbt.getDouble(yellorium_tag));
		//setRF(nbt.getDouble(rf_tag));
		//storage.setEnergyStored((int) getRF());
		System.out.println("Read from NBT: [" + storage.getEnergyStored() + ";" + rf + "]");
		NBTTagList nbttaglist = nbt.getTagList("Items", 10);
		this.items = new ItemStack[this.getSizeInventory()];

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = nbttaglist.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("Slot");

			if (b0 >= 0 && b0 < this.items.length) {
				this.items[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}
	}

	@Override
	public void updateEntity() {
		super.updateEntity();
		ItemStack item = (ItemStack) getStackInSlot(0);
		if (item != null) {
			
			if (yelloriumE) {
				if (OreDictionary.getOreID(item) == OreDictionary.getOreID("ingotYellorium")) {
					if (getYellorium() <= 250) {
						decrStackSize(0, 1);
						setYellorium(getYellorium() + 250);
						return;
					}
				}
			} else if (uranium) {
				if (OreDictionary.getOreID(item) == OreDictionary.getOreID("ingotUranium")) {
					if (getYellorium() <= 250) {
						decrStackSize(0, 1);
						setYellorium(getYellorium() + 250);
						return;
					}
				}
			} else {
				if (item.getItem() == Items.redstone) {
					if (getYellorium() <= 250) {
						decrStackSize(0, 1);
						setYellorium(getYellorium() + 250);
						return;
					}
				}
			}
		}
	}

	public double getYellorium() {
		return yellorium;
	}
	
	public int getMaxYellorium() {
		return maxYellorium;
	}

	public void setYellorium(double yellorium) {
		this.yellorium = yellorium;
	}

	@Override
	public int getBlockMetadata() {
		return super.getBlockMetadata();
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		if (from != ForgeDirection.UP)
			return true;
		else
			return false;
	}

	@Override
	public ItemStack getStackInSlot(int p_70301_1_) {
		return items[p_70301_1_];
	}

	@Override
	public ItemStack decrStackSize(int p_70298_1_, int p_70298_2_) {
		if (this.items[p_70298_1_] != null) {
			ItemStack itemstack;

			if (this.items[p_70298_1_].stackSize <= p_70298_2_) {
				itemstack = this.items[p_70298_1_];
				this.items[p_70298_1_] = null;
				return itemstack;
			} else {
				itemstack = this.items[p_70298_1_].splitStack(p_70298_2_);
				if (this.items[p_70298_1_].stackSize == 0) {
					this.items[p_70298_1_] = null;
				}

				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int p_70304_1_) {
		if (this.items[p_70304_1_] != null) {
			ItemStack itemstack = this.items[p_70304_1_];
			this.items[p_70304_1_] = null;
			return itemstack;
		} else {
			return null;
		}
	}

	@Override
	public void setInventorySlotContents(int p_70299_1_, ItemStack p_70299_2_) {
		this.items[p_70299_1_] = p_70299_2_;

		if (p_70299_2_ != null && p_70299_2_.stackSize > this.getInventoryStackLimit()) {
			p_70299_2_.stackSize = this.getInventoryStackLimit();
		}

	}

	@Override
	public String getInventoryName() {
		return "HV Generator";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {
	}

	@Override
	public void closeInventory() {
	}

	public boolean isItemFuel(ItemStack item) {
		boolean yellorium = OreDictionary.doesOreNameExist("ingotYellorium");
		boolean uranium = OreDictionary.doesOreNameExist("ingotUranium");
		if (!yellorium && !uranium)
			return false;
		if (OreDictionary.getOreID(item) == OreDictionary.getOreID("ingotYellorium"))
			return true;
		if (OreDictionary.getOreID(item) == OreDictionary.getOreID("ingotUranium"))
			return true;
		return false;
	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if (slot == 0) {
			if (isItemFuel(stack))
				return true;
			return false;
		}
		return false;
	}

	@Override
	public int[] getAccessibleSlotsFromSide(int p_94128_1_) {
		return null;
	}

	@Override
	public boolean canInsertItem(int p_102007_1_, ItemStack p_102007_2_, int p_102007_3_) {
		return this.isItemValidForSlot(p_102007_1_, p_102007_2_);
	}

	@Override
	public boolean canExtractItem(int p_102008_1_, ItemStack p_102008_2_, int p_102008_3_) {
		return false;
	}

}
