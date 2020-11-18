package java_01_grammar;

public class TestFor3 {
	public static void main(String[] args) {
//		//计算100以内奇数和偶数的和
//		int i = 100;
//		int sumj = 0;
//		int sumo = 0;
//		while (i>0 && i<101) {
//			if (i%2==0) {
//				sumo +=i;
////				System.out.println(i);
//			} else {
//				sumj +=i;
////				System.out.println(i);
//			}
//			i--;
//		}
//		System.out.println(sumj);
//		System.out.println(sumo);
		//计算1000以内，能被5整除的数，每行输出5个
		int i = 1000;
		int m = 0;
		while (i>0&&i<1001) {
			if (i%5==0) {
				System.out.print(i+" ");
				m++;
//				if (m%5==0) {
//					System.out.println();
//				}
				while (m%5==0) {
					System.out.println();
					break;
				}
		}
			i--;
	}
  }
}
