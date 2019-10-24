package net;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestInetAddress {
	//通过getLocalHost()方法创建 InetAddress对象
	public static void test1() throws UnknownHostException {
		InetAddress addr1 = InetAddress.getLocalHost();
		System.out.println(addr1.getHostName());
		System.out.println(addr1.getHostAddress());
		System.out.println(InetAddress.getLocalHost());
	}
	//通过域名创建InetAddress对象
	public static void test2() throws UnknownHostException {
		InetAddress addr2 = InetAddress.getByName("music.migu.cn");
		System.out.println(addr2);
		System.out.println(addr2.getHostAddress());
		System.out.println(addr2.getHostName());
	}
	//根据ip创建InetAddress对象
	public static void test3() throws UnknownHostException {
		InetAddress addr3 = InetAddress.getByName("59.110.14.7");
		System.out.println(addr3);
		//这个IP地址不存在或DNS服务器不允许进行IP地址和域名的映射
		System.out.println(addr3.getHostName());
		System.out.println(addr3.getHostAddress());
	}
	public static void main(String[] args) throws UnknownHostException {
		test1();
		test2();
		test3();
	}
}
