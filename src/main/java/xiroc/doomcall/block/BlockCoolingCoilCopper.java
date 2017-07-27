package xiroc.doomcall.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import xiroc.doomcall.DoomCall;

public class BlockCoolingCoilCopper extends BlockCoolingCoil{

	public BlockCoolingCoilCopper() {
		super(Material.iron);
		setStepSound(soundTypeMetal);
		setCreativeTab(DoomCall.creativeTab);
		setBlockName("coolingCoilCopper");
		setBlockBounds(0F, 0F, 0F, 16F, 14F, 16F);
	}
	
	@Override
	public int getCoolingPower() {
		return 275;
	}

}
