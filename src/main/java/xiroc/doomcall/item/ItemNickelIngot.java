package xiroc.doomcall.item;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;

public class ItemNickelIngot extends Item{
	
	public ItemNickelIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotNickel");
		setTextureName("doomcall:ingotNickel");
	}

}
