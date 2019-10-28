package net;
/**
 * 测试UDP发送基本类型数据
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpTypeClient {
	public static void main(String[] args) throws IOException {
		//1.新建DatagramSockt对象，并设置发送端口
		System.out.println("UDP发送端启动");
		DatagramSocket client = new DatagramSocket(9001);
		//2.发送基本类型数据，包装成流写入基本类型，再转为字节数组，再打包写上地址
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//新建字节数组输入流
		DataOutputStream dos = new DataOutputStream(baos);//包装成数据输出流
		//输出流写入基本数据类型
		dos.writeInt(27);
		dos.writeBoolean(true);
		dos.writeChar('r');
		dos.writeUTF("anxiaolong");
		byte[] packet = baos.toByteArray();//写入流中的数据包装成字节数组
		DatagramPacket clientPacket = new DatagramPacket(packet, 0,packet.length, InetAddress.getLocalHost(), 9002);
		//3.发送数据
		client.send(clientPacket);
		//4.回收资源
		dos.close();
		baos.close();
		client.close();
	}
}
