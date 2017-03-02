package 测试Shoot;

import java.awt.image.BufferedImage;

public abstract class FlyingObject {
	protected BufferedImage image;
	protected int width;
	protected int height;
	protected int x;
	protected int y;
	
	public abstract void step();
	
	public abstract boolean outSideBound();
}
