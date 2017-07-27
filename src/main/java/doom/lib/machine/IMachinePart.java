package doom.lib.machine;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public interface IMachinePart {

	public int getMachineID();

	public String getMachineName();
	
	public boolean isAssembled();
	
}
