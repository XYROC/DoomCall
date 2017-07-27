package xiroc.doomcall.recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.item.ModItems;

public class EMFRecipes {

	private static ArrayList<EMFRecipe> emf_recipes;
	private static Map recipes;

	public EMFRecipes() {
		emf_recipes = new ArrayList<EMFRecipe>();
		recipes = new HashMap<ArrayList<ItemStack>, ItemStack>();
		load();
	}

	public static void addRecipe(ArrayList<ItemStack> input, ItemStack output) {
		recipes.put(input, output);
	}

	public static boolean checkMatch(ItemStack[] input) {
		for (EMFRecipe r : getEmfRecipes()) {
			for (int i = 0; i < input.length; i++) {
				if (!r.getRecipeItems().contains(input[i]))
					return false;
			}
		}
		return true;
	}

	public static void load() {
		int amplifier = (Integer) DoomCall.config.variables.get("emfBurnTimeAmplifier");
		addEMFRecipe(new EMFRecipe(new ItemStack(Items.gold_ingot), 2, 100*amplifier, new String[] { "ingotIron", "dustGlowstone" }));
		addEMFRecipe(new EMFRecipe(new ItemStack(ModItems.ingotBronze,2), 2, 100*amplifier, new String[] { "ingotCopper", "ingotTin" }));
		addEMFRecipe(new EMFRecipe(new ItemStack(ModItems.ingotElectrum,2), 3, 150*amplifier, new String[] { "ingotGold", "dustRedstone","dustGlowstone" }));
		addEMFRecipe(new EMFRecipe(new ItemStack(ModItems.ingotInvar,3), 3, 60*amplifier, new String[] { "ingotIron", "ingotIron", "ingotNickel" }));
		addEMFRecipe(new EMFRecipe(new ItemStack(Items.redstone,4), 2, 60*amplifier, new String[] { "dustGlowstone", "dustCopper"}));
		addEMFRecipe(new EMFRecipe(new ItemStack(ModItems.ingotEnderium), 2, 150*amplifier, new ItemStack[]{new ItemStack(Items.ender_pearl)}, new String[]{"ingotIron"}));
		addEMFRecipe(new EMFRecipe(new ItemStack(Items.diamond), 4, 150*amplifier, "blockCoal","blockCoal","blockCoal","blockCoal"));
	}

	public Map getRecipeList() {
		return recipes;
	}

	public static void addEMFRecipe(EMFRecipe recipe) {
		emf_recipes.add(recipe);
	}

	public static ArrayList<EMFRecipe> getEmfRecipes() {
		return emf_recipes;
	}

	public static EMFRecipe getEMFRecipe(ItemStack[] items) {
		for (EMFRecipe recipe : emf_recipes) {
			if (recipe.matches(items))
				return recipe;
		}
		return null;
	}

}
