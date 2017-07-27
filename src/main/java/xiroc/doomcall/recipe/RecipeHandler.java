package xiroc.doomcall.recipe;

import java.util.ArrayList;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import xiroc.doomcall.block.BlockHandler;
import xiroc.doomcall.item.ModItems;

public class RecipeHandler {

	public static EMFRecipes emfbase;

	private static String ingotElectrum = "ingotElectrum";
	private static String ingotSilver = "ingotSilver";
	private static String ingotTin = "ingotTin";
	private static String ingotCopper = "ingotCopper";
	private static String ingotBronze = "ingotBronze";
	private static String ingotLead = "ingotLead";

	public static void load() {
		registerOreDictionaryNames();
		checkOreDictionaryNames();
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockHandler.hv_generator, "ini", "rer", "ini", 'i', "ingotSteel",
				'n', ingotSilver, 'r', ingotElectrum, 'e', Item.getItemFromBlock(Blocks.furnace)));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockHandler.machine_part, "iri", "rsr", "iri", 'i', "ingotIron",
				'r', "dustRedstone", 's', "ingotSteel"));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockHandler.energetic_mass_fabricator, "fbf", "srs", "fcf", 'f',
				Item.getItemFromBlock(BlockHandler.machine_part), 'b', Item.getItemFromBlock(Blocks.iron_bars), 's',
				"ingotSteel", 'r', Item.getItemFromBlock(Blocks.redstone_block), 'c',
				Item.getItemFromBlock(Blocks.obsidian)));
		GameRegistry.addRecipe(new ShapedOreRecipe(BlockHandler.item_crate_reinforced, "sis","i i","sis",'s',"ingotSteel",'i',Item.getItemFromBlock(Blocks.iron_block)));
		GameRegistry.addRecipe(new ItemStack(Item.getItemFromBlock(BlockHandler.item_crate)),"sps","p p","sps",'s',Items.stick,'p',new ItemStack(Blocks.planks, 1, OreDictionary.WILDCARD_VALUE));
		emfbase = new EMFRecipes();
		
	}

	private static void registerOreDictionaryNames() {
		OreDictionary.registerOre("ingotCopper", ModItems.ingotCopper);
		OreDictionary.registerOre("ingotTin", ModItems.ingotTin);
		OreDictionary.registerOre("ingotNickel", ModItems.ingotNickel);
		OreDictionary.registerOre("ingotSilver", ModItems.ingotSilver);
		OreDictionary.registerOre("ingotLead", ModItems.ingotLead);
		OreDictionary.registerOre("ingotInvar", ModItems.ingotInvar);
		OreDictionary.registerOre("ingotBronze", ModItems.ingotBronze);
		OreDictionary.registerOre("ingotElectrum", ModItems.ingotElectrum);
		OreDictionary.registerOre("ingotPlatinum", ModItems.ingotPlatinum);
		OreDictionary.registerOre("ingotEnderium", ModItems.ingotEnderium);
		OreDictionary.registerOre("ingotSteel", ModItems.ingotSteel);
	}

	private static void checkOreDictionaryNames() {
		if (!OreDictionary.doesOreNameExist(ingotElectrum))
			ingotElectrum = "ingotGold";
		if (!OreDictionary.doesOreNameExist(ingotSilver))
			ingotSilver = "ingotIron";
		if (!OreDictionary.doesOreNameExist(ingotTin))
			ingotTin = ingotSilver;
		if (!OreDictionary.doesOreNameExist(ingotCopper))
			ingotCopper = ingotTin;
		if (!OreDictionary.doesOreNameExist(ingotBronze))
			ingotBronze = ingotCopper;
		if (!OreDictionary.doesOreNameExist(ingotLead))
			ingotLead = ingotTin;
	}

	public static EMFRecipes getEmfbase() {
		return emfbase;
	}

}
