package doom.lib.block;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockMachine extends BlockContainer{

	public BlockMachine(Material material) {
		super(material);
	}
	
	public BlockMachine() {
		super(Material.iron);
		setStepSound(soundTypeMetal);
		setHardness(3.14159F);
		setResistance(0.8F);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int p_149915_2_) {
		return null;
	}

}
