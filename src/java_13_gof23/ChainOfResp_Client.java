package java_13_gof23;
/**
 * ����������ģʽ
 * @author Administrator
 *
 */
public class ChainOfResp_Client {
	public static void main(String[] args) {
		ChainOfResp_LeaveResquest request1 = new ChainOfResp_LeaveResquest("���»�", 10, "���ݳ������");
		ChainOfResp_Leader Director = new ChainOfResp_Director("����");
		ChainOfResp_Leader Manager = new ChainOfResp_Manager("����");
		ChainOfResp_Leader GeneralManager = new ChainOfResp_GeneralManager("����");
		Director.setNextLeader(Manager);
		Manager.setNextLeader(GeneralManager);
		
		
		Director.handleRequest(request1);
	}
}
