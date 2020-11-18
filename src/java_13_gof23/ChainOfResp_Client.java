package java_13_gof23;
/**
 * 测试责任链模式
 * @author Administrator
 *
 */
public class ChainOfResp_Client {
	public static void main(String[] args) {
		ChainOfResp_LeaveResquest request1 = new ChainOfResp_LeaveResquest("刘德华", 10, "开演唱会请假");
		ChainOfResp_Leader Director = new ChainOfResp_Director("张三");
		ChainOfResp_Leader Manager = new ChainOfResp_Manager("李四");
		ChainOfResp_Leader GeneralManager = new ChainOfResp_GeneralManager("王五");
		Director.setNextLeader(Manager);
		Manager.setNextLeader(GeneralManager);
		
		
		Director.handleRequest(request1);
	}
}
