package datastructure;
/**
 * �ֹ�ʵ�ֶ�����
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Btree_LinkedBinaryTree implements Btree_BinaryTree {
	private Btree_Node root;//���ڵ�
	
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
		System.out.println("�������ڵ������");
		return this.size(root);
	}
	
	private int  size(Btree_Node root) {
		if (root==null) {
			return 0;
		}else {
			//��ȡ��������size
			int nl = this.size(root.leftChild);
			//��ȡ��������size
			int nr = this.size(root.rightChild);
			return nl+nr+1;
		}
	}

	@Override
	public int getHeight() {
		System.out.println("�������ĸ߶ȣ�");
		return this.getHeight(root);
	}
	
	private int getHeight(Btree_Node root) {
		if (root==null) {
			return 0;
		}else {
			//��ȡ�������ĸ߶�
			int nl = this.getHeight(root.leftChild);
			//��ȡ�������ĸ߶�
			int nr = this.getHeight(root.rightChild);
			return nl>nr?nl+1:nr+1 ;
		}
	}

	@Override
	public Btree_Node findKey(int value) {
		return this.findKey(value, root);
	}
	
	public Btree_Node findKey(Object value,Btree_Node root) {
		if (root==null) {//�ݹ��������1�����Ϊ�գ��������������ĸ��ڵ㣬Ҳ�����ǵݹ������Ҷ�ӽڵ������Ӻ��Һ���
			return null;
		}else if (root!=null&&root.value==value) {//�ݹ�Ľ�������2���ҵ���
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
			//������ڵ��ֵ
			System.out.print(root.value+" ");
			//����������������ױ���
			//����һ������������������Ҷ�ĸ�
			Btree_BinaryTree leftTree = new Btree_LinkedBinaryTree(root.leftChild);
			leftTree.preOrderTraverse();
			//����������������ױ���
			//����һ������������������Ҷ�ĸ�
			Btree_BinaryTree rightTree = new Btree_LinkedBinaryTree(root.rightChild);
			rightTree.preOrderTraverse();
		}
	}

	@Override
	public void inOrderTraverse() {
		System.out.println("�������");
		this.inOrderTraverse(root);
		System.out.println();
	}
	
	public void inOrderTraverse(Btree_Node root) {
		if (root!=null) {
			//����������
			this.inOrderTraverse(root.leftChild);
			//�������ֵ
			System.out.print(root.value+" ");
			//����������
			this.inOrderTraverse(root.rightChild);
		}
	}

	@Override
	public void postOrderTraverse() {
		System.out.println("�������");
		this.postOrderTraverse(root);
		System.out.println();
	}

	@Override
	public void postOrderTraverse(Btree_Node node) {
		if (node!=null) {
			//����������
			this.postOrderTraverse(node.leftChild);
			//����������
			this.postOrderTraverse(node.rightChild);
			System.out.print(node.value+" ");
		}
	}

	@Override
	public void inOrderByStack() {
		System.out.println("����ǵݹ����");
		//����ջ
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
		System.out.println("���ղ�α���������");
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
