package gof23;
/**
 * ʵ�ֵ�����
 */
import java.util.ArrayList;
import java.util.List;

public class Iterator_Test {
	private List<Object> list = new ArrayList<Object>();
	
	public void addObject(Object obj) {
		this.list.add(obj);
	}
	
	public void removeObject(Object obj) {
		this.list.remove(obj);
	}
	
	public List<Object> getList() {
		return list;
	}
	
	public void setList(List<Object> list) {
		this.list = list;
	}
	
	//��õ�����
	public Iterator_MyIterator createIterator() {
		return new ConcreteIterator();
	}
	
	//ʹ���ڲ��ڶ������������ֱ��ʹ���ⲿ������
	private class ConcreteIterator implements Iterator_MyIterator{
		private int cursor;//�����α꣬��¼����λ��
		
		@Override
		public void first() {
			cursor = 0;
		}

		@Override
		public void next() {
			if (cursor<list.size()) {
				cursor++;
			}
		}

		@Override
		public boolean hasNext() {
			if (cursor<list.size()) {
				return true;
			}
			return false;
		}

		@Override
		public boolean isFirst() {
			return cursor==0?true:false;
		}

		@Override
		public boolean isLast() {
			return cursor==(list.size()-1)?true:false;
		}

		@Override
		public Object getCurrentObj() {
			return list.get(cursor);
		}
		
	}
}









