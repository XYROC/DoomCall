package xiroc.doomcall.energy;

import cofh.api.energy.EnergyStorage;

public class EnergyHelper {
	
	public static int getEnergy(EnergyStorage storage){
		return storage.getEnergyStored();
	}
	
	public static int getMaxEnergy(EnergyStorage storage){
		return storage.getMaxEnergyStored();
	}

}
