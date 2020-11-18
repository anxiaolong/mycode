package java_13_gof23;
/**
 * 把注册公司的流程封装成一个实体类
 * @author Administrator
 *
 */
public class Facade_Register {
	public void register() {
		Facade_Gsj gsj = new Cdgsj();
		gsj.checkName();
		Facade_Zjj zjj = new Cdzjj();
		zjj.orgCodeCertificate();
		Facade_Swj swj = new Cdswj();
		swj.taxCertificate();
		Facade_Bank bank = new Cdbank();
		bank.openAccount();
	}
}
