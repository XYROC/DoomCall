package xiroc.doomcall.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import xiroc.doomcall.block.BlockHandler;
import xiroc.doomcall.item.block.ItemBlockHeavyCoalGenerator;

public class ModItems {
	
	public static ItemBlock item_hcg = (ItemBlock) new ItemBlockHeavyCoalGenerator(BlockHandler.heavy_coal_generator);
	public static Item item_destroyer = new ItemDestroyer();
	public static Item ingotLead = new ItemLeadIngot();
	public static Item ingotCopper = new  ItemCopperIngot();
	public static Item ingotTin = new ItemTinIngot();
	public static Item ingotNickel = new ItemNickelIngot();
	public static Item ingotSilver = new ItemSilverIngot();
	public static Item ingotInvar = new  ItemInvarIngot();
	public static Item ingotBronze = new ItemBronzeIngot();
	public static Item ingotElectrum = new ItemElectrumIngot();
	public static Item ingotPlatinum = new  ItemPlatinumIngot();
	public static Item ingotEnderium = new ItemEnderiumIngot();
	public static Item ingotSteel = new ItemSteelIngot();
	
	public static void registerItems(){
		GameRegistry.registerItem(item_destroyer, "destroyer");
		GameRegistry.registerItem(ingotCopper, "ingotCopper");
		GameRegistry.registerItem(ingotLead, "ingotLead");
		GameRegistry.registerItem(ingotTin, "ingotTin");
		GameRegistry.registerItem(ingotNickel, "ingotNickel");
		GameRegistry.registerItem(ingotSilver, "ingotSilver");
		GameRegistry.registerItem(ingotInvar, "ingotInvar");
		GameRegistry.registerItem(ingotBronze, "ingotBronze");
		GameRegistry.registerItem(ingotPlatinum, "ingotPlatinum");
		GameRegistry.registerItem(ingotElectrum, "ingotElectrum");
		GameRegistry.registerItem(ingotEnderium, "ingotEnderium");
		GameRegistry.registerItem(ingotSteel, "ingotSteel");
	}

}
