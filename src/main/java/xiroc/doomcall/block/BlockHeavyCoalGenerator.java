package xiroc.doomcall.block;

import java.util.Random;

import doom.lib.block.BlockMachine;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.tileentity.TileEntityHeavyCoalGenerator;

public class BlockHeavyCoalGenerator extends BlockMachine{
	//BlockFurnace

	public BlockHeavyCoalGenerator() {
		super();
		setBlockName("generator_heavy_coal");
		setCreativeTab(DoomCall.creativeTab);
	}
	
	public int getRenderType()
	{
		return -1;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_,
				p_149727_8_, p_149727_9_);
	}
	
	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
		return super.getItemDropped(p_149650_1_, p_149650_2_, p_149650_3_);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHeavyCoalGenerator(30, 30);
	}

}
