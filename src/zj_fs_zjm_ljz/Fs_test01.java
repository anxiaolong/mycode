package zj_fs_zjm_ljz;
/**
 * ������Ͷ����ȡClass����ķ���
 * ��.class  object.getClass()
 * @author Administrator
 *
 */
@SuppressWarnings("all")//�����¾�����Ϣ
public class Fs_test01 {
	public static void main(String[] args) {
		String path = "zj_fs_zjm_ljz.Fs_User";
		try {
			Class clz = Class.forName(path);
			//��ӡClass�����hashCode
			System.out.println(clz.hashCode());
			
			Class clz2 = Class.forName(path);
			//����Class�����hashCode����ͬ�ģ�˵��һ����ֻ�ܷ���ͬһ������
			System.out.println(clz2.hashCode());
			
			//ͨ��������÷������
			Class strClass = String.class;
			//�Թ������÷������
			Class strClass2 = path.getClass();
			//�������ͻ�ȡ�������
			Class intClass = int.class;
			//���鷴�����Ƚ�,��ͬ�������鷴�������ͬ���ͳ����޹�
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
