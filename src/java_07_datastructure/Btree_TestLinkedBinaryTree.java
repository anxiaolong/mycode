package java_07_datastructure;
/**
 * 测试实现的二叉树
 * @author Administrator
 *
 */
public class Btree_TestLinkedBinaryTree {
	public static void main(String[] args) {
		//创建二叉树
		Btree_Node node5 = new Btree_Node(5, null, null);
		Btree_Node node4 = new Btree_Node(4, null, node5);
		
		Btree_Node node3 = new Btree_Node(3, null, null);
		Btree_Node node7 = new Btree_Node(7, null, null);
		Btree_Node node6 = new Btree_Node(6, null, node7);
		
		Btree_Node node2 = new Btree_Node(2, node3, node6);
		
		Btree_Node node1 = new Btree_Node(1, node4, node2);

		Btree_BinaryTree btree = new Btree_LinkedBinaryTree(node1);
		
		System.out.println(btree.isEmpty());
		
		//先序递归遍历
		btree.preOrderTraverse();
		//后续递归遍历
		btree.postOrderTraverse();
		
		//中序遍历非递归，使用栈
		btree.inOrderByStack();
		//按层次遍历，使用队列
		btree.levelOrderByStack();
		
		//在二叉树中查找某个值
		System.out.println(btree.findKey(4));
		
		//二叉树高度
		System.out.println(btree.getHeight());
		
		//二叉树节点个数
		System.out.println(btree.size());
	}
}
