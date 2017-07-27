package xiroc.doomcall.recipe;

import java.util.ArrayList;

import org.apache.logging.log4j.Level;

import doom.lib.LogHelper;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import net.minecraftforge.oredict.OreDictionary;
import xiroc.doomcall.DoomCall;

public class EMFRecipe {

	// ShapelessOreRecipe
	private int time;
	private int size;
	private ItemStack output;
	private ArrayList<ItemStack> recipeItems;
	private ArrayList<Item> items;

	public EMFRecipe(ItemStack output, int size, int burnTime, String... input) {
		this.recipeItems = new ArrayList<ItemStack>();
		this.items = new ArrayList<Item>();
		this.output = output;
		this.size = size;
		this.time = burnTime;
		int i = 0;
		for (String s : input) {
			i++;
			for (ItemStack stack : OreDictionary.getOres(s)) {
				if (stack != null) {
					recipeItems.add(stack);
					items.add(stack.getItem());
				} else {
					LogHelper.log(Level.ERROR, "Recipe Item was null.");
				}
			}
		}
		DoomCall.recipes0.addRecipe(recipeItems, output);
	}

	public EMFRecipe(ItemStack output, int size, int burnTime, ItemStack... input) {
		this.recipeItems = new ArrayList<ItemStack>();
		this.items = new ArrayList<Item>();
		this.output = output;
		this.size = size;
		this.time = burnTime;
		int i = 0;
		for (ItemStack s : input) {
			i++;
			if (s != null) {
				recipeItems.add(s);
				items.add(s.getItem());
			}

		}
		DoomCall.recipes0.addRecipe(recipeItems, output);
	}
	
	public EMFRecipe(ItemStack output, int size, int burnTime, ItemStack[] input, String[] input2) {
		this.recipeItems = new ArrayList<ItemStack>();
		this.items = new ArrayList<Item>();
		this.output = output;
		this.size = size;
		this.time = burnTime;
		int i = 0;
		for (ItemStack s : input) {
			i++;
			if (s != null) {
				recipeItems.add(s);
				items.add(s.getItem());
			}

		}
		for (String s : input2) {
			i++;
			for (ItemStack stack : OreDictionary.getOres(s)) {
				if (stack != null) {
					recipeItems.add(stack);
					items.add(stack.getItem());
				} else {
					LogHelper.log(Level.ERROR, "Recipe Item was null.");
				}
			}
		}
		DoomCall.recipes0.addRecipe(recipeItems, output);
	}

	public boolean matches(InventoryCrafting inv, World world) {
		return checkMatch(inv, world);
	}

	public boolean matches(ItemStack[] items) {
		return checkMatch(items);
	}

	public ItemStack getCraftingResult(InventoryCrafting inv) {
		return output.copy();
	}

	public int getRecipeSize() {
		return size;
	}

	public ItemStack getResult() {
		return output.copy();
	}

	private boolean checkMatch(InventoryCrafting inv, World world) {
		ArrayList<RecipeItem> rlist = new ArrayList<EMFRecipe.RecipeItem>();
		for (ItemStack s : recipeItems) {
			rlist.add(new RecipeItem(s));
		}
		for (int i = 0; i < inv.getSizeInventory(); i++) {
			ItemStack stack = inv.getStackInSlot(i);
			if (stack != null) {
				if (!this.items.contains(stack.getItem()))
					return false;
			}
		}
		return isCompleted(rlist);
	}

	private boolean checkMatch(ItemStack[] itemList) {
		ArrayList<RecipeItem> rlist = new ArrayList<EMFRecipe.RecipeItem>();
		for (ItemStack s : recipeItems) {
			rlist.add(new RecipeItem(s));
		}
		for (int i = 0; i < itemList.length; i++) {
			ItemStack stack = itemList[i];
			if (stack != null) {
				for (RecipeItem r : rlist) {
					if (r.getItem().getItem() == stack.getItem() && r.getItem().stackSize <= stack.stackSize
							&& !r.isChecked()) {
						r.setChecked(true);
						break;
					}
				}
			}
		}
		return isCompleted(rlist);
	}

	public int getBurnTime() {
		return time;
	}

	public ArrayList<ItemStack> getRecipeItems() {
		return recipeItems;
	}

	public ArrayList<Item> getItems() {
		return items;
	}

	private class RecipeItem {
		private ItemStack item;
		private boolean checked = false;

		public RecipeItem(ItemStack stack) {
			item = stack;
		}

		public void setChecked(boolean checked) {
			this.checked = checked;
		}

		public boolean isChecked() {
			return checked;
		}

		public ItemStack getItem() {
			return item;
		}
	}

	private boolean isCompleted(ArrayList<RecipeItem> r) {
		for (RecipeItem item : r) {
			if (!item.isChecked())
				return false;
		}
		return true;
	}

}
