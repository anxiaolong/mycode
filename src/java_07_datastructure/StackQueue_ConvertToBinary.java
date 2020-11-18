package java_07_datastructure;
/**
 * ʮ����ת�����ƣ�ʹ��ջ���д洢���
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class StackQueue_ConvertToBinary {
	public static void main(String[] args) {
		System.out.println("����ʮ��������");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		Deque stack = new LinkedList();
		
		while (n>0) {
			int last = n%2;
			stack.push(last);
			n/=2;
		}
		
		while (!stack.isEmpty()) {
			System.out.print(stack.pop());
		}
	}
}
