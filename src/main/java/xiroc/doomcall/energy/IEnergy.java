package xiroc.doomcall.energy;

import net.minecraftforge.common.util.ForgeDirection;
import xiroc.doomcall.block.BlockType;

public interface IEnergy {
	
	public boolean canAddEnergyOnSide(ForgeDirection direction);
	public boolean canConnect(ForgeDirection direction);
	public EnergyBar getEnergyBar();
	public void setLastRecievedDirection(ForgeDirection direction);
	public int getEnergyTransferRate();
	public BlockType getBlockTypeD();
	
}
