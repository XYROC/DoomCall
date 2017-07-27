package xiroc.doomcall.tileentity;

import cofh.api.energy.EnergyStorage;
import cofh.api.energy.IEnergyHandler;
import cofh.api.energy.IEnergyProvider;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityBasicStorage extends TileEntity implements IEnergyHandler, IEnergyProvider {
	public EnergyStorage storage;
	public int output;
	
	public TileEntityBasicStorage(int output, int capacity) {
		super();
		this.storage = new EnergyStorage(capacity);
		this.output = output;
		storage.setMaxReceive(64000);
		storage.setMaxExtract(output);
		storage.setMaxTransfer(output);
	}
	
	public TileEntityBasicStorage(int output, int capacity, int maxInput) {
		super();
		this.storage = new EnergyStorage(capacity);
		this.output = output;
		storage.setMaxReceive(maxInput);
		storage.setMaxExtract(output);
		storage.setMaxTransfer(output);
	}
	
	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		return true;
	}

	@Override
	public int receiveEnergy(ForgeDirection from, int maxReceive, boolean simulate) {
		return 0;
	}

	@Override
	public int extractEnergy(ForgeDirection from, int maxExtract, boolean simulate) {
		return 0;
	}

	@Override
	public int getEnergyStored(ForgeDirection from) {
		return storage.getEnergyStored();
	}

	@Override
	public int getMaxEnergyStored(ForgeDirection from) {
		return storage.getMaxEnergyStored();
	}

	@Override
	public void readFromNBT(NBTTagCompound nbt) {
		super.readFromNBT(nbt);
		storage.readFromNBT(nbt);
	}

	@Override
	public void writeToNBT(NBTTagCompound nbt) {
		super.writeToNBT(nbt);
		storage.writeToNBT(nbt);
	}
	
	@Override
	public void updateEntity() {
		super.updateEntity();
		if ((storage.getEnergyStored() > 0)) {
			for (int i = 0; i < 6; i++) {
				TileEntity tile = worldObj.getTileEntity(xCoord + ForgeDirection.getOrientation(i).offsetX,
						yCoord + ForgeDirection.getOrientation(i).offsetY,
						zCoord + ForgeDirection.getOrientation(i).offsetZ);
				if (tile != null && tile instanceof IEnergyHandler) {
					storage.extractEnergy(
							((IEnergyHandler) tile).receiveEnergy(ForgeDirection.getOrientation(i).getOpposite(),
									storage.extractEnergy(storage.getMaxExtract(), true), false),
							false);
				}
			}
		}
	}

}
