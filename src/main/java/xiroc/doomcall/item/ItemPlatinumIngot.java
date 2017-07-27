package xiroc.doomcall.item;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;

public class ItemPlatinumIngot extends Item{
	
	public ItemPlatinumIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotPlatinum");
		setTextureName("doomcall:ingotPlatinum");
	}

}
