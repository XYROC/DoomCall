package xiroc.doomcall.item;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;

public class ItemLeadIngot extends Item{
	
	public ItemLeadIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotLead");
		setTextureName("doomcall:ingotLead");
	}

}
