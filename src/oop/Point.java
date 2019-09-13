package oop;

public class Point {
	
	double _x;
	double _y;
	
	public static double Dis(Point p,Point q) {
		return Math.sqrt(Math.pow((p._x-q._x), 2)+Math.pow((p._y-q._y), 2));
	}
	
	//构造方法，必须设置x和y的坐标，才能创建对象
	public  Point(double x,double y) {
		_x = x;
		_y = y;
	}
	
	public static void main(String[] args) {
		Point p1 = new Point(3, 5);
		Point p2 = new Point(23, 89);
		System.out.println(Point.Dis(p1, p2));
	}
	
}
