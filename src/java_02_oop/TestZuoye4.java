package java_02_oop;
/**
 * �ӿ���ϰ��Ŀ
 * ��д��������Ӱ�Ӹ��������ˡ�����˵������ʹ����������˼�룬����Զ����࣬����Ӱ�Ӹ����X����
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
		System.out.println("�һ᣺");
		this.cg();
		this.dsg();
		this.dy();
	}
	@Override
	public void cg() {
		System.out.println("����");
	}

	@Override
	public void dy() {
		System.out.println("�ݵ�Ӱ");
	}

	@Override
	public void dsg() {
		System.out.println("�ݵ��Ӿ�");
	}
}
