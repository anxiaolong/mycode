package gof23;
/**
 * 实现迭代器
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
	
	//获得迭代器
	public Iterator_MyIterator createIterator() {
		return new ConcreteIterator();
	}
	
	//使用内部内定义迭代器，可直接使用外部类属性
	private class ConcreteIterator implements Iterator_MyIterator{
		private int cursor;//定义游标，记录遍历位置
		
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









