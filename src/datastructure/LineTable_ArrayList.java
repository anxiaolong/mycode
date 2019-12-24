package datastructure;
/**
 * 手动实现一个arraylist
 */
import java.util.Arrays;

public class LineTable_ArrayList implements LineTable_List {
	private Object[] elementData;
	private int size;
	
	public LineTable_ArrayList(int initialCapacity) {
		//给数组分配指定数量空间
		elementData = new Object[initialCapacity];
	}
	
	public LineTable_ArrayList() {
		//默认给4个大小空间的数组
		this(4);
	}
	
	//数组扩容的方法
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
			throw new LineTable_MyArrayIndexOutOfBoundsException("数组索引越界："+i);
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
		//判断i的位置
		if (i<0||i>size) {
			throw new LineTable_MyArrayIndexOutOfBoundsException("数组下标越界"+i);
		}
		//数组满了就扩容
		if (size==elementData.length) {
			grow();
		}
		//后移i及其后面的元素，从最后一个元素开始
		for (int j=size; j>i; j--) {
			elementData[j] = elementData[j-1];
		}
		//给第i个位置赋值
		elementData[i]=e;
		//元素个数加1
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
