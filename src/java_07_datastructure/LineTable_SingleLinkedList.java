package java_07_datastructure;
/**
 * ʵ��һ��������
 * @author Administrator
 *
 */
public class LineTable_SingleLinkedList implements LineTable_List {
	//ͷ�ڵ㣬�����κ�����
	private LineTable_Node head = new LineTable_Node();
	//�ڵ����
	private int size;
	
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int i) {
		//��ͷ�ڵ㿪ʼ��
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
		//�ж�iԽ�������
		if (i<0||i>size) {
			throw new LineTable_MyArrayIndexOutOfBoundsException("����ָ��Խ��");
		}
		//�ҵ�i��ǰһ���ڵ�
		LineTable_Node p = head;
		for (int j = 0; j <i; j++) {
			p = p.next;
		}
		//�½�һ���ڵ㣬����e
		LineTable_Node newNode = new LineTable_Node();
		newNode.data =e;
		//�����½ڵ��ǰ���ͺ��
		newNode.next = p.next;//���
		p.next = newNode;//ǰ��
		//add����֮��size++
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
		//���������ڵ㲢ȡֵ
		for (int i = 0; i < size; i++) {
			if (i!=size-1) {
				builder.append(p.data+",");
			}else {
				builder.append(p.data);
			}
			//�ƶ��ڵ�
			p=p.next;
		}
		builder.append("]");
		return builder.toString();
	}
}
