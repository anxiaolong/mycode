package java_13_gof23;
/**
 * 总经理类
 * @author Administrator
 *
 */
public class ChainOfResp_GeneralManager extends ChainOfResp_Leader {
	public ChainOfResp_GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(ChainOfResp_LeaveResquest leaveResquest) {
		if (leaveResquest.getLeaveDays()<20) {
			System.out.println(leaveResquest.getEmpName()+"-->"+leaveResquest.getReason()+"-->"+leaveResquest.getLeaveDays());
			System.out.println("GeneralManager:"+this.name+"-->同意");
		} else {
			if (this.nextLeader!=null) {
				this.nextLeader.handleRequest(leaveResquest);
			}
		}
	}
}
