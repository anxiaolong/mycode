package cy_class;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * ���ӻ�����
 * @author Administrator
 *
 */
public class TestCalendar {
	public static void main(String[] args) {
		
		//�Ӽ��̻�ȡyyyy-MM-dd��ʽ������
		System.out.println("���������ڣ���ʽ�磺2019-01-01:\n");
		Scanner s = new Scanner(System.in);
		String s_date = s.next();
		
		//��������ַ���ת��Ϊ���������
		String[] s1 = s_date.split("-"); //��-���ַ���������Ϊ����
		int year = Integer.parseInt(s1[0]); //ֱ�ӽ��ַ���ת��Ϊ������
		int month = Integer.parseInt(s1[1]);
		int dayOfMonth = Integer.parseInt(s1[2]);
		GregorianCalendar g = new GregorianCalendar(year, month-1, dayOfMonth); //����0-11
		
		g.set(Calendar.DAY_OF_MONTH, 1); //��������Ϊ����1��
		int dow = g.get(Calendar.DAY_OF_WEEK); //1�Ŷ�Ӧ��������һ�ܵĵڼ���
//		System.out.println(dow);  //1�Ŷ�Ӧ����һ�ܵĵ�����
		System.out.println("��\tһ\t��\t��\t��\t��\t��");
		for (int i = 0; i < dow - 1; i++) {
            System.out.print("\t");  //��ӡ�����ո�1�ű��������ڶ�λ��
        }
		int maxDate = g.getActualMaximum(Calendar.DAY_OF_MONTH); //��ȡ�����������ֵ
//        System.out.println("maxDate:"+maxDate);
        for (int i = 1; i <= maxDate; i++) {  //��1-31�ŵ�����ȫ����ӡ����
            StringBuilder sBuilder = new StringBuilder();
            if (g.get(Calendar.DATE) == dayOfMonth) {
                sBuilder.append(g.get(Calendar.DATE) + "*\t"); //��κ�����������ͬ��*
            } else {
                sBuilder.append(g.get(Calendar.DATE) + "\t");
            }
            System.out.print(sBuilder);
 
            if (g.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) { 
                System.out.print("\n"); //���������� ����
            }
            g.add(Calendar.DATE, 1);//ѭ��һ�Σ���������1
        }
	} 
}
