package xiroc.doomcall.tileentity;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraftforge.common.util.ForgeDirection;
import xiroc.doomcall.block.BlockType;
import xiroc.doomcall.energy.EnergyBar;
import xiroc.doomcall.energy.EnergyNet;
import xiroc.doomcall.energy.IEnergy;

public class TileEntityCable extends TileEntity implements IEnergy{
	
	private ForgeDirection lastRecievedDirection = ForgeDirection.UNKNOWN;
	private EnergyBar energyBar = new EnergyBar(100);
	
	@Override
	public void updateEntity() {
		EnergyNet.distributeEnergyToSurrounding(worldObj, xCoord, yCoord, zCoord, lastRecievedDirection, energyBar);
	}
	
	@Override
	public boolean canAddEnergyOnSide(ForgeDirection direction) {
		return true;
	}
	
	@Override
	public boolean canConnect(ForgeDirection direction) {
		return true;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public double getMaxRenderDistanceSquared() {
		return Double.MAX_VALUE;
	}
	
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return AxisAlignedBB.getBoundingBox(xCoord, yCoord, zCoord, xCoord + 1, yCoord + 1, zCoord + 1);
	}
	
	@Override
	public EnergyBar getEnergyBar() {
		return energyBar;
	}
	
	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound tag = new NBTTagCompound();
		writeToNBT(tag);
		return new S35PacketUpdateTileEntity(xCoord, yCoord, zCoord, 1, tag);
	}
	
	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity pkt) {
		readFromNBT(pkt.func_148857_g());
	}
	
	@Override
	public void writeToNBT(NBTTagCompound tag) {
		super.writeToNBT(tag);
		energyBar.writeToNBT(tag);
	}
	
	@Override
	public void readFromNBT(NBTTagCompound tag) {
		super.readFromNBT(tag);
		energyBar.readFromNBT(tag);
	}
	
	@Override
	public int getEnergyTransferRate() {
		return 100;
	}
	
	@Override
	public BlockType getBlockTypeD() {
		return BlockType.CABLE;
	}

	@Override
	public void setLastRecievedDirection(ForgeDirection direction) {
		this.lastRecievedDirection = direction;
	}

}
