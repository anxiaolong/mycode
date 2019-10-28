package net;
/**
 * 使用UDP实现学生和老师对聊
 */
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpChatTeacher {
	public static void main(String[] args) throws SocketException, UnknownHostException {
		System.out.println("teacher接收线程启动");
		UdpChatReceive receive = new UdpChatReceive(9001);
		receive.start();
		System.out.println("teacher发送线程启动");
		UdpChatSend send = new UdpChatSend(9002, InetAddress.getLocalHost(), 8002);
		send.start();
	}
}
