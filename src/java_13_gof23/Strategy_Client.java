package java_13_gof23;
/**
 * ²âÊÔ²ßÂÔÄ£Ê½
 * @author Administrator
 *
 */
public class Strategy_Client {
	public static void main(String[] args) {
		Strategy_Strategy s1 = new Strategy_OldCustomerMany();
		Strategy_Context context = new Strategy_Context(s1);
		
		context.pringPrice(1000);
		
		Strategy_Strategy s2 = new Strategy_NewCustomerMany();
		Strategy_Context context2 = new Strategy_Context(s2);
		
		context2.pringPrice(1000);
	}
}
