package xiroc.doomcall.tileentity;

import cpw.mods.fml.common.registry.GameRegistry;

public class TileEntityHandler {
	
	public static void registerTileEntities(){
		GameRegistry.registerTileEntity(TileEntityItemCrate.class, "doomcall_item_crate");
		GameRegistry.registerTileEntity(TileEntityItemCrateReinforced.class, "doomcall:item_crate_reinforced");
		GameRegistry.registerTileEntity(TileEntityHVGenerator.class, "doomcall_generator_hv");
		GameRegistry.registerTileEntity(TileEntityMachinePart.class, "doomcall_machine_part");
		GameRegistry.registerTileEntity(TileEntityEnergeticMassFabricator.class, "doomcall_energetic_mass_fabricator");
		GameRegistry.registerTileEntity(TileEntityResourceGenerator.class, "doomcall_resource_generator");
	}

}
