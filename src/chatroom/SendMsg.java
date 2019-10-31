package chatroom;
/**
 * 发送消息封装，并实现多线程
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class SendMsg implements Runnable {
	private Socket socket;
	
	public SendMsg(Socket socket) {
		this.socket = socket;
	}
	
	public void send() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
		boolean isRunning = true;
		while (isRunning) {
			String msg = br.readLine();
			dos.writeUTF(msg);
			dos.flush();
		}
	}
	
	@Override
	public void run() {
		try {
			send();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
