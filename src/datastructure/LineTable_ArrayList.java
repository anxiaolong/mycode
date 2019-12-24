package datastructure;
/**
 * �ֶ�ʵ��һ��arraylist
 */
import java.util.Arrays;

public class LineTable_ArrayList implements LineTable_List {
	private Object[] elementData;
	private int size;
	
	public LineTable_ArrayList(int initialCapacity) {
		//���������ָ�������ռ�
		elementData = new Object[initialCapacity];
	}
	
	public LineTable_ArrayList() {
		//Ĭ�ϸ�4����С�ռ������
		this(4);
	}
	
	//�������ݵķ���
	public void grow() {
		elementData = Arrays.copyOf(elementData, elementData.length*2);
	}
	
	@Override
	public int size() {
		return size;
	}

	@Override
	public Object get(int i) {
		if (i<0||i>size) {
			throw new LineTable_MyArrayIndexOutOfBoundsException("��������Խ�磺"+i);
		}
		return elementData[i];
	}

	@Override
	public boolean isEmpty() {
		return size==0;
	}

	@Override
	public boolean contains(Object e) {
		return false;
	}

	@Override
	public int indexOf(Object e) {
		return 0;
	}

	@Override
	public void add(int i, Object e) {
		//�ж�i��λ��
		if (i<0||i>size) {
			throw new LineTable_MyArrayIndexOutOfBoundsException("�����±�Խ��"+i);
		}
		//�������˾�����
		if (size==elementData.length) {
			grow();
		}
		//����i��������Ԫ�أ������һ��Ԫ�ؿ�ʼ
		for (int j=size; j>i; j--) {
			elementData[j] = elementData[j-1];
		}
		//����i��λ�ø�ֵ
		elementData[i]=e;
		//Ԫ�ظ�����1
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
		for (int i = 0; i < elementData.length; i++) {
			if (i!=size-1) {
				if (elementData[i]!=null) {
					builder.append(elementData[i]+",");
				}
			}else {
				builder.append(elementData[i]);
			}
		}
		builder.append("]");
		return builder.toString();
	}
	
}
