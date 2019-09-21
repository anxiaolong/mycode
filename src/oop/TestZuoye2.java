package oop;
/**
 * 编写应用程序，创建类的对象，分别设置圆的半径、圆柱体的高，
 * 计算并分别显示圆半径、圆面积、圆周长，圆柱体的体积
 */
import static java.lang.Math.PI;

public class TestZuoye2 {
	public static void main(String[] args) {
		YuanZhu tYuanZhu = new YuanZhu(1, 1);
		tYuanZhu.result();
	}
}

class Yuan {
	double r;
	
	public Yuan(double r) {
		this.r = r;
	}
	public Yuan() {
		super();
	}
	public double zc() {
		return 2*PI*r;
	}
	public double mj() {
		return PI*Math.pow(r, 2);
	}
}

class YuanZhu extends Yuan {
	double h;
	
	public YuanZhu(double r,double h) {
		this.r = r;
		this.h = h;
	}
	public double Tj() {
		return h*(this.mj());
	}
	public void result() {
		System.out.println("半径："+r);
		System.out.println("周长："+this.zc());
		System.err.println("面积："+this.mj());
		System.out.println("体积："+this.Tj());
	}
}