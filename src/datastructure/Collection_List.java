package datastructure;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.Vector;

public class Collection_List {
	public static void main(String[] args) {
		//ArrayListʹ������ʵ�ֵ��������̲߳���ȫ����ѯЧ�ʸߣ���ɾЧ�ʵ�
		List<String> list1 = new ArrayList<String>();
		list1.add("1");
		list1.add("3");
		list1.add("1");
		for (String string : list1) {
			System.out.println(string);
		}
		
		//LinkedListʹ������ʵ�֣���ѯЧ�ʵͣ���ɾЧ�ʸߣ��̲߳���ȫ
		//��ΪLinkedListʵ����Deque�ӿڣ�������ջ����
		List<String> list2 = new LinkedList<String>();
		list2.add("1");
		list2.add("3");
		list2.add("2");
		for (String string : list2) {
			System.out.println(string);
		}
		Deque<String> stack2 = new LinkedList<String>();
		stack2.push("dfdf");
		stack2.push("34");
		stack2.push("777");
		System.out.println(stack2.peek());
		System.out.println(stack2.pop());
		for (String string : stack2) {
			System.out.println(string);
		}
		
		//Vector�̰߳�ȫ��Ч�ʵͣ�����ʵ��
		List<String> list3 = new Vector<String>();
		list3.add("1");
		list3.add("1");
		list3.add("1");
		for (String string : list3) {
			System.out.println(string);
		}
		
		//Stack��Vector�����࣬�̰߳�ȫ����Vector�Ļ���������ջ����
		List<String> list4 = new Stack<String>();
		list4.add("erer");
		list4.add("34");
		list4.add("tefef");
		for (String string : list4) {
			System.out.println(string);
		}
		
		Stack<String> stack = new Stack<String>();
		stack.push("dfdfd");
		stack.push("4545");
		stack.push("hhhhh");
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.peek());
		System.out.println(stack.isEmpty());
		System.out.println();
		for (String string : stack) {
			System.out.println(string);
		}
		
		//����
		Queue<String> queue1 = new PriorityQueue<String>();
		queue1.add("dfdf");
		queue1.add("3434tet");
		queue1.add("8989fdfdf");
	}
}
