package oop;
/**
 * ��дӦ�ó��򣬴�����Ķ��󣬷ֱ�����Բ�İ뾶��Բ����ĸߣ�
 * ���㲢�ֱ���ʾԲ�뾶��Բ�����Բ�ܳ���Բ��������
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
		System.out.println("�뾶��"+r);
		System.out.println("�ܳ���"+this.zc());
		System.err.println("�����"+this.mj());
		System.out.println("�����"+this.Tj());
	}
}