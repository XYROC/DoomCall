package xiroc.doomcall.block;

import doom.lib.block.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityEnergeticMassFabricator;
import xiroc.doomcall.tileentity.TileEntityItemCrate;
import xiroc.doomcall.util.InventoryHelper;

public class BlockEnergeticMassFabricator extends BlockContainer {

	public BlockEnergeticMassFabricator(Material material) {
		super(material);
		setHardness(4.0F);
		setCreativeTab(DoomCall.creativeTab);
		setBlockName("energeticMassFabricator");
		setBlockTextureName("doomcall:energetic_mass_fabricator");
		setStepSound(soundTypeMetal);
		setHarvestLevel("pickaxe", 2);
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float hitx,
			float hity, float hitz) {
		if (BlockHandler.isDefaultMultiblockStructure(this, BlockHandler.machine_part, world, x, y, z)) {
			TileEntityEnergeticMassFabricator tile = (TileEntityEnergeticMassFabricator) world.getTileEntity(x, y, z);
			player.openGui(Reference.instance, Reference.gui_energetic_mass_fabricator, world, x, y, z);
			return true;
		}
		return false;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityEnergeticMassFabricator();
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityEnergeticMassFabricator tile = (TileEntityEnergeticMassFabricator) world.getTileEntity(x, y, z);
		InventoryHelper.dropInventoryItems(world, x, y, z, tile);
		super.breakBlock(world, x, y, z, block, meta);
	}

}
