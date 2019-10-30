package chatroom;
/**
 * 封装接收消息方法，并实现多线程
 */
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ReceiveMsg implements Runnable {
	private Socket socket;
	
	public ReceiveMsg(Socket socket) {
		this.socket = socket;
	}
	
	public void receive() throws IOException {
		DataInputStream dis = new DataInputStream(socket.getInputStream());
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
		finally {
			try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
