package cy_class;
/**
 * Math���Random��
 */
import java.util.Random;

public class TestMath {
	//math���г��÷����ͱ���
	public static void test1() {
		System.out.println(Math.ceil(6.11)); //ceil������ȡ����6.11����С����
		System.out.println(Math.abs(-3.12)); //absȡ����ֵ
		System.out.println(Math.sqrt(16)); //�Բ������п�ƽ��
		System.out.println(Math.cos(12)); //���Ǻ���
		System.out.println(Math.sin(9));
		System.out.println(Math.pow(2, 3)); //�ݴκ���
		System.out.println(Math.max(19, 8)); //ȡ���ֵ
		System.out.println(Math.min(45, 2)); //ȡ��Сֵ
		System.out.println(Math.floor(4.9)); //С�ڲ����������
		System.out.println(Math.random()); //�����0��1������
		System.out.println(Math.round(3.4)); //round��������
		System.out.println(Math.toDegrees(Math.PI/2)); //����ת�Ƕ�
		System.out.println(Math.toRadians(90)); //�Ƕ�ת����
		System.out.println(Math.E); //��Ȼ����
	}
	//Random��ĳ��÷���
	public static void test2() {
		Random r1Random = new Random();
		System.out.println(r1Random.nextDouble()); //������ɡ�0��1��֮��double������
		System.out.println(r1Random.nextFloat()); //�������һ����0��1��֮��float��
		System.out.println(r1Random.nextInt()); //�������һ��������
		System.out.println(r1Random.nextBoolean()); //�������һ������ֵ
		System.out.println(r1Random.nextInt(10)); //[0,10)֮�������
		System.out.println(r1Random.nextInt(10)+30); //[30,40)֮�����
		System.out.println((int)(r1Random.nextFloat()*10)+30); //[30,40)֮�����
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
}
