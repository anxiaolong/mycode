package java_10_net;
/**
 * ����UDP���Ͷ�������
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
		System.out.println("UDP���Ͷ�����");
		//����DatagramSocket���� ���÷���˿�
		DatagramSocket client = new DatagramSocket(9001);
		//׼������
		Date object = new Date();
		System.out.println("�������ݣ�"+object);
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(baos);
		oos.writeObject(object);
		oos.flush();
		byte[] packet = baos.toByteArray();
		//�����ݴ����д�ϵ�ַ������
		DatagramPacket clientPacket = new DatagramPacket(packet, 0, packet.length, 
				InetAddress.getLocalHost(), 9002);
		client.send(clientPacket);
		//��Դ����
		oos.close();
		baos.close();
		client.close();
	}
}