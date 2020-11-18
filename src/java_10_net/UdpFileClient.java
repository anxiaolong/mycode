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

public class UdpFileClient {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP���Ͷ�����");
		//1.����DatagramSocket���󣬲����÷��Ͷ˿�
		DatagramSocket client = new DatagramSocket(9001);
		//2.����Ҫ���͵��ļ���װ���ֽ����飬�����д�ϵ�ַ
		byte[] packet = FileUtils.readFileToByteArray(
				new File("D:\\eclipse-workspace\\mycode\\src\\net\\ClientSend.jpg"));
		DatagramPacket clientPacket = new DatagramPacket(packet, 0, packet.length, InetAddress.getLocalHost(), 9002);
		//3.ʹ��DatagramSocket����client,���Ͱ�
		client.send(clientPacket);
		//4.������Դ
		client.close();
	}
}
