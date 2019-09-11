package pro01;

public class TestSwitch {
	public static void main(String[] args) {
		int a = (int)(Math.random()*3+1);
		System.out.println(a);
//		a = 4;
		switch (a) {
		case 1:
			System.out.println("现在是1月 "+a);
			break;
		case 2:
			System.out.println("现在是2月 "+a);
			break;
		case 3:
			System.out.println("现在是3月 "+a);
			break;	
		default:
			System.out.println("程序异常");
			break;
		}
	}
}
