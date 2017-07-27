package xiroc.doomcall.util;

import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import xiroc.doomcall.gui.ContainerEnergeticMassFabricator;
import xiroc.doomcall.gui.ContainerHVGenerator;
import xiroc.doomcall.gui.ContainerItemCrate;
import xiroc.doomcall.gui.ContainerItemCrateReinforced;
import xiroc.doomcall.gui.GuiEnergeticMassFabricator;
import xiroc.doomcall.gui.GuiHVGenerator;
import xiroc.doomcall.gui.GuiItemCrate;
import xiroc.doomcall.gui.GuiItemCrateReinforced;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityEnergeticMassFabricator;
import xiroc.doomcall.tileentity.TileEntityHVGenerator;
import xiroc.doomcall.tileentity.TileEntityItemCrate;
import xiroc.doomcall.tileentity.TileEntityItemCrateReinforced;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case Reference.gui_item_crate:
			return new ContainerItemCrate(player.inventory, (TileEntityItemCrate) world.getTileEntity(x, y, z));
		case Reference.gui_hv_generator:
			return new ContainerHVGenerator(player.inventory, (TileEntityHVGenerator) world.getTileEntity(x, y, z));
		case Reference.gui_energetic_mass_fabricator:
			return new ContainerEnergeticMassFabricator(player.inventory,
					(TileEntityEnergeticMassFabricator) world.getTileEntity(x, y, z));
		case Reference.gui_item_crate_reinforced:
			return new ContainerItemCrateReinforced(player.inventory,
					(TileEntityItemCrateReinforced) world.getTileEntity(x, y, z));
		default:
			return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
		case Reference.gui_item_crate:
			return new GuiItemCrate(
					new ContainerItemCrate(player.inventory, (TileEntityItemCrate) world.getTileEntity(x, y, z)));
		case Reference.gui_hv_generator:
			return new GuiHVGenerator(
					new ContainerHVGenerator(player.inventory, (TileEntityHVGenerator) world.getTileEntity(x, y, z)),
					(TileEntityHVGenerator) world.getTileEntity(x, y, z));
		case Reference.gui_energetic_mass_fabricator:
			return new GuiEnergeticMassFabricator(
					new ContainerEnergeticMassFabricator(player.inventory,
							(TileEntityEnergeticMassFabricator) world.getTileEntity(x, y, z)),
					(TileEntityEnergeticMassFabricator) world.getTileEntity(x, y, z));
		case Reference.gui_item_crate_reinforced:
			return new GuiItemCrateReinforced(new ContainerItemCrateReinforced(player.inventory,
					(TileEntityItemCrateReinforced) world.getTileEntity(x, y, z)));
		default:
			return null;
		}
	}

}
