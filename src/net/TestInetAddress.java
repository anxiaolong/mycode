package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	//ͨ��getLocalHost()�������� InetAddress����
	public static void test1() throws UnknownHostException {
		InetAddress addr1 = InetAddress.getLocalHost();
		System.out.println(addr1.getHostName());
		System.out.println(addr1.getHostAddress());
		System.out.println(InetAddress.getLocalHost());
	}
	//ͨ����������InetAddress����
	public static void test2() throws UnknownHostException {
		InetAddress addr2 = InetAddress.getByName("music.migu.cn");
		System.out.println(addr2);
		System.out.println(addr2.getHostAddress());
		System.out.println(addr2.getHostName());
	}
	//����ip����InetAddress����
	public static void test3() throws UnknownHostException {
		InetAddress addr3 = InetAddress.getByName("59.110.14.7");
		System.out.println(addr3);
		//���IP��ַ�����ڻ�DNS���������������IP��ַ��������ӳ��
		System.out.println(addr3.getHostName());
		System.out.println(addr3.getHostAddress());
	}
	public static void main(String[] args) throws UnknownHostException {
		test1();
		test2();
		test3();
	}
}
