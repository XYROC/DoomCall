package doom.lib;


import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.Logger;

import cpw.mods.fml.common.FMLLog;

public class LogHelper {
		
	public static void log(Level level, String message){
		FMLLog.getLogger().log(level, "[DoomCall] "+message);
	}

}
