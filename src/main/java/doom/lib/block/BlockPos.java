package doom.lib.block;

import net.minecraft.world.World;

public class BlockPos {
	
	private World world;
	
	private int x;
	private int y;
	private int z;
	
	public BlockPos(World world, int x, int y, int z) {
		this.world = world;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public World getWorld() {
		return world;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getZ() {
		return z;
	}

}
