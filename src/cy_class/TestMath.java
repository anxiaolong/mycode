package cy_class;
/**
 * Math类和Random类
 */
import java.util.Random;

public class TestMath {
	//math类中常用方法和变量
	public static void test1() {
		System.out.println(Math.ceil(6.11)); //ceil方法，取大于6.11的最小整数
		System.out.println(Math.abs(-3.12)); //abs取绝对值
		System.out.println(Math.sqrt(16)); //对参数进行开平方
		System.out.println(Math.cos(12)); //三角函数
		System.out.println(Math.sin(9));
		System.out.println(Math.pow(2, 3)); //幂次函数
		System.out.println(Math.max(19, 8)); //取最大值
		System.out.println(Math.min(45, 2)); //取最小值
		System.out.println(Math.floor(4.9)); //小于参数最大整数
		System.out.println(Math.random()); //随机【0，1）的数
		System.out.println(Math.round(3.4)); //round四舍五入
		System.out.println(Math.toDegrees(Math.PI/2)); //弧度转角度
		System.out.println(Math.toRadians(90)); //角度转弧度
		System.out.println(Math.E); //自然底数
	}
	//Random类的常用方法
	public static void test2() {
		Random r1Random = new Random();
		System.out.println(r1Random.nextDouble()); //随机生成【0，1）之间double类型数
		System.out.println(r1Random.nextFloat()); //随机生成一个【0，1）之间float数
		System.out.println(r1Random.nextInt()); //随机生成一个整型数
		System.out.println(r1Random.nextBoolean()); //随机生成一个布尔值
		System.out.println(r1Random.nextInt(10)); //[0,10)之间的整数
		System.out.println(r1Random.nextInt(10)+30); //[30,40)之间的数
		System.out.println((int)(r1Random.nextFloat()*10)+30); //[30,40)之间的数
	}
	public static void main(String[] args) {
		test1();
		test2();
	}
}
