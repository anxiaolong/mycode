package net;
/**
 * ����UDP���ͻ�����������
 */
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpTypeClient {
	public static void main(String[] args) throws IOException {
		//1.�½�DatagramSockt���󣬲����÷��Ͷ˿�
		System.out.println("UDP���Ͷ�����");
		DatagramSocket client = new DatagramSocket(9001);
		//2.���ͻ����������ݣ���װ����д��������ͣ���תΪ�ֽ����飬�ٴ��д�ϵ�ַ
		ByteArrayOutputStream baos = new ByteArrayOutputStream();//�½��ֽ�����������
		DataOutputStream dos = new DataOutputStream(baos);//��װ�����������
		//�����д�������������
		dos.writeInt(27);
		dos.writeBoolean(true);
		dos.writeChar('r');
		dos.writeUTF("anxiaolong");
		byte[] packet = baos.toByteArray();//д�����е����ݰ�װ���ֽ�����
		DatagramPacket clientPacket = new DatagramPacket(packet, 0,packet.length, InetAddress.getLocalHost(), 9002);
		//3.��������
		client.send(clientPacket);
		//4.������Դ
		dos.close();
		baos.close();
		client.close();
	}
}
