package java_13_gof23;
/**
 * ��ע�ṫ˾�����̷�װ��һ��ʵ����
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
