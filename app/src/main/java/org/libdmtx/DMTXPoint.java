package org.libdmtx;

/*
 * Clone From Java 8 SE at java.awt.Point
 */
public class DMTXPoint implements java.io.Serializable {
	public int x;

	public int y;

	private static final long serialVersionUID = -5276940640259749850L;

	public DMTXPoint() {
		this(0, 0);
	}

	public DMTXPoint(DMTXPoint p) {
		this(p.x, p.y);
	}

	public DMTXPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public DMTXPoint getLocation() {
		return new DMTXPoint(x, y);
	}

	public void setLocation(DMTXPoint p) {
		setLocation(p.x, p.y);
	}

	public void setLocation(int x, int y) {
		move(x, y);
	}

	public void setLocation(double x, double y) {
		this.x = (int) Math.floor(x + 0.5);
		this.y = (int) Math.floor(y + 0.5);
	}

	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void translate(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public boolean equals(Object obj) {
		if (obj instanceof DMTXPoint) {
			DMTXPoint pt = (DMTXPoint) obj;
			return (x == pt.x) && (y == pt.y);
		}
		return super.equals(obj);
	}

	public String toString() {
		return getClass().getName() + "[x=" + x + ",y=" + y + "]";
	}
}
