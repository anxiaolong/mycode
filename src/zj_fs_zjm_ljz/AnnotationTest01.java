package zj_fs_zjm_ljz;
/**
 * ���Գ�������ע��Override Deprecated SuppressWarnning
 * @author Administrator
 *
 */
public class AnnotationTest01 {
	
	@Override //overrideע�� ��д����ķ���
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
	
	@Deprecated //deprecated��ʾ������ʹ�õķ�����ǿ��Ҳ��
	public static void print() {
		System.out.println("test");
	}
	
	@SuppressWarnings(value = { "all" }) //���Ʊ��뾯��
	public static void getInput() {
		int m;
		String string;
	}
	
	public static void main(String[] args) {
		AnnotationTest01.print();
	}
}
