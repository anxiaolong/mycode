package java_13_gof23;

public interface Composite_Component {
	void operation();
}

//Ҷ�����
interface Leaf extends Composite_Component {
	
}

//�������
interface Composite extends Composite_Component {
	void add(Composite_Component c);
	void remove(Composite_Component c);
	Composite_Component getChild(int index);
}
