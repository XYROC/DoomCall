package xiroc.doomcall.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.entity.EntityDestroyer;

public class ItemDestroyer extends Item {

	public ItemDestroyer() {
		setMaxStackSize(1);
		setUnlocalizedName("destroyer");
		setCreativeTab(DoomCall.creativeTab);
	}

	@Override
	public boolean onItemUse(ItemStack item, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_,
			float p_77648_8_, float p_77648_9_, float p_77648_10_) {
		if (!world.isRemote) {
			EntityDestroyer destroyer = new EntityDestroyer(world, x, y, z);
			world.spawnEntityInWorld(destroyer);
			item.splitStack(1);
		}
		return true;
	}

}
