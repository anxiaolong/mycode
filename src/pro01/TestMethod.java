package pro01;

public class TestMethod {
	public static void main(String[] args) {
		//Jia����û�м�static,��Ҫ����һ��������ʹ��
		TestMethod test = new TestMethod();
		System.out.println(test.Jia(1, 4));
		//ֱ�ӵ���Pt
		Pt();
	}
	
	//����һ�����������ӷ��ķ���
	public int Jia(int a,int b) {
		//return���������ã�һ���Ƿ��ؽ����һ���ǽ�������
		return a+b;
	}
	//void��ʾ�÷���û�з���ֵ������з���ֵ�����λ��д����ֵ������
	public static void Pt() {
		System.out.println("ִ����Pt����");
	}
}
