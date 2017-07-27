package xiroc.doomcall.tileentity;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityItemCrateReinforced extends TileEntityItemCrate{
	
	public TileEntityItemCrateReinforced() {
		inventory = new ItemStack[21];
	}
	
	@Override
	public String getInventoryName() {
		return this.hasCustomInventoryName() ? this.customName: "container.itemCrateReinforced";
	}

}
