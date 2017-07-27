package xiroc.doomcall.util;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.block.BlockHandler;

public class CreativeTabDoomCall extends CreativeTabs{

	public CreativeTabDoomCall() {
		super("doomcall");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(BlockHandler.item_crate);
	}

}
