package pro01;
/**
 * �����Ʋ���׼ȷ�ı���ʮ�����µĺܶ�С����
 * ԭ����2����С��ֻ�ܱ�ʾλ1/2^n,ֻ�ܽӽ�ĳЩС��
 * ��Ҫ���о�ȷ���㣬ʹ��BigDecimal��
 * Float������β��ں����F��Ĭ��Ϊdouble����
 */
import java.math.BigDecimal;

public class TestDateType {
	public static void main(String[] args) {
		long a = 55555555;  //��int������Χ�ڣ�21���ڣ�
		long b = 8888888888L; //����L�ᱨ������int������Χ
		
        BigDecimal bd = BigDecimal.valueOf(1.0);
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        bd = bd.subtract(BigDecimal.valueOf(0.1));
        System.out.println(bd);//0.5
        System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);//0.5000000000000001
        
        // ����������������бȽ�����
        float f = 0.1f;
        double d = 1.0/10;
        System.out.println(f==d);//���Ϊfalse
        
        float d1 = 423432423f;
        float d2 = d1+1;
        if(d1==d2){
           System.out.println("d1==d2");//������Ϊd1==d2
        }else{
            System.out.println("d1!=d2");
        }
	}
}
