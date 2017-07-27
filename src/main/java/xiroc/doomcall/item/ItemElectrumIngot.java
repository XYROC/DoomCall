package xiroc.doomcall.item;

import net.minecraft.item.Item;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;

public class ItemElectrumIngot extends Item {

	public ItemElectrumIngot() {
		setCreativeTab(DoomCall.creativeTab);
		setUnlocalizedName("ingotElectrum");
		setTextureName("doomcall:ingotElectrum");
	}

}
