package pro01;


public class TestIf {
	public static void main(String[] args) {
//		System.out.println(Math.random());
//		int a = (int)(6*Math.random())+1; //����ȡֵ��Χ[0,1)
//		int b = (int)(6*Math.random())+1;
//		int c = (int)(6*Math.random())+1;
//		int sum = a + b + c;
//		System.out.println(sum);
//		sum = 16;
//		
//		if (sum>15) {
//			System.out.println("�������");
//		}
//		if (sum>=10&&sum<=15) {
//			System.out.println("һ��");
//		}
//		if (sum<10) {
//			System.out.println("̫��");
//		}
//		double r = 4*Math.random();
//		double mj = Math.PI*Math.pow(r, 2);
//		double zc = 2*Math.PI*r;
//		System.out.printf("%f\n %f\n %f\n", r,mj,zc);
//		System.out.println(Math.PI);
		
//		if (mj > zc) {
//			System.out.println("��������ܳ�");
//		} else {
//			System.out.println("�ܳ��������");
//		}
		
//		System.out.println(mj>zc?"��������ܳ�":"�ܳ��������");  //��Ŀ���㴦��÷�֧
		int p = (int)(100*Math.random());
		p = 64;
		//����˳��д��ֻ�ܴӷ�Χ��С�Ŀ�ʼ�ж�
		if (p < 60) {
			System.out.println("������ ������"+p);
		} else if (p <= 70) {
			System.out.println("���� ������"+p);
		} else if (p <= 84) {
			System.out.println("�� ������"+p);
		} else {
			System.out.println("���� ������"+p);
		}
		
		
	}
}
