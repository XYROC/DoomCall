package xiroc.doomcall.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import xiroc.doomcall.energy.IEnergy;
import xiroc.doomcall.tileentity.TileEntityCable;

public class BlockCable extends Block{

	public BlockCable(Material p_i45394_1_) {
		super(p_i45394_1_);
	}
	
	@Override
	public void setBlockBoundsBasedOnState(IBlockAccess world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		boolean[] blockBounds = new boolean[6];
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
			blockBounds[direction.ordinal()] = world.getTileEntity(x + direction.offsetX, y + direction.offsetY,
					z + direction.offsetZ) instanceof IEnergy
					&& ((IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY,
							z + direction.offsetZ)).canConnect(direction);
		}
		if (meta == 0)
			this.setBlockBounds(blockBounds[4] ? 0 : 0.375F, blockBounds[0] ? 0 : 0.375F, blockBounds[2] ? 0 : 0.375F,
					blockBounds[5] ? 1 : 0.625F, blockBounds[1] ? 1 : 0.625F, blockBounds[3] ? 1 : 0.625F);
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		int meta = world.getBlockMetadata(x, y, z);
		boolean[] blockBounds = new boolean[6];
		for (ForgeDirection direction : ForgeDirection.VALID_DIRECTIONS) {
			blockBounds[direction.ordinal()] = world.getTileEntity(x + direction.offsetX, y + direction.offsetY,
					z + direction.offsetZ) instanceof IEnergy
					&& ((IEnergy) world.getTileEntity(x + direction.offsetX, y + direction.offsetY,
							z + direction.offsetZ)).canConnect(direction);
		}
		if (meta == 0)
			return AxisAlignedBB.getBoundingBox( x + (blockBounds[4] ? 0 : 0.375F), y + (blockBounds[0] ? 0 : 0.375F),
					z + (blockBounds[2] ? 0 : 0.375F), x + (blockBounds[5] ? 1 : 0.625F),
					y + (blockBounds[1] ? 1 : 0.625F), z + (blockBounds[3] ? 1 : 0.625F));
		return super.getCollisionBoundingBoxFromPool(world, x, y, z);

	}
	
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	
	@Override
	public boolean renderAsNormalBlock() {
		return false;
	}
	
	@Override
	public boolean hasTileEntity(int metadata) {
		return metadata <= 1;
	}
	
	@Override
	public boolean shouldSideBeRendered(IBlockAccess world, int x, int y, int z,
			int side) {
		return false;
	}

}
