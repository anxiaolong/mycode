package java_13_gof23;
/**
 * ����ԭ��ģʽ Ǳ��¡������û�б���¡������ĸ��仯
 */
import java.sql.Date;

public class Prototype_Client {
	public static void main(String[] args) throws Exception {
		Date date = new Date(8534346555L);
		Prototype_Sheep s1 = new Prototype_Sheep("ĸ��", date);
		Prototype_Sheep s2 = (Prototype_Sheep)s1.clone();
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
