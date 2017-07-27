package xiroc.doomcall.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import xiroc.doomcall.energy.IEnergy;
import xiroc.doomcall.lib.Names;
import xiroc.doomcall.tileentity.TileEntityCable;

public class BlockCopperPowerCable extends BlockCable {

	public BlockCopperPowerCable() {
		super(Material.iron);
		setCreativeTab(CreativeTabs.tabRedstone);
		setBlockName(Names.CABLE_POWER_COPPER);
	}
	
	@Override
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		list.add(new ItemStack(this, 1, 0));
	}
	
	@Override
	public TileEntity createTileEntity(World world, int metadata) {
		switch(metadata){
		case 0:
			return new TileEntityCable();
		}
		return null;
	}

}
