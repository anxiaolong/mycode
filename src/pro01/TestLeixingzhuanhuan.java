package pro01;

public class TestLeixingzhuanhuan {
	public static void main(String[] args) {
		double x  = 3.14; 
		int nx = (int)x;   //ֵΪ3
		char c = 'a';
		int d = c+1;
		System.out.println(nx);
		System.out.println(d);
		System.out.println((char)d);
		
		int q = 300;
		byte bx = (byte)q;    //ֵΪ44,ǿ��ת�������˱�����Χ
		System.out.println(bx);
		
		int money = 1000000000; //10��
		int years = 20;
		//���ص�total�Ǹ�����������int�ķ�Χ
		int total = money*years;
		System.out.println("total="+total);
		//���ص�total��Ȼ�Ǹ�����Ĭ����int����˽����ת��intֵ����ת��long�������Ѿ�����//�����ݶ�ʧ
		long total1 = money*years; 
		System.out.println("total1="+total1);
		long total2 = money*((long)years); 
		//��������ı�����ת��λlong�����㶼ʹ��long�����н����ȷ
		System.out.println("total2="+total2);
		
	}
}
