package java_10_net;
/**
 * ����UDP����ͨ��
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpServer {
	public static void main(String[] args) throws Exception {
		//1.ʹ��DatagramSocket ָ���˿� �������ܶ�
		System.out.println("server���ն�����");
		DatagramSocket server = new DatagramSocket(9002);
		//2.׼������ ��װ��DatagramPacket����
		byte[] accept = new byte[1024];
		DatagramPacket acceptPacket = new DatagramPacket(accept, 0, accept.length,
				InetAddress.getLocalHost(), 9001);
		//3.���ܰ���receive(DatagramPacket p)
		server.receive(acceptPacket);
		//4.��������byte[] getData() getLength()
		byte[] newAccept = acceptPacket.getData();
		int len = newAccept.length;
		String a = new String(newAccept, 0, len);
		System.out.println(a);
		//5.�ͷ���Դ
		server.close();
	}
}
