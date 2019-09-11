package pro01;

public class TestFor2 {
	public static void main(String[] args) {
//		for (int i = 1; i <=9 ; i++) {
//			for (int j = 1; j <= 9; j++) {
//				System.out.print(j + "*" + i + "=" + i*j+" ");
//				if (i==j) {
//					System.out.println("\n");
//				}
//			}
//			System.out.println( );
//		}
        for (int i = 1; i < 10; i++) { // i是一个乘数
        	//第二个for里面条件使用j<i，保证j>i的情况下回跳出循环进行换行
        	for (int j = 1; j <=i ; j++) {
				System.out.print(i+"*"+j+"="+(i*j)+" ");
			}
        	System.out.println(); //println 输出后自动换行
        }
	}
}
