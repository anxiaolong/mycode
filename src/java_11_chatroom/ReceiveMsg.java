package java_11_chatroom;
/**
 * ��װ������Ϣ��������ʵ�ֶ��߳�
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveMsg implements Runnable {
	DataInputStream dis;
	public ReceiveMsg(Socket socket) throws IOException {
		this.dis = new DataInputStream(socket.getInputStream());
	}
	
	public void receive() throws IOException {
		boolean isRunning = true;
		while (isRunning) {
			System.out.println(dis.readUTF());
		}
	}
	
	@Override
	public void run() {
		try {
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
