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
	BufferedReader br;
	DataOutputStream dos;
	boolean isRunning = true;
	
	public SendMsg(Socket socket,String name) throws IOException {
		dos = new DataOutputStream(socket.getOutputStream());
		dos.writeUTF(name);
		dos.flush();
	}
	
	public void send() throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
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
