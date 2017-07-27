package xiroc.doomcall.gui;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.ICrafting;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.tileentity.TileEntityHVGenerator;

public class ContainerHVGenerator extends Container {

	public TileEntityHVGenerator tile;
	private int lastBurnTime;
	private int lastItemBurnTime;
	private static final String __OBFID = "CL_00001748";
	
	//ContainerFurnace

	public ContainerHVGenerator(InventoryPlayer p_i1812_1_, TileEntityHVGenerator tile) {
		this.tile = tile;
		this.addSlotToContainer(new Slot(tile, 0, 69, 35));
		this.addSlotToContainer(new Slot(tile, 1, 152, 60));
		this.addSlotToContainer(new Slot(tile, 2, 116, 35));
		int i;
		for (i = 0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				this.addSlotToContainer(new Slot(p_i1812_1_, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		for (i = 0; i < 9; ++i) {
			this.addSlotToContainer(new Slot(p_i1812_1_, i, 8 + i * 18, 142));
		}
	}

	public void addCraftingToCrafters(ICrafting p_75132_1_) {
		super.addCraftingToCrafters(p_75132_1_);
	}

	/**
	 * Looks for changes made in the container, sends them to every listener.
	 */
	public void detectAndSendChanges() {
		super.detectAndSendChanges();
	}

	@SideOnly(Side.CLIENT)
	public void updateProgressBar(int p_75137_1_, int p_75137_2_) {
		if (p_75137_1_ == 0) {

		}
	}

	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return true;
	}
	
	

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer p_82846_1_, int p_82846_2_) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(p_82846_2_);

		if (slot != null && slot.getHasStack()) {
			/*
			 * ItemStack itemstack1 = slot.getStack(); itemstack =
			 * itemstack1.copy();
			 * 
			 * if (p_82846_2_ == 2) { if (!this.mergeItemStack(itemstack1, 3,
			 * 39, true)) { return null; }
			 * 
			 * slot.onSlotChange(itemstack1, itemstack); } else if (p_82846_2_
			 * != 1 && p_82846_2_ != 0) { if
			 * (FurnaceRecipes.smelting().getSmeltingResult(itemstack1) != null)
			 * { if (!this.mergeItemStack(itemstack1, 0, 1, false)) { return
			 * null; } } else if (TileEntityFurnace.isItemFuel(itemstack1)) { if
			 * (!this.mergeItemStack(itemstack1, 1, 2, false)) { return null; }
			 * } else if (p_82846_2_ >= 3 && p_82846_2_ < 30) { if
			 * (!this.mergeItemStack(itemstack1, 30, 39, false)) { return null;
			 * } } else if (p_82846_2_ >= 30 && p_82846_2_ < 39 &&
			 * !this.mergeItemStack(itemstack1, 3, 30, false)) { return null; }
			 * } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
			 * return null; }
			 * 
			 * if (itemstack1.stackSize == 0) { slot.putStack((ItemStack)null);
			 * } else { slot.onSlotChanged(); }
			 * 
			 * if (itemstack1.stackSize == itemstack.stackSize) { return null; }
			 * 
			 * slot.onPickupFromSlot(p_82846_1_, itemstack1);
			 */
		}

		return itemstack;
	}
	
}