package chatroom;
/**
 * �����ҿͻ���ʵ��
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class V1Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9001);
		System.out.println("client");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����û�����");
		String name = br.readLine();
		(new Thread(new SendMsg(socket,name))).start();
		(new Thread(new ReceiveMsg(socket))).start();
	}
}


