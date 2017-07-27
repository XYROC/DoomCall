package xiroc.doomcall.tileentity;

import cofh.api.energy.IEnergyHandler;
import doom.lib.block.BlockPos;
import doom.lib.machine.IMachineCore;
import doom.lib.machine.IMachinePart;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import xiroc.doomcall.block.BlockHandler;

public class TileEntityMachinePart extends TileEntityBasicStorage implements IMachinePart {

	public TileEntityMachinePart(int output) {
		super(output, 3200);
	}

	public TileEntityMachinePart() {
		super(32000, 3200);
	}

	@Override
	public int getMachineID() {
		return 0;
	}

	@Override
	public String getMachineName() {
		return "";
	}

	public boolean isEMFAssembled() {
		BlockPos pos = BlockHandler.getCoreBlock(BlockHandler.energetic_mass_fabricator, BlockHandler.machine_part,
				worldObj, xCoord, yCoord, zCoord);
		if (pos != null) {
			if (BlockHandler.isDefaultMultiblockStructure(BlockHandler.energetic_mass_fabricator,
					BlockHandler.machine_part, worldObj, pos.getX(), pos.getY(), pos.getZ())) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isAssembled() {
		return isEMFAssembled();
	}

	@Override
	public void updateEntity() {
		if ((storage.getEnergyStored() > 0)) {
			for (int k = -1; k < 2; k++) {
				for (int b = -1; b < 2; b++) {
					for (int l = -1; l < 2; l++) {
						TileEntity tile = worldObj.getTileEntity(xCoord + k, yCoord + b, zCoord + l);
						if (tile != null && tile instanceof IEnergyHandler && tile instanceof IMachineCore) {
							storage.extractEnergy(
									((IEnergyHandler) tile).receiveEnergy(
											ForgeDirection.DOWN.getOpposite(),
											storage.extractEnergy(storage.getMaxExtract(), true), false),
									false);
						}
					}
				}
			}
		}

	}
}
