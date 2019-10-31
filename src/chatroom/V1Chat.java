package chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//1.当前实现一个用户无限制收发自己的消息

public class V1Chat {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("server启动：");
		Socket socket = serverSocket.accept();
		System.out.println("一个连接进来");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		boolean isRunning = true;
		while (isRunning) {
			//接收client发送的消息
			String msg = dis.readUTF();
			//client发送的消息发回去
			dos.writeUTF(msg);
			dos.flush();
		}
		serverSocket.close();
	}
}


