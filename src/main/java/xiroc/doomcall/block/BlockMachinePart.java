package xiroc.doomcall.block;

import doom.lib.block.BlockPos;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityEnergeticMassFabricator;
import xiroc.doomcall.tileentity.TileEntityMachinePart;

public class BlockMachinePart extends BlockContainer {

	private IIcon[] icons = new IIcon[2];

	public BlockMachinePart(Material material) {
		super(material);
		setCreativeTab(DoomCall.creativeTab);
		setHardness(3.5F);
		setBlockName("machinePart");
		setBlockTextureName("doomcall:machine_part_0");
		setStepSound(soundTypeMetal);
		setHarvestLevel("pickaxe", 2);

	}
	
	@Override
	public IIcon getIcon(int p_149691_1_, int p_149691_2_) {
		return icons[0];
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float hitx,
			float hity, float hitz) {
		TileEntityMachinePart tile = (TileEntityMachinePart) world.getTileEntity(x, y, z);
		if (tile.isAssembled()) {
			BlockPos pos = getSurroundingMachineCore(BlockHandler.energetic_mass_fabricator, world, x, y, z);
			Block block = world.getBlock(pos.getX(), pos.getY(), pos.getZ());
			block.onBlockActivated(world, pos.getX(), pos.getY(), pos.getZ(), player, p_149727_6_, hitx, hity, hitz);
			return true;
		}
		return false;
	}

	@Override
	public IIcon getIcon(IBlockAccess blockAccess, int x, int y, int z, int side) {
		TileEntityMachinePart tile = (TileEntityMachinePart) blockAccess.getTileEntity(x, y, z);
		if (tile.isAssembled())
			return icons[1];
		return icons[0];
	}


	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		this.icons[0] = iconRegister.registerIcon("doomcall:machine_part_0");
		this.icons[1] = iconRegister.registerIcon("doomcall:machine_part_1");

	}

	@Override
	public TileEntity createNewTileEntity(World world, int i) {
		return new TileEntityMachinePart();
	}

	private BlockPos getSurroundingMachineCore(Block core, World world, int x, int y, int z) {
		return BlockHandler.getCoreBlock(core, this, world, x, y, z);
	}

}
