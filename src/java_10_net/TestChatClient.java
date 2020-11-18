package java_10_net;
/**
 * ����������
 * socketһ���������룬һ����������ǲ����γ���ѭ��
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
			//�½��̣߳�д�����ݵ��������
			ClientOut co = new ClientOut(socket);
			co.start();
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while (true) {//���޶�ȡ�������е�����
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
