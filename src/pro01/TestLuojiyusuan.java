/**
 * &与 |或 !非 ^异或
 * &&短路与 ||短路或 
 */
package pro01;

public class TestLuojiyusuan {
	public static void main(String[] args) {
		boolean a = true;
		boolean b = false;
//		System.out.println(a&b);
//		System.out.println(a|b);
//		System.out.println(a^b);
//		System.out.println(!a);
		boolean c = 1>2 && 1>3/0; //短路与只计算1>2，跳过了第二个条件
//		boolean d = 1>2 & 1>3/0; //不用短路直接会报错，使用短路&&和||可提高代码效率
//		boolean e = 1<2 | 1>3/0; //逻辑或这样写也会报错
		boolean e = 1<2 || 1>3/0;
		System.out.println(c); 
		System.out.println(e);
	}
}
