package cy_class;
/**
 * ���ӻ�����
 * @author Administrator
 *
 */
import java.util.Arrays;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;


public class TestCalendar {
	public static void test1() {
		
	}
	public static void main(String[] args) {
		//��������
		System.out.println("�����ʽ��yyyy-MM-dd�����ڣ�");
		Scanner inScanner = new Scanner(System.in);
		String aString = inScanner.next();
		
		String[] a = aString.split("-"); //���ַ������Ϊ����
		System.out.println(Arrays.toString(a)); 
		int y = Integer.parseInt(a[0]);
		int m = Integer.parseInt(a[1]);
		int d = Integer.parseInt(a[2]);
		//newһ��GregorianCalendar����
		GregorianCalendar g = new GregorianCalendar(y,m-1,d); //�·�һ��Ҫ-1
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		g.set(Calendar.DAY_OF_MONTH, 1); //g����������Ϊ1��
//		System.out.println(g.get(Calendar.DAY_OF_WEEK)); //��ǰ������һ���еĵڼ���
		for (int i = 1; i < g.get(Calendar.DAY_OF_WEEK); i++) {
			System.out.print("\t"); //������һ�пո񣬸�����һ�ܵĵڼ������
		}
		int max = g.getActualMaximum(Calendar.DAY_OF_MONTH); //��ȡ�����������
		for (int i = 1; i <= max; i++) {
			if ((g.get(Calendar.DAY_OF_MONTH)==d)) {
				System.out.print(g.get(Calendar.DAY_OF_MONTH)+"*\t"); //�ж�����ǵ��ռ�*
			} else {
				System.out.print(g.get(Calendar.DAY_OF_MONTH)+"\t");
			}	
			if (g.get(Calendar.DAY_OF_WEEK)==7) {
				System.out.println(); //�ж���������������
			}
			g.add(Calendar.DAY_OF_MONTH, 1);
		}
		}
}













