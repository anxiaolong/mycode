package datastructure;
/**
 * �������ڵ�
 * @author Administrator
 *
 */
public class Btree_Node {
	Object value;//�ڵ�ֵ
	Btree_Node leftChild;//������������
	Btree_Node rightChild;//������������
	
	public Btree_Node(Object value) {
		this.value = value;
	}
	
	public Btree_Node(Object value,Btree_Node leftChild,Btree_Node rightChild) {
		this.value = value;
		this.leftChild = leftChild;
		this.rightChild = rightChild;
	}
	
	@Override
	public String toString() {
		return "Node [value="+value+
				",leftChild="+leftChild+
				",rightChild="+rightChild+"]";
	}
}
