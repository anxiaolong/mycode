package net;
/**
 * ʹ��UDPʵ��ѧ������ʦ����
 */
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpChatTeacher {
	public static void main(String[] args) throws SocketException, UnknownHostException {
		System.out.println("teacher�����߳�����");
		UdpChatReceive receive = new UdpChatReceive(9001);
		receive.start();
		System.out.println("teacher�����߳�����");
		UdpChatSend send = new UdpChatSend(9002, InetAddress.getLocalHost(), 8002);
		send.start();
	}
}
