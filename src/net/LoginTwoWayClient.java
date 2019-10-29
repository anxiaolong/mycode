package net;
/**
 * ����TCP˫��ͨ��
 * ��ȡ����ʹ��readLine()������д�����������ؼ���\n
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LoginTwoWayClient {
	public static void main(String[] args) throws IOException {
		System.out.println("client����");
		//1.�Ӽ��̻�ȡ�û���������
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����û�����");
		String name = br.readLine();
		System.out.println("�������룺");
		String pwd = br.readLine();
//		System.out.println(name+" "+pwd);
		//2.����socket����ָ��server����װ�����������
		Socket client = new Socket("localhost", 9001);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//д��������ػ��У�����ʹ��readLine()������ȡ���ݻ��޷�����
		bw.write("name="+name+"&"+"pwd="+pwd+"\n");
		bw.flush();
		//3.���շ������ķ�����Ϣ
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		//4.������Դ
		dis.close();
		bw.close();
		br.close();
		client.close();
	}
}
