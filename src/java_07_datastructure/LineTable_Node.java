package java_07_datastructure;
/**
 * ������Ľڵ�
 * @author Administrator
 *
 */
public class LineTable_Node {
	Object data;//Ҫ�洢������
	LineTable_Node next;//��һ���ڵ�
	
	public LineTable_Node() {
		// TODO Auto-generated constructor stub
	}
	
	public LineTable_Node(Object data) {
		this.data = data;
	}
	
	public LineTable_Node(Object data,LineTable_Node next) {
		this.data = data;
		this.next = next;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public LineTable_Node getNext() {
		return next;
	}

	public void setNext(LineTable_Node next) {
		this.next = next;
	}
	
}
