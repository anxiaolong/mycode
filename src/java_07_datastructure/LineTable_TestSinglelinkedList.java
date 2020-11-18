package java_07_datastructure;
/**
 * 测试手工实现的单链表
 * @author Administrator
 *
 */
public class LineTable_TestSinglelinkedList {
	public static void main(String[] args) {
		LineTable_List list = new LineTable_SingleLinkedList();
		
		list.add(3434);
		list.add(666);
		list.add(67676);
		list.add(23232);
		list.add(9009);
		list.add(8998);
		
		System.out.println(list.size());
		System.out.println(list.isEmpty());
		System.out.println(list.get(3));
		System.out.println(list.toString());
	}
}
