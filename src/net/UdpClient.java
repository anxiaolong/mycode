package net;
/**
 * 测试UDP单项通信
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	public static void main(String[] args) throws IOException {
		//1.使用DatagramSocket 指定端口 创建发送端
		System.out.println("client发送端启动");
		DatagramSocket client = new DatagramSocket(9001);
		//2.准备发送的数据，并转成字节数组
		String name = "anxiaolong";
		byte[] data = name.getBytes();
		//3.封装成DatagramPacket包裹，并指定目的地
		DatagramPacket packet = new DatagramPacket(data, 0, data.length, 
				InetAddress.getLocalHost(), 9002);
		//4.发送包裹send(DatagramPacket p)
		client.send(packet);
		//5.释放资源
		client.close();
	}
}
