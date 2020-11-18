package java_10_net;
/**
 * ����TCP˫��ͨ��
 * ��ȡ����ʹ��readLine()������д�����������ؼ���\n
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		System.out.println("server����");
		//1.����ServerSocket���񣬴���socket����
		ServerSocket serverSocket = new ServerSocket(9001);
		Socket server = serverSocket.accept();
		//2.�������������ݲ�����
		BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
		String acceptString = br.readLine();
		String[] namepwd = acceptString.split("&");
		String[] name = namepwd[0].split("=");
		String[] pwd = namepwd[1].split("=");
		//�������ݲ����ؽ��
		DataOutputStream dos = new DataOutputStream(server.getOutputStream());
		if (name[1].equals("anxiaolong")&&pwd[1].equals("123456")) {
			System.out.println("��½�ɹ�");
			dos.writeUTF("��½�ɹ�");
		} else {
			System.out.println("�û������������");
			dos.writeUTF("�û������������");
		}
		dos.flush();
		//4.������Դ
		dos.close();
		br.close();
		serverSocket.close();
	}
}
