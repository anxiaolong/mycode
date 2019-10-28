package net;
/**
 * 使用UDP实现学生和老师对聊
 */
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpChatStudent {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		System.out.println("student发送线程启动");
		UdpChatSend send = new UdpChatSend(8001, InetAddress.getLocalHost(), 9001);
		send.start();
		System.out.println("student接收线程启动");
		UdpChatReceive receive = new UdpChatReceive(8002);
		receive.start();
	}
}
