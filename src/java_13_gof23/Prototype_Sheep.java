package java_13_gof23;
/**
 * 需要克隆的sheep类
 */
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("all")
public class Prototype_Sheep implements Cloneable,Serializable {
	private String sname;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		return obj;
	}
	
	public Prototype_Sheep() {
		// TODO Auto-generated constructor stub
	}
	
	public Prototype_Sheep(String sname,Date birthday) {
		this.sname = sname;
		this.birthday = birthday;
	}
	
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	
}
