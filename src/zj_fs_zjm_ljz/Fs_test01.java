package zj_fs_zjm_ljz;
/**
 * 测试类和对象获取Class对象的方法
 * 类.class  object.getClass()
 * @author Administrator
 *
 */
@SuppressWarnings("all")//抑制下警告信息
public class Fs_test01 {
	public static void main(String[] args) {
		String path = "zj_fs_zjm_ljz.Fs_User";
		try {
			Class clz = Class.forName(path);
			//打印Class对象的hashCode
			System.out.println(clz.hashCode());
			
			Class clz2 = Class.forName(path);
			//两个Class对象的hashCode是相同的，说明一个类只能反射同一个对象
			System.out.println(clz2.hashCode());
			
			//通过类名获得反射对象
			Class strClass = String.class;
			//对过对象获得反射对象
			Class strClass2 = path.getClass();
			//基本类型获取反射对象
			Class intClass = int.class;
			//数组反射对象比较,相同类型数组反射对象相同，和长度无关
			int[] arr1 = new int[10];
			int[][] arr2 = new int[30][3];
			int[] arr3 = new int[30];
			double[] arr4 = new double[10];
			int[][] arr5 = new int[1][3];
			System.out.println(arr1.getClass().hashCode());
			System.out.println(arr2.getClass().hashCode());
			System.out.println(arr3.getClass().hashCode());
			System.out.println(arr4.getClass().hashCode());
			System.out.println(arr5.getClass().hashCode());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
