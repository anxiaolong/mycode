package net;
/**
 * 测试UDP发送对象数据
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class UdpObjectServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("UDP接收端启动");
		//创建接收服务
		DatagramSocket server = new DatagramSocket(9002);
		//准备容器
		byte[] packet = new byte[1024];
		DatagramPacket serverPacket = new DatagramPacket(packet, 0, packet.length);
		//接收数据
		server.receive(serverPacket);
		//反序列化
		ByteArrayInputStream bais = new ByteArrayInputStream(serverPacket.getData());
		ObjectInputStream ois = new ObjectInputStream(bais);
		System.out.println((Date)ois.readObject());
		//关闭资源
		ois.close();
		bais.close();
		server.close();
	}
}
