package java_15_jdbc;
/**
 * orm¶ÔÏó
 * @author Administrator
 *
 */
public class Orm_dept {
	private Integer id;
	private String dname;
	private String address;
	
	public Orm_dept(Integer id,String dname,String address) {
		this.id = id;
		this.dname = dname;
		this.address = address;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
