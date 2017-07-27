package doom.lib.gui;

public class ElementDualScalePart {
	
	public final int xMax;
	public final int xMin;
	public final int yMax;
	public final int yMin;
	public final int textureX;
	public final int textureY;
	public final int textureXSize;
	public final int textureYSize;
	
	public ElementDualScalePart(int xMax, int yMax, int xMin, int yMin, int textureX, int textureY, int textureXSize, int textureYSize) {
		this.xMax = xMax;
		this.yMax = yMax;
		this.xMin = xMin;
		this.yMin = yMin;
		this.textureX = textureX;
		this.textureY = textureY;
		this.textureXSize = textureXSize;
		this.textureYSize = textureXSize;
	}

}
