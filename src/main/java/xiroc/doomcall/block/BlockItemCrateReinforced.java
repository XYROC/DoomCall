package xiroc.doomcall.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityItemCrate;
import xiroc.doomcall.tileentity.TileEntityItemCrateReinforced;
import xiroc.doomcall.util.InventoryHelper;

public class BlockItemCrateReinforced extends BlockContainer{
	
	private IIcon[] icons = new IIcon[3];

	public BlockItemCrateReinforced() {
		super(Material.iron);
		setStepSound(soundTypeMetal);
		setCreativeTab(DoomCall.creativeTab);
		setHardness(2.12F);
		setHarvestLevel("pickaxe", 2);
		setBlockName("crate_reinforced");
		setBlockTextureName("doomcall:item_crate_reinforced");
	}
	
	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		icons[0] = iconRegister.registerIcon(textureName+"_0");
		icons[1] = iconRegister.registerIcon(textureName+"_1");
		icons[2] = iconRegister.registerIcon(textureName+"_2");
	}
	
	@Override
	public IIcon getIcon(int side, int meta) {
		switch(side){
		case 0:
			return icons[0];
		case 1:
			return icons[1];
		default:
			return icons[2];
		}
	}
	
	@Override
	public void breakBlock(World world, int x, int y, int z, Block block, int meta) {
		TileEntityItemCrate tile = (TileEntityItemCrate) world.getTileEntity(x, y, z);
		InventoryHelper.dropInventoryItems(world, x, y, z, tile);
		super.breakBlock(world, x, y, z, block, meta);
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityItemCrateReinforced();
	}
	
	@Override
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_,
			EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		if(!p_149727_1_.isRemote){
			TileEntity tileEntity = p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
			if(tileEntity instanceof TileEntityItemCrateReinforced){
				p_149727_5_.openGui(Reference.instance, Reference.gui_item_crate_reinforced, p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_);
			}
		}
		return true;
	}
	
	

}
