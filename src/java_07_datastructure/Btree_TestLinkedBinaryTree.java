package java_07_datastructure;
/**
 * ����ʵ�ֵĶ�����
 * @author Administrator
 *
 */
public class Btree_TestLinkedBinaryTree {
	public static void main(String[] args) {
		//����������
		Btree_Node node5 = new Btree_Node(5, null, null);
		Btree_Node node4 = new Btree_Node(4, null, node5);
		
		Btree_Node node3 = new Btree_Node(3, null, null);
		Btree_Node node7 = new Btree_Node(7, null, null);
		Btree_Node node6 = new Btree_Node(6, null, node7);
		
		Btree_Node node2 = new Btree_Node(2, node3, node6);
		
		Btree_Node node1 = new Btree_Node(1, node4, node2);

		Btree_BinaryTree btree = new Btree_LinkedBinaryTree(node1);
		
		System.out.println(btree.isEmpty());
		
		//����ݹ����
		btree.preOrderTraverse();
		//�����ݹ����
		btree.postOrderTraverse();
		
		//��������ǵݹ飬ʹ��ջ
		btree.inOrderByStack();
		//����α�����ʹ�ö���
		btree.levelOrderByStack();
		
		//�ڶ������в���ĳ��ֵ
		System.out.println(btree.findKey(4));
		
		//�������߶�
		System.out.println(btree.getHeight());
		
		//�������ڵ����
		System.out.println(btree.size());
	}
}
