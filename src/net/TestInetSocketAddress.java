package net;
/**
 * ���԰���ip�Ͷ˿ڵ�InetSockAddress����
 */
import java.net.InetSocketAddress;

public class TestInetSocketAddress {
	public static void main(String[] args) {
		InetSocketAddress socketAddress = new InetSocketAddress("127.0.0.1", 8080);
		InetSocketAddress socketAddress2 = new InetSocketAddress("localhost", 9000);
		System.out.println(socketAddress.getHostName());
		System.out.println(socketAddress2.getAddress());
		System.out.println(socketAddress);
		System.out.println(socketAddress2);
	}
}