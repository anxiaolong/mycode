package pro01;

public class TestWhile {
	public static void main(String[] args) {
		int i = 1;
		int sum =0;
//		while (i<=100) {
//			System.out.println(i);
//			System.out.println(sum);
//			sum += i;
//			i++;
//		}
//		System.out.println(sum);
		
		do {
			sum += i;
			i ++;
		} while (i<=100);
		System.out.println(sum);
	}
}
