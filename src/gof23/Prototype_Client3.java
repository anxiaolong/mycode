package gof23;
/**
 * ����ԭ��ģʽ����clone�����У�������Ҳ���и���ʵ�����¡
 */
import java.sql.Date;

public class Prototype_Client3 {
	public static void main(String[] args) throws Exception {
		Date date = new Date(8534346555L);
		Prototype_Sheep2 s1 = new Prototype_Sheep2("ĸ��", date);
		Prototype_Sheep2 s2 = (Prototype_Sheep2)s1.clone();
		System.out.println("��¡���");
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println("ĸ�壺"+s1.getBirthday());
		
		date.setTime(5534346555L);
		
		System.out.println("date�޸ĺ� ĸ�壺"+s1.getBirthday());
		
		
		s2.setSname("��¡��");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println("��¡��"+s2.getBirthday());
	}
}
