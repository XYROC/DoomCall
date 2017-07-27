package xiroc.doomcall.item;

import net.minecraft.item.Item;
import xiroc.doomcall.DoomCall;

public class ItemSilverIngot extends Item{
	
	public ItemSilverIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotSilver");
		setTextureName("doomcall:ingotSilver");
	}

}
