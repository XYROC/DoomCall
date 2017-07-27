package xiroc.doomcall.block;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import xiroc.doomcall.lib.DBlocks;
import xiroc.doomcall.lib.Energy;

public class ItemBlockStandardMetadata extends ItemBlock{

	public ItemBlockStandardMetadata(Block p_i45328_1_) {
		super(p_i45328_1_);
		setHasSubtypes(true);
		
	}
	
	@Override
	public String getUnlocalizedName(ItemStack p_77667_1_) {
		return getUnlocalizedName() + "." + p_77667_1_.getItemDamage();
	}
	
	@Override
	public int getMetadata(int p_77647_1_) {
		return p_77647_1_;
	}
	
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean advanced) {
		if(itemStack.getItem() == Item.getItemFromBlock(DBlocks.COPPER_POWER_CABLE)){
			int meta = itemStack.getItemDamage();
			if(meta == 0){
				list.add("Energy Loss: 0"+Energy.QE.getSymbol()+ "/m");
			}
		}
	}

}
