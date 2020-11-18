package java_02_oop;
/**
 * 编写程序实现乐手弹奏乐器
 * 乐手可以弹奏不同的乐器从而发出不同的声音
 * 可以弹奏的乐器包括二胡、钢琴和琵琶
 * @author Administrator
 *
 */
public class TestZuoye3 {
	public static void main(String[] args) {
		//父类对象指向子类，多态
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
		System.out.println("二胡声。。。。");
	}
}

class Piano extends Instrument {
	@Override
	void makeSounds() {
		System.out.println("钢琴声。。。。。");
	}
}

class Violin extends Instrument {
	@Override
	void makeSounds() {
		System.out.println("小提琴声。。。。");
	}
}

class Musician {
	public void play(Instrument i) {
		i.makeSounds();
	}
}