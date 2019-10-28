package net;
/**
 * 测试UDP发送基本类型数据
 */
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpTypeServer {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP接收端启动");
		//1.创建服务端口
		DatagramSocket server = new DatagramSocket(9002);
		//2.装备容器接收
		byte[] packet = new byte[1024];
		DatagramPacket serverPacket = new DatagramPacket(packet, 0, packet.length, 
				InetAddress.getLocalHost(), 9002);
		//3.接收
		server.receive(serverPacket);
		//4.包装成流进行拆包
		ByteArrayInputStream bis = new ByteArrayInputStream(packet);
		DataInputStream dis = new DataInputStream(bis);
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
		dis.close();
		//5.回收资源
		dis.close();
		bis.close();
		server.close();
	}
}
