package pro01;
/**
 * 二进制不能准确的表是十进制下的很多小数，
 * 原因是2进制小数只能表示位1/2^n,只能接近某些小数
 * 需要进行精确运算，使用BigDecimal类
 * Float类型如何不在后面加F，默认为double类型
 */
import java.math.BigDecimal;

public class TestDateType {
	public static void main(String[] args) {
		long a = 55555555;  //在int表述范围内（21亿内）
		long b = 8888888888L; //不加L会报错，超出int表数范围
		
        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd);//0.5
        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);//0.5000000000000001
        
        // 浮点数有误差，避免进行比较运算
        float f = 0.1f;
        double d = 1.0/10;
        System.out.println(f==d);//结果为false
        
        float d1 = 423432423f;
        float d2 = d1+1;
        if(d1==d2){
           System.out.println("d1==d2");//输出结果为d1==d2
        }else{
            System.out.println("d1!=d2");
        }
	}
}
