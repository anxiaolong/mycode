package net;
/**
 * 测试聊天室
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestChatServer {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket s1 = null;
		BufferedReader in = null;
		
		//把mian作为读取输入流中的内容的方法
		System.out.println("server console:");
		try {
			serverSocket = new ServerSocket(9001);
			s1 = serverSocket.accept();
			//启动新线程，无限向外输出内容
			ServerOut so = new ServerOut(s1);
			so.start();
			in = new BufferedReader(new InputStreamReader(s1.getInputStream()));
			while (true) {//无限读取输入流内容
				String str = in.readLine();
				System.out.println("Client:"+str);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ServerOut extends Thread {
	Socket s;
	BufferedReader br;
	BufferedWriter out;
	
	public ServerOut(Socket s) {
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

