package xiroc.doomcall.lib;

import net.minecraft.block.Block;
import xiroc.doomcall.block.BlockCopperPowerCable;

public class DBlocks {
	
	public static Block COPPER_POWER_CABLE;
	
	public static void init(){
		COPPER_POWER_CABLE = new BlockCopperPowerCable();
	}

}
