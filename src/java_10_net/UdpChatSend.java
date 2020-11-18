package java_10_net;
/**
 * 使用UDP实现学生和老师对聊
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UdpChatSend extends Thread  {
	private InetAddress toip;
	private int toipPort;
	private DatagramSocket sendSocket;
	
	public UdpChatSend(int port,InetAddress toip,int toipPort) throws SocketException {
		this.toip = toip;
		this.toipPort = toipPort;
		this.sendSocket = new DatagramSocket(port);
	}
	
	@Override
	public void run() {
		try {
			while (true) {
				BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				String s = br.readLine();
				if (s.equals("end")) {
					break;
				}
				byte[] packet = s.getBytes();
				DatagramPacket senPacket = new DatagramPacket(packet, 0, packet.length, toip, toipPort);
				sendSocket.send(senPacket);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			sendSocket.close();
		}
	}
}
