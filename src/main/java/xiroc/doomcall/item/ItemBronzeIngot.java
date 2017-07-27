package xiroc.doomcall.item;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;

public class ItemBronzeIngot extends Item{
	
	public ItemBronzeIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotBronze");
		setTextureName("doomcall:ingotBronze");
	}

}
