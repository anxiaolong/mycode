package java_07_datastructure;
/**
 * 实现一个单链表
 * @author Administrator
 *
 */
public class LineTable_SingleLinkedList implements LineTable_List {
	//头节点，不存任何数据
	private LineTable_Node head = new LineTable_Node();
	//节点个数
	private int size;
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int i) {
		//从头节点开始找
		LineTable_Node p = head;
		for (int j = 0; j <=i; j++) {
			p = p.next;
		}
		return p.data;
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int indexOf(Object e) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void add(int i, Object e) {
		//判断i越界的问题
		if (i<0||i>size) {
			throw new LineTable_MyArrayIndexOutOfBoundsException("数组指针越界");
		}
		//找到i的前一个节点
		LineTable_Node p = head;
		for (int j = 0; j <i; j++) {
			p = p.next;
		}
		//新建一个节点，存入e
		LineTable_Node newNode = new LineTable_Node();
		newNode.data =e;
		//设置新节点的前驱和后继
		newNode.next = p.next;//后继
		p.next = newNode;//前驱
		//add完了之后size++
		size++;
	}

	@Override
	public void add(Object e) {
		this.add(size, e);
	}

	@Override
	public void addBefore(Object obj, Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addAfter(Object obj, Object e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object remove(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object replace(int i, Object e) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String toString() {
		if (size==0) {
			return "[]";
		}
		StringBuilder builder = new StringBuilder("[");
		LineTable_Node p = head.next;
		//遍历各个节点并取值
		for (int i = 0; i < size; i++) {
			if (i!=size-1) {
				builder.append(p.data+",");
			}else {
				builder.append(p.data);
			}
			//移动节点
			p=p.next;
		}
		builder.append("]");
		return builder.toString();
	}
}
