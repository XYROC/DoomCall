package xiroc.doomcall.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityHeavyCoalGenerator extends TileEntityBasicGenerator {

	public TileEntityHeavyCoalGenerator(int output, int generated) {
		super(output, generated);
	}

	@Override
	public void generate() {
		if (worldObj.getBlockMetadata(this.xCoord, this.yCoord, this.zCoord) > 7) {
			storage.modifyEnergyStored(generated);
		}
	}

	@Override
	public boolean canConnectEnergy(ForgeDirection from) {
		if (from != ForgeDirection.UP)
			return true;
		else
			return false;
	}

}