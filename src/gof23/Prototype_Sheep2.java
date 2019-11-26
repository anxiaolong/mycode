package gof23;
/**
 * ��Ҫ��¡��sheep��
 */
import java.io.Serializable;
import java.sql.Date;

@SuppressWarnings("all")
public class Prototype_Sheep2 implements Cloneable,Serializable {
	private String sname;
	private Date birthday;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj = super.clone();
		
		//����Ҳ���п�¡ ʵ�����
		//�������ж��������һ���õ����¡���������������Ҳ������
		Prototype_Sheep2 s = (Prototype_Sheep2)obj;
		s.birthday = (Date) this.birthday.clone();
		return obj;
	}
	
	public Prototype_Sheep2() {
		// TODO Auto-generated constructor stub
	}
	
	public Prototype_Sheep2(String sname,Date birthday) {
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
