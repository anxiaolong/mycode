package java_13_gof23;
/**
 * ²âÊÔµü´úÆ÷Ä£Ê½
 * @author Administrator
 *
 */
public class Iterator_Client {
	public static void main(String[] args) {
		Iterator_Test t1 = new Iterator_Test();
		t1.addObject("dd");
		t1.addObject("23");
		t1.addObject("vvs");
		t1.addObject("hthf");
		
		Iterator_MyIterator iter = t1.createIterator();
		while (iter.hasNext()) {
			System.out.println(iter.getCurrentObj());
			iter.next();
		}
	}
}
