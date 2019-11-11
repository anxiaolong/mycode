package zj_fs_zjm_ljz;
/**
 * 测试常用三个注解Override Deprecated SuppressWarnning
 * @author Administrator
 *
 */
public class AnnotationTest01 {
	
	@Override //override注解 重写父类的方法
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Deprecated //deprecated表示不建议使用的方法，强用也行
	public static void print() {
		System.out.println("test");
	}
	
	@SuppressWarnings(value = { "all" }) //抑制编译警告
	public static void getInput() {
		int m;
		String string;
	}
	
	public static void main(String[] args) {
		AnnotationTest01.print();
	}
}
