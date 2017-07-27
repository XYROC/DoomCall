package xiroc.doomcall.lib;

import cpw.mods.fml.common.Mod.Instance;
import xiroc.doomcall.DoomCall;

public class Reference {
	
	@Instance
	public static DoomCall instance;
	
	public static final int id = 1;
	
	public static final String modid = "DoomCall";
	public static final String version = "dev";
	public static final String name = "DoomCall";
	public static final String acceptedMinecraftVersions = "[1.7.10]";
	public static final String client_proxy = "xiroc.doomcall.proxy.ClientProxy";
	public static final String common_proxy = "xiroc.doomcall.proxy.CommonProxy";
	
	public static final int gui_item_crate = 0;
	public static final int gui_hv_generator = 1;
	public static final int gui_energetic_mass_fabricator = 2;
	public static final int gui_item_crate_reinforced = 3;
	
}
