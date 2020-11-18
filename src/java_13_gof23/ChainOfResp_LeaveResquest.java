package java_13_gof23;
/**
 * «ÎºŸ«Î«Û¿‡
 * @author Administrator
 *
 */
public class ChainOfResp_LeaveResquest {
	private String empName;
	private int leaveDays;
	private String reason;
	
	public ChainOfResp_LeaveResquest(String empName,int leaveDays,String reason) {
		this.empName = empName;
		this.leaveDays = leaveDays;
		this.reason = reason;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getLeaveDays() {
		return leaveDays;
	}

	public void setLeaveDays(int leaveDays) {
		this.leaveDays = leaveDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}
	
	
}
