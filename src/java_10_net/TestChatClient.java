package java_10_net;
/**
 * 测试聊天室
 * socket一边无限输入，一边无限输出是不会形成死循环
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TestChatClient {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader in = null;
		System.out.println("client console:");
		try {
			socket = new Socket(InetAddress.getLocalHost(), 9001);
			//新建线程，写入内容到输出流中
			ClientOut co = new ClientOut(socket);
			co.start();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {//无限读取输入流中的内容
				String s = in.readLine();
				System.out.println("server:"+s);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ClientOut extends Thread {
	Socket s;
	BufferedReader br;
	BufferedWriter out;
	
	public ClientOut(Socket s) {
		this.s = s;
		br = new BufferedReader(new InputStreamReader(System.in));
		try {
			out = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				String s = br.readLine();
				out.write(s+"\n");
				out.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
