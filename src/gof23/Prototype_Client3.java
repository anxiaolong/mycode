package gof23;
/**
 * 测试原型模式，在clone方法中，将属性也进行复制实现深克隆
 */
import java.sql.Date;

public class Prototype_Client3 {
	public static void main(String[] args) throws Exception {
		Date date = new Date(8534346555L);
		Prototype_Sheep2 s1 = new Prototype_Sheep2("母体", date);
		Prototype_Sheep2 s2 = (Prototype_Sheep2)s1.clone();
		System.out.println("克隆完成");
		System.out.println(s1);
		System.out.println(s1.getSname());
		System.out.println("母体："+s1.getBirthday());
		
		date.setTime(5534346555L);
		
		System.out.println("date修改后 母体："+s1.getBirthday());
		
		
		s2.setSname("克隆羊");
		System.out.println(s2);
		System.out.println(s2.getSname());
		System.out.println("克隆羊："+s2.getBirthday());
	}
}
