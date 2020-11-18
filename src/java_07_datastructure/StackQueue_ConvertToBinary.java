package java_07_datastructure;
/**
 * 十进制转二进制，使用栈队列存储结果
 */
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class StackQueue_ConvertToBinary {
	public static void main(String[] args) {
		System.out.println("输入十进制数：");
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
