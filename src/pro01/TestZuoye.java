package pro01;

public class TestZuoye {
	public static void main(String[] args) {
//		float r = 2.5F;
//		float pi = 3.14F;  //使用float类型
//		double r = 2.5; //使用double
//		double pi = 3.14;
//		System.out.println("周长="+2*pi*r);
//		System.out.println("面积="+pi*Math.pow(r, 2));
		
//		double c = 10000;
//		System.out.println("一年活期后本金和利息="+Math.round(c*(1+0.0035)));
//		System.out.println("两年活期后本金和利息="+Math.round(c*(Math.pow((1+0.0035), 2))));
//		System.out.println("一年定期后本金和利息="+Math.round(c*(1+0.015)));
//		System.out.println("两年定期后本金和利息="+Math.round(c*(Math.pow((1+0.021), 2))));
		int a = 1234;
		int a1 = a/1000;
		int a2 = (a-a1*1000)/100;
		int a3 = (a-a1*1000-a2*100)/10;
		int a4 = a-a1*1000-a2*100-a3*10;
		System.out.printf("%d,%d,%d,%d", a1,a2,a3,a4);
		
		int t1=0,t2=0;
		a1 = t1;
		
		
	}
}
