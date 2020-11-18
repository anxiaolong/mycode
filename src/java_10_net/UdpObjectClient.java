package java_10_net;
/**
 * 测试UDP发送对象数据
 */
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;


public class UdpObjectClient {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP发送端启动");
		//创建DatagramSocket对象 设置服务端口
		DatagramSocket client = new DatagramSocket(9001);
		//准备数据
		Date object = new Date();
		System.out.println("发送数据："+object);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		oos.flush();
		byte[] packet = baos.toByteArray();
		//给数据打包并写上地址，发送
		DatagramPacket clientPacket = new DatagramPacket(packet, 0, packet.length, 
				InetAddress.getLocalHost(), 9002);
		client.send(clientPacket);
		//资源回收
		oos.close();
		baos.close();
		client.close();
	}
}