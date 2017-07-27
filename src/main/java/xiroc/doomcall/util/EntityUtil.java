package xiroc.doomcall.util;

import cpw.mods.fml.common.registry.EntityRegistry;
import net.minecraft.entity.Entity;
import xiroc.doomcall.entity.EntityDestroyer;
import xiroc.doomcall.lib.Reference;

public class EntityUtil {
	
	public static void registerEntities(){
		createCustomEntity(EntityDestroyer.class, "destroyer", 0, 10, false);
	}
	
	public static void createCustomEntity(Class <? extends Entity> entityCass, String name, int trackingrange,int updateFrequency, boolean sendsVelocityUpdates){
		int id = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityCass, name, id);
		EntityRegistry.registerModEntity(entityCass, name, id, Reference.instance, trackingrange, updateFrequency, sendsVelocityUpdates);
		
	}

}
