package chatroom;
/**
 * ʵ��˫�����ɶ��ģ�ʹ�ö��̷߳��뷢����Ϣ�ͽ�����Ϣ
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class V1Chat {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("server������");
		Socket socket = serverSocket.accept();
		(new Thread(new SendMsg(socket))).start();
		(new Thread(new ReceiveMsg(socket))).start();
		serverSocket.close();
	}
}
