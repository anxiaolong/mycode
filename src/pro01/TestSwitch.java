package pro01;

public class TestSwitch {
	public static void main(String[] args) {
		int a = (int)(Math.random()*3+1);
		System.out.println(a);
//		a = 4;
		switch (a) {
		case 1:
			System.out.println("������1�� "+a);
			break;
		case 2:
			System.out.println("������2�� "+a);
			break;
		case 3:
			System.out.println("������3�� "+a);
			break;	
		default:
			System.out.println("�����쳣");
			break;
		}
	}
}
