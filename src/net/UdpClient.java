package net;
/**
 * ����UDP����ͨ��
 */
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpClient {
	public static void main(String[] args) throws IOException {
		//1.ʹ��DatagramSocket ָ���˿� �������Ͷ�
		System.out.println("client���Ͷ�����");
		DatagramSocket client = new DatagramSocket(9001);
		//2.׼�����͵����ݣ���ת���ֽ�����
		String name = "anxiaolong";
		byte[] data = name.getBytes();
		//3.��װ��DatagramPacket��������ָ��Ŀ�ĵ�
		DatagramPacket packet = new DatagramPacket(data, 0, data.length, 
				InetAddress.getLocalHost(), 9002);
		//4.���Ͱ���send(DatagramPacket p)
		client.send(packet);
		//5.�ͷ���Դ
		client.close();
	}
}
