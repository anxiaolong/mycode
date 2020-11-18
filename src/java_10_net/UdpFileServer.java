package java_10_net;
/**
 * ����UDP�����ļ�
 */
import java.io.File;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import org.apache.commons.io.FileUtils;

public class UdpFileServer {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP���ն�����");
		//1.�½�DatagramSocket���󣬲����ö˿�
		DatagramSocket server = new DatagramSocket(9002);
		//2.׼�����յ��ֽ����飬����װ��DatagramPacket
		byte[] packet = new byte[1024*60];
		DatagramPacket serverPacket = new DatagramPacket(packet, 0, packet.length, InetAddress.getLocalHost(), 9002);
		//3.�������ݲ�����
		server.receive(serverPacket);
		FileUtils.writeByteArrayToFile(new File("D:\\eclipse-workspace\\mycode\\src\\net\\ServerReceive.jpg"), packet);
		//4.�ͷ���Դ
		server.close();
	}
}
