package day14.shoot02_让图片动;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	public abstract void step();
	
	public abstract boolean outOfBounds();
	
}
