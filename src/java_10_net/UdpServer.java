package java_10_net;
/**
 * 测试UDP单项通信
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
	public static void main(String[] args) throws Exception {
		//1.使用DatagramSocket 指定端口 创建接受端
		System.out.println("server接收端启动");
		DatagramSocket server = new DatagramSocket(9002);
		//2.准备容器 封装成DatagramPacket包裹
		byte[] accept = new byte[1024];
		DatagramPacket acceptPacket = new DatagramPacket(accept, 0, accept.length,
				InetAddress.getLocalHost(), 9001);
		//3.接受包裹receive(DatagramPacket p)
		server.receive(acceptPacket);
		//4.分析数据byte[] getData() getLength()
		byte[] newAccept = acceptPacket.getData();
		int len = newAccept.length;
		String a = new String(newAccept, 0, len);
		System.out.println(a);
		//5.释放资源
		server.close();
	}
}
