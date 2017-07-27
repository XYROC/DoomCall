package xiroc.doomcall.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.lib.Reference;
import xiroc.doomcall.tileentity.TileEntityItemCrate;
import xiroc.doomcall.tileentity.TileEntityItemCrateReinforced;
import xiroc.doomcall.tileentity.TileEntityResourceGenerator;
import xiroc.doomcall.util.InventoryHelper;

public class BlockResourceGenerator extends BlockContainer {

	private IIcon[] icons = new IIcon[3];

	public BlockResourceGenerator() {
		super(Material.iron);
		setStepSound(soundTypeMetal);
		setCreativeTab(DoomCall.creativeTab);
		setBlockUnbreakable();
		setResistance(255.0F);
		setBlockName("resourceGenerator");
		setCreativeTab(DoomCall.creativeTab);
		setBlockTextureName("doomcall:resourceGenerator");
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		icons[0] = iconRegister.registerIcon(textureName + "_0");
		icons[1] = iconRegister.registerIcon(textureName + "_1");
		icons[2] = iconRegister.registerIcon(textureName + "_2");
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		switch (side) {
		case 0:
			return icons[0];
		case 1:
			return icons[1];
		default:
			return icons[2];
		}
	}

	@Override
	public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_) {
		return new TileEntityResourceGenerator();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_,
			float p_149727_7_, float p_149727_8_, float p_149727_9_) {
		TileEntity tile = world.getTileEntity(x, y, z);
		if (tile instanceof TileEntityResourceGenerator) {
			if (!world.isRemote) {
				TileEntityResourceGenerator gen = (TileEntityResourceGenerator) tile;
				player.addChatMessage(new ChatComponentText(
						"Next resource in " + gen.getNextResourceString()));
			}
		}
		return true;
	}

}
