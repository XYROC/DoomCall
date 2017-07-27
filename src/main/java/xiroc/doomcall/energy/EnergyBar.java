package xiroc.doomcall.energy;

import net.minecraft.nbt.NBTTagCompound;

public class EnergyBar {

	private int maxEnergyLevel = 0;
	private int defaultMaxEnergyLevel;
	private int energyLevel = 0;

	public EnergyBar(int maxEnergyLevel, boolean startWithMaxEnergy) {
		this.maxEnergyLevel = defaultMaxEnergyLevel = maxEnergyLevel;
		if (startWithMaxEnergy) {
			this.energyLevel = maxEnergyLevel;
		}
	}

	public EnergyBar(int maxEnergyLevel) {
		this(maxEnergyLevel, false);
	}

	public void addEnergy(int amount) {
		energyLevel += amount;
	}

	public void removeEnergy(int amount) {
		energyLevel -= amount;
	}
	
	public boolean canAddEnergy(int amount){
		return (energyLevel + amount) <= maxEnergyLevel;
	}
	
	public boolean canRemoveEnergy(int amount){
		return (energyLevel - amount) >= 0;
	}
	
	public void setMaxEnergyLevel(int newMax){
		this.maxEnergyLevel = newMax;
	}
	
	public int getMaxEnergyLevel() {
		return maxEnergyLevel;
	}
	
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}
	
	public void writeToNBT(NBTTagCompound compound){
		compound.setInteger("energyLevel", this.energyLevel);
	}
	
	public void readFromNBT(NBTTagCompound compound){
		this.energyLevel = compound.getInteger("energyLevel");
	}
	
	public int getEnergyLeveScaled(int scale){
		return energyLevel * scale / maxEnergyLevel;
	}
	
	public int addEnergyWithRemaining(int amount){
		energyLevel += amount;
		if(energyLevel > maxEnergyLevel){
			int powerRemaining = energyLevel - maxEnergyLevel;
			energyLevel -= powerRemaining;
			return powerRemaining;
		}
		return 0;
	}
	
	public void resetMaxEnergyLevel(){
		maxEnergyLevel = defaultMaxEnergyLevel;
	}

}
