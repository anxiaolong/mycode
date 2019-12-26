package datastructure;
/**
 * 二叉树节点
 * @author Administrator
 *
 */
public class Btree_Node {
	Object value;//节点值
	Btree_Node leftChild;//左子树的引用
	Btree_Node rightChild;//右子树的引用
	
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
