package collection;

/**
 * 测试泛型generics
 * @author Administrator
 *
 */
public class TestGenerics {
	public static void main(String[] args) {
		//确定了类型E为string
		Mycollection<String> t = new Mycollection();
		t.setA("anxiaolong", 0);
		t.setA("test", 1);
		String s = t.getA(0);//存到Object[]里面的是对象，泛型定义为string，取出时候直接就是string类型
		System.out.println(s);
	}
}

class Mycollection<E> { //使用泛型必须在类后面加标识
	Object[] a = new Object[5];  //定义一个Object类型的一维数组

	public E getA(int index) { //返回值是泛型，用E表示
		return (E) a[index]; //a[index]是说明类型就返回说明类型
	}

	public void setA(E e,int index) {  //E e 表示任一类型
		this.a[index] = e;  //e赋值给a[index]
	}
}