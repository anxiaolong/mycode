package jdbc;
/**
 * orm∂‘œÛ
 * @author Administrator
 */
import java.sql.Date;

public class Orm_emp {
	private Integer id;
	private String empname;
	private Integer age;
	private Double salary;
	private Date birthday;
	
	public Orm_emp(Integer id,String empname,Integer age,Double salary,Date birthday) {
		this.id = id;
		this.empname = empname;
		this.age = age;
		this.salary = salary;
		this.birthday = birthday;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	private Integer deptId;
}
