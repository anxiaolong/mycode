package chatroom;
/**
 * 实现双方自由对聊，使用多线程分离发送消息和接收消息
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class V1Chat {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("server启动：");
		Socket socket = serverSocket.accept();
		(new Thread(new SendMsg(socket))).start();
		(new Thread(new ReceiveMsg(socket))).start();
		serverSocket.close();
	}
}
