package datastructure;
/**
 * 手工实现二叉树
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Btree_LinkedBinaryTree implements Btree_BinaryTree {
	private Btree_Node root;//根节点
	
	public Btree_LinkedBinaryTree() {
		// TODO Auto-generated constructor stub
	}
	
	public Btree_LinkedBinaryTree(Btree_Node root) {
		this.root = root;
	}
	
	@Override
	public boolean isEmpty() {
		return root==null;
	}

	@Override
	public int size() {
		System.out.println("二叉树节点个数：");
		return this.size(root);
	}
	
	private int  size(Btree_Node root) {
		if (root==null) {
			return 0;
		}else {
			//获取左子树的size
			int nl = this.size(root.leftChild);
			//获取右子树的size
			int nr = this.size(root.rightChild);
			return nl+nr+1;
		}
	}

	@Override
	public int getHeight() {
		System.out.println("二叉树的高度：");
		return this.getHeight(root);
	}
	
	private int getHeight(Btree_Node root) {
		if (root==null) {
			return 0;
		}else {
			//获取左子树的高度
			int nl = this.getHeight(root.leftChild);
			//获取右子树的高度
			int nr = this.getHeight(root.rightChild);
			return nl>nr?nl+1:nr+1 ;
		}
	}

	@Override
	public Btree_Node findKey(int value) {
		return this.findKey(value, root);
	}
	
	public Btree_Node findKey(Object value,Btree_Node root) {
		if (root==null) {//递归结束条件1：结点为空，可能是整个树的根节点，也可能是递归调用中叶子节点中左孩子和右孩子
			return null;
		}else if (root!=null&&root.value==value) {//递归的结束条件2：找到了
			return root;
		} else {
			Btree_Node node1 = this.findKey(value, root.leftChild);
			Btree_Node node2 = this.findKey(value, root.rightChild);
			if (node1!=null&&node1.value==value) {
				return node1;
			}else if (node2!=null&&node2.value==value) {
				return node2;
			}else {
				return null;
			}
		}
	}

	@Override
	public void preOrderTraverse() {
		if (root!=null) {
			//输出根节点的值
			System.out.print(root.value+" ");
			//对左子树进行先序白遍历
			//构建一个二叉树，根是左子叶的根
			Btree_BinaryTree leftTree = new Btree_LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			//对右子树进行先序白遍历
			//构建一个二叉树，根是右子叶的根
			Btree_BinaryTree rightTree = new Btree_LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}
	}

	@Override
	public void inOrderTraverse() {
		System.out.println("中序遍历");
		this.inOrderTraverse(root);
		System.out.println();
	}
	
	public void inOrderTraverse(Btree_Node root) {
		if (root!=null) {
			//遍历左子树
			this.inOrderTraverse(root.leftChild);
			//输出根的值
			System.out.print(root.value+" ");
			//遍历右子树
			this.inOrderTraverse(root.rightChild);
		}
	}

	@Override
	public void postOrderTraverse() {
		System.out.println("后序遍历");
		this.postOrderTraverse(root);
		System.out.println();
	}

	@Override
	public void postOrderTraverse(Btree_Node node) {
		if (node!=null) {
			//遍历左子树
			this.postOrderTraverse(node.leftChild);
			//遍历右子树
			this.postOrderTraverse(node.rightChild);
			System.out.print(node.value+" ");
		}
	}

	@Override
	public void inOrderByStack() {
		System.out.println("中序非递归遍历");
		//创建栈
		Deque<Btree_Node> stack = new LinkedList<Btree_Node>();
		Btree_Node current = root;
		while (current!=null||!stack.isEmpty()) {
			while (current!=null) {
				stack.push(current);
				current = current.leftChild;
			}
			
			if (!stack.isEmpty()) {
				current = stack.pop();
				System.out.print(current.value+" ");
				current = current.rightChild;
			}
		}
		System.out.println();
	}

	@Override
	public void preOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postOrderByStack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void levelOrderByStack() {
		System.out.println("按照层次遍历二叉树");
		if (root==null) { return;}
		Queue<Btree_Node> queue = new LinkedList<Btree_Node>();
		queue.add(root);
		while (queue.size()!=0) {
			int len = queue.size();
			for (int i = 0; i < len; i++) {
				Btree_Node temp = queue.poll();
				System.out.print(temp.value+" ");
				if (temp.leftChild!=null) {
					queue.add(temp.leftChild);
				}
				if (temp.rightChild!=null) {
					queue.add(temp.rightChild);
				}
			}
		}
		System.out.println();
	}

}
