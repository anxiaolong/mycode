package chatroom;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//1.��ǰʵ��һ���û��������շ��Լ�����Ϣ

public class V1Chat {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("server������");
		Socket socket = serverSocket.accept();
		System.out.println("һ�����ӽ���");
		DataInputStream dis = new DataInputStream(socket.getInputStream());
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		boolean isRunning = true;
		while (isRunning) {
			//����client���͵���Ϣ
			String msg = dis.readUTF();
			//client���͵���Ϣ����ȥ
			dos.writeUTF(msg);
			dos.flush();
		}
		serverSocket.close();
	}
}


