package xiroc.doomcall.item;

import net.minecraft.item.Item;
import xiroc.doomcall.DoomCall;

public class ItemInvarIngot extends Item{
	
	public ItemInvarIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotInvar");
		setTextureName("doomcall:ingotInvar");
	}

}
