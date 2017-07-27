package xiroc.doomcall.block;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityItemCrate;
import xiroc.doomcall.util.InventoryHelper;

public class BlockItemCrate extends BlockContainer {

	public BlockItemCrate() {
		super(Material.wood);
		setStepSound(soundTypeWood);
		setCreativeTab(DoomCall.creativeTab);
		setHardness(2.12F);
		setBlockName("crate");
		setBlockTextureName("doomcall:item_crate");
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityItemCrate();
	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if (!p_149727_1_.isRemote) {
			TileEntity tileEntity = p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
			if (tileEntity instanceof TileEntityItemCrate) {
				p_149727_5_.openGui(Reference.instance, Reference.gui_item_crate, p_149727_1_, p_149727_2_, p_149727_3_,
						p_149727_4_);
			}
		}
		return true;
	}

	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityItemCrate tile = (TileEntityItemCrate) world.getTileEntity(x, y, z);
		InventoryHelper.dropInventoryItems(world, x, y, z, tile);
		super.breakBlock(world, x, y, z, block, meta);
	}

}
