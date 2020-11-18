package java_13_gof23;
/**
 * 经理类
 * @author Administrator
 *
 */
public class ChainOfResp_Manager extends ChainOfResp_Leader {
	public ChainOfResp_Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(ChainOfResp_LeaveResquest leaveResquest) {
		if (leaveResquest.getLeaveDays()<10) {
			System.out.println(leaveResquest.getEmpName()+"-->"+leaveResquest.getReason()+"-->"+leaveResquest.getLeaveDays());
			System.out.println("Manager:"+this.name+"-->同意");
		} else {
			if (this.nextLeader!=null) {
				this.nextLeader.handleRequest(leaveResquest);
			}
		}
	}
}
