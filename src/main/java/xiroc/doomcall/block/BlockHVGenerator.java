package xiroc.doomcall.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityHVGenerator;

public class BlockHVGenerator extends BlockContainer {
	//BlockFurnace

	public IIcon[] icons = new IIcon[6];

	public BlockHVGenerator(Material material) {
		super(material);
		setHardness(5.5f);
		setResistance(6.0f);
		setStepSound(soundTypeMetal);
		setBlockName("hv_generator");
		setBlockTextureName("doomcall:hv_generator");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		switch(side){
		case 0:
			return icons[0];
		case 1:
			return icons[1];
		case 2:
			if(meta == 2) return icons[2];
			return icons[3];
		case 3:
			if(meta == 0) return icons[2];
			return icons[3];
		case 4:
			if(meta == 1) return icons[2];
			return icons[3];
		case 5:
			if(meta == 3) return icons[2];
			return icons[3];
			
		}
		return this.icons[side];
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i < 6; i++) {
			this.icons[i] = iconRegister.registerIcon(textureName + "_" + i);
		}
	}

	@Override
	public boolean onBlockActivated(World p_149727_1_, int x, int y, int z, EntityPlayer p_149727_5_, int p_149727_6_,
			float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		TileEntity tileEntity = p_149727_1_.getTileEntity(x, y, z);
		if (tileEntity instanceof TileEntityHVGenerator) {
			p_149727_5_.openGui(Reference.instance, Reference.gui_hv_generator, p_149727_1_, x, y, z);
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityHVGenerator();
	}
	
	@Override
	public void onBlockPlacedBy(World world, int x, int y, int z,
			EntityLivingBase entity, ItemStack stack) {
		int l = MathHelper.floor_double((double)(entity.rotationYaw * 4.0F / 360.0F) + 2.5D) & 3;
        world.setBlockMetadataWithNotify(x, y, z, l, 2);
	}
    
}
