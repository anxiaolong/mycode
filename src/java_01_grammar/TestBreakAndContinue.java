package java_01_grammar;

public class TestBreakAndContinue {
	public static void main(String[] args) {
		a:for (int i = 1; i < 11; i++) {
			for (int j = 1; j < i; j++) {
				if (i==5) {
					//break; //breakֱ������ѭ��
					//a�Ǳ�ǩ��break��continue�������ǩ���ڴ�����
					break a; //��iΪż��ʱ������������ִ�У��ص�ѭ���������Ӽ���ִ��
				}
				System.out.println(i+" "+j);
			}
		}
	}
}
