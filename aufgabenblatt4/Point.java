package aufgabenblatt4;

public class Point implements Comparable<Point>{
	private double x;
	private double y;
	
	public Point()
	{
		this(0.0, 0.0);
	}
	
	public Point(double x, double y)
	{
		this.x = x;
		this.y = y;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	@Override
	public int compareTo(Point o) {
		
		return 0;
	}
	
	public String toString()
	{
		return "( " + x + ", " + y + " ) ";
	}
	
}