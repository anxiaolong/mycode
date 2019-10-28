package net;
/**
 * ����UDP���Ͷ�������
 */
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Date;

public class UdpObjectServer {
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		System.out.println("UDP���ն�����");
		//�������շ���
		DatagramSocket server = new DatagramSocket(9002);
		//׼������
		byte[] packet = new byte[1024];
		DatagramPacket serverPacket = new DatagramPacket(packet, 0, packet.length);
		//��������
		server.receive(serverPacket);
		//�����л�
		ByteArrayInputStream bais = new ByteArrayInputStream(serverPacket.getData());
		ObjectInputStream ois = new ObjectInputStream(bais);
		System.out.println((Date)ois.readObject());
		//�ر���Դ
		ois.close();
		bais.close();
		server.close();
	}
}
