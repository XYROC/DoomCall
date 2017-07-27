package xiroc.doomcall.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import xiroc.doomcall.DoomCall;

public class BlockPackage extends Block{

	public BlockPackage() {
		super(Material.cloth);
		setBlockName("package");
		setCreativeTab(DoomCall.creativeTab);
	}
	
	/*public void readFromNBT(ItemStack stack) {
		super.readFromNBT(stack);
		NBTTagCompound nbt = stack.getTagCompound();
		NBTTagList list = nbt.getTagList("items", 10);
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			NBTTagCompound nbttagcompound1 = list.getCompoundTagAt(i);
			byte b0 = nbttagcompound1.getByte("slot");
			if (b0 >= 0 && b0 < this.inv.getSizeInventory()) {
				inv.setInventorySlotContents(i, ItemStack.loadItemStackFromNBT(nbttagcompound1));
			}
		}
	}

	public void writeToNBT(ItemStack stack) {
		super.writeToNBT(stack);
		NBTTagCompound nbt = stack.getTagCompound();
		NBTTagList list = new NBTTagList();
		for (int i = 0; i < inv.getSizeInventory(); ++i) {
			if (inv.getStackInSlot(i) != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				inv.getStackInSlot(i).writeToNBT(nbttagcompound1);
				list.appendTag(nbttagcompound1);
			}
		}
		
		nbt.setTag("items", list);
	}*/

}
