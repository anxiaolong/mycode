package java_10_net;
/**
 * 测试UDP发送文件
 */
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import org.apache.commons.io.FileUtils;

public class UdpFileClient {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP发送端启动");
		//1.创建DatagramSocket对象，并设置发送端口
		DatagramSocket client = new DatagramSocket(9001);
		//2.将需要发送的文件包装成字节数组，并打包写上地址
		byte[] packet = FileUtils.readFileToByteArray(
				new File("D:\\eclipse-workspace\\mycode\\src\\net\\ClientSend.jpg"));
		DatagramPacket clientPacket = new DatagramPacket(packet, 0, packet.length, InetAddress.getLocalHost(), 9002);
		//3.使用DatagramSocket对象client,发送包
		client.send(clientPacket);
		//4.回收资源
		client.close();
	}
}
