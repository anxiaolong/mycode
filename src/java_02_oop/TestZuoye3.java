package java_02_oop;
/**
 * ��д����ʵ�����ֵ�������
 * ���ֿ��Ե��಻ͬ�������Ӷ�������ͬ������
 * ���Ե���������������������ٺ�����
 * @author Administrator
 *
 */
public class TestZuoye3 {
	public static void main(String[] args) {
		//�������ָ�����࣬��̬
		Instrument erhu = new Erhu();
		Instrument piano = new Piano();
		Instrument viol = new Violin();
		Musician m1 = new Musician();
		m1.play(erhu);
		m1.play(viol);
		m1.play(piano);
	}
}

abstract class Instrument {
	abstract void makeSounds();
}

class Erhu extends Instrument {
	@Override
	void makeSounds() {
		System.out.println("��������������");
	}
}

class Piano extends Instrument {
	@Override
	void makeSounds() {
		System.out.println("����������������");
	}
}

class Violin extends Instrument {
	@Override
	void makeSounds() {
		System.out.println("С��������������");
	}
}

class Musician {
	public void play(Instrument i) {
		i.makeSounds();
	}
}