package net;
/**
 * ����UDP���ͻ�����������
 */
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpTypeServer {
	public static void main(String[] args) throws IOException {
		System.out.println("UDP���ն�����");
		//1.��������˿�
		DatagramSocket server = new DatagramSocket(9002);
		//2.װ����������
		byte[] packet = new byte[1024];
		DatagramPacket serverPacket = new DatagramPacket(packet, 0, packet.length, 
				InetAddress.getLocalHost(), 9002);
		//3.����
		server.receive(serverPacket);
		//4.��װ�������в��
		ByteArrayInputStream bis = new ByteArrayInputStream(packet);
		DataInputStream dis = new DataInputStream(bis);
		System.out.println(dis.readInt());
		System.out.println(dis.readBoolean());
		System.out.println(dis.readChar());
		System.out.println(dis.readUTF());
		dis.close();
		//5.������Դ
		dis.close();
		bis.close();
		server.close();
	}
}
