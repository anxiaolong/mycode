package net;
/**
 * ʹ��UDPʵ��ѧ������ʦ����
 */
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UdpChatStudent {
	public static void main(String[] args) throws UnknownHostException, SocketException {
		System.out.println("student�����߳�����");
		UdpChatSend send = new UdpChatSend(8001, InetAddress.getLocalHost(), 9001);
		send.start();
		System.out.println("student�����߳�����");
		UdpChatReceive receive = new UdpChatReceive(8002);
		receive.start();
	}
}
