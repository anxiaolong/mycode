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

public class UdpFileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP接收端启动");
		//1.新建DatagramSocket对象，并设置端口
		DatagramSocket server = new DatagramSocket(9002);
		//2.准备接收的字节数组，并包装成DatagramPacket
		byte[] packet = new byte[1024*60];
		DatagramPacket serverPacket = new DatagramPacket(packet, 0, packet.length, InetAddress.getLocalHost(), 9002);
		//3.接收数据并处理
		server.receive(serverPacket);
		FileUtils.writeByteArrayToFile(new File("D:\\eclipse-workspace\\mycode\\src\\net\\ServerReceive.jpg"), packet);
		//4.释放资源
		server.close();
	}
}
