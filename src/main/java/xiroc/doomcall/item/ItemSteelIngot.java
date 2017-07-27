package xiroc.doomcall.item;

import net.minecraft.item.Item;
import xiroc.doomcall.DoomCall;

public class ItemSteelIngot extends Item{
	
	public ItemSteelIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotSteel");
		setTextureName("doomcall:ingotSteel");
	}

}
