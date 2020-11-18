package java_02_oop;
/**
 * 接口练习题目
 * 编写程序描述影视歌三栖艺人。需求说明：请使用面向对象的思想，设计自定义类，描述影视歌三梄艺人
 * @author Administrator
 *
 */
public class TestZuoye4 {
	public static void main(String[] args) {
		Artist a1Artist = new Artist();
		a1Artist.show();
	}
}

interface Cg {
	public void cg();
}

interface Dsg {
	public void dsg();
}

interface Dy {
	public void dy();
}

class Artist implements Cg,Dsg,Dy {
	
	public void show() {
		System.out.println("我会：");
		this.cg();
		this.dsg();
		this.dy();
	}
	@Override
	public void cg() {
		System.out.println("唱歌");
	}

	@Override
	public void dy() {
		System.out.println("演电影");
	}

	@Override
	public void dsg() {
		System.out.println("演电视剧");
	}
}
