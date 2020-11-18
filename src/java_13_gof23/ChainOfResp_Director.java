package java_13_gof23;
/**
 * 主任类
 * @author Administrator
 *
 */
public class ChainOfResp_Director extends ChainOfResp_Leader {
	public ChainOfResp_Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(ChainOfResp_LeaveResquest leaveResquest) {
		if (leaveResquest.getLeaveDays()<3) {
			System.out.println(leaveResquest.getEmpName()+"-->"+leaveResquest.getReason()+"-->"+leaveResquest.getLeaveDays());
			System.out.println("Director:"+this.name+"-->同意");
		} else {
			if (this.nextLeader!=null) {
				this.nextLeader.handleRequest(leaveResquest);
			}
		}
	}
}
