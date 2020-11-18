package java_12_zj_fs_zjm_ljz;

import java.io.Serializable;

@SuppressWarnings("all")
public class Javassist_Emp implements Serializable {
	private int id;
	private String name;
	
	public Javassist_Emp() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
		System.out.println(id);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
