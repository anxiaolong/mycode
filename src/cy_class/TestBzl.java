package cy_class;
/**
 * ��װ�����
 * @author Administrator
 *
 */

public class TestBzl  {
	//װ�����������
	public static void test1() {
		Integer a = new Integer(10);
		Double b = Double.valueOf(3.22);
		//װ��
		Integer c = Integer.valueOf(33); //�Ƽ�����valueof����������װ�����-128~127֮���ֵ����л��洦�������Ч��
		Integer d = 33; //����ͨ��������Ϊ�������Զ�װ�䣬ִ����valueOf����
		//����
		int e = a.intValue(); //����Ĺ��̾��Ƕ������intValue����
//		System.out.println(a);
//		System.out.println(b);
//		System.out.println(d);
//		System.out.println(e);
		//�ַ���ת��ΪInteger����
		Integer s = Integer.parseInt("6666"); //�ַ�����������������֣������쳣
		Integer s1 = new Integer("345"); //�ַ�����������������֣������쳣
//		System.out.println(s1);
//		System.out.println(s);
		//Integer����ת�ַ���
		String mString = s.toString();
		System.out.println(mString);
		//int������س���
		System.out.println(Integer.MAX_VALUE+" "+Integer.MIN_VALUE);
	}
	//�Զ�װ��Ͳ���
	public static void test2() {
		Integer a = 24; //�Զ�װ�����һ������
		int b = Integer.valueOf(33); //�Զ������int������
		int c = new Integer(45); //�Զ������int
		Integer d = null;
//		int e = d; //��ָ������Ϊd������ d.intValue(),dΪnull��û��ָ��������Ա���
	}
	//��װ��Ļ���
	public static void test3() {
//	    public static Integer valueOf(int i) {
//        if (i >= IntegerCache.low && i <= IntegerCache.high)
//            return IntegerCache.cache[i + (-IntegerCache.low)];
//        return new Integer(i);
//    }
		Integer a = -128;
		Integer b = -128;
		System.out.println(a==b);
		System.out.println(a.equals(b));
		Integer a1 = -129;
		Integer b1 = -129;
		System.out.println(a1==b1); //-129���ڻ����У��������½���
		System.out.println(a1.equals(b1)); //�����ֵ��ͬ
	}
		public static void main(String[] args) {
			test1();
			test2();
			test3();
		}
}
