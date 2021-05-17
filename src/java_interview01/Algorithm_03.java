package java_interview01;
/**
 * 算法题：
 * 猴子分香蕉，7只猴子分7次，每只都分成7份并多拿一根
 * 最后刚好分完，最后剩下的是6份
 *
 */
public class Algorithm_03 {
	public static void test01() {
		int i = 1;
		while (true) {
			if (i%7==1) {
				int a1 = i-1-i/7;
				if (a1%7==1) {
					int a2 = a1-1-a1/7;
					if (a2%7==1) {
						int a3 = a2-1-a2/7;
						if (a3%7==1) {
							int a4 = a3-1-a3/7;
							if (a4%7==1) {
								int a5 = a4-1-a4/7;
								if (a5%7==1) {
									int a6 = a5-1-a5/7;
									if (a6%7==1) {
										int a7 = a6-1-a6/7;
										if (a7%7==0) {
											System.out.println(i);
										}
									}
								}
							}
						}
					}
				}
			}
			i++;
		}
	}
	
	public static void main(String[] args) {
		test01();
	}
}
