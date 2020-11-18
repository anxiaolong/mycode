package java_13_gof23;
/**
 * 测试原型模式，使用序列化和反序列化实现深复制
 */
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Date;

public class Prototype_Client2 {
	public static void main(String[] args) throws Exception {
		Date date = new Date(99444448768L);
		Prototype_Sheep s1 = new Prototype_Sheep("母体", date);
		System.out.println(s1.getSname());
		System.out.println(s1.getBirthday());
		
		//序列化和反序列化
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(s1);
		byte[] b1 = baos.toByteArray();
		
		ByteArrayInputStream bais = new ByteArrayInputStream(b1);
		ObjectInputStream ois = new ObjectInputStream(bais);
		Prototype_Sheep s2 = (Prototype_Sheep) ois.readObject();
		
		//修改date值
		date.setTime(79444448768L);
		System.out.println("修改后母体："+s1.getBirthday());
		
		s2.setSname("克隆羊");
		System.out.println(s2.getSname());
		System.out.println(s2.getBirthday());
	}
}
