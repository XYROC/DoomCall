package xiroc.doomcall.item;

import net.minecraft.item.Item;
import xiroc.doomcall.DoomCall;

public class ItemTinIngot extends Item{
	
	public ItemTinIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotTin");
		setTextureName("doomcall:ingotTin");
	}

}
