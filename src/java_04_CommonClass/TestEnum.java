package java_04_CommonClass;
/**
 * ����ö�ٵ�ʹ��
 * @author Administrator
 *
 */
public class TestEnum {
	public static void main(String[] args) {
		//foreachѭ����ö���������������
		for (Season s : Season.values()) { 
			System.out.println(s);
		}
		for (Week w : Week.values()) {
			System.out.println(w);
		}
		//
		int a = (int)(Math.random()*4);
		switch (Season.values()[a]) {
		case ��:
			System.out.println("��");
			break;
		case ��:
			System.out.println("��");
			break;
		case ��:
			System.out.println("��");
			break;
		case ��:
			System.out.println("��");
			break;
		default:
			System.out.println("û����ö����֮��");
			break;
		}
	}
}


enum Season{
	��,��,��,��;
}

enum Week{
	����һ,���ڶ�,������,������,������,������,������;
}