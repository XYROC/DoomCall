package xiroc.doomcall.proxy;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.client.registry.RenderingRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.item.Item;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.client.MinecraftForgeClient;
import xiroc.doomcall.DoomCall;
import xiroc.doomcall.block.BlockHeavyCoalGenerator;
import xiroc.doomcall.entity.EntityDestroyer;
import xiroc.doomcall.item.ModItems;
import xiroc.doomcall.render.RenderDestroyer;
import xiroc.doomcall.render.RenderHeavyCoalGenerator;
import xiroc.doomcall.render.RenderItemHeavyCoalGenerator;
import xiroc.doomcall.tileentity.TileEntityHeavyCoalGenerator;

public class ClientProxy extends CommonProxy {

	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(EntityDestroyer.class, new RenderDestroyer());
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHeavyCoalGenerator.class, new RenderHeavyCoalGenerator());
		
		MinecraftForgeClient.registerItemRenderer(ModItems.item_hcg, (IItemRenderer) new RenderItemHeavyCoalGenerator());
	}

	

}
