package java_13_gof23;
/**
 * 定义Leader这个抽象类
 * @author Administrator
 *
 */
public abstract class ChainOfResp_Leader {
	protected String name;
	protected ChainOfResp_Leader nextLeader;
	
	public ChainOfResp_Leader(String name) {
		this.name = name;
	}
	
	public void setNextLeader(ChainOfResp_Leader leader) {
		this.nextLeader = leader;
	}
	
	public abstract void handleRequest(ChainOfResp_LeaveResquest leaveResquest);
}
