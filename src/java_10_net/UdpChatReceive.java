package java_10_net;
/**
 * 使用UDP实现学生和老师对聊
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UdpChatReceive extends Thread {
	private DatagramSocket receiveSocket;
	
	public UdpChatReceive(int port) throws SocketException {
		receiveSocket = new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				byte[] packet = new byte[1024];
				DatagramPacket receivePacket = new DatagramPacket(packet, packet.length);
				receiveSocket.receive(receivePacket);
				byte[] packet1 = receivePacket.getData();
				String s = new String(packet1);
				System.out.println(s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		receiveSocket.close();
	}
}
