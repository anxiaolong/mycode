package pro01;

public class TestLeixingzhuanhuan {
	public static void main(String[] args) {
		double x  = 3.14; 
		int nx = (int)x;   //值为3
		char c = 'a';
		int d = c+1;
		System.out.println(nx);
		System.out.println(d);
		System.out.println((char)d);
		
		int q = 300;
		byte bx = (byte)q;    //值为44,强制转换超出了表数范围
		System.out.println(bx);
		
		int money = 1000000000; //10亿
		int years = 20;
		//返回的total是负数，超过了int的范围
		int total = money*years;
		System.out.println("total="+total);
		//返回的total仍然是负数。默认是int，因此结果会转成int值，再转成long。但是已经发生//了数据丢失
		long total1 = money*years; 
		System.out.println("total1="+total1);
		long total2 = money*((long)years); 
		//参与运算的变量先转化位long，运算都使用long来进行结果正确
		System.out.println("total2="+total2);
		
	}
}
