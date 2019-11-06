package httpserver;
/**
 * ��װ��Ӧresponse
 */
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class D3Server02 {
private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		D3Server02 server = new D3Server02();
		server.start();
	}
	
	public void start() {
		//�½�һ��ServerSocket����
		try {
			serverSocket = new ServerSocket(9001);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("����ʧ��");
		}
	}
	
	public void receive() {
		try {
			Socket socket = serverSocket.accept();
			System.out.println("һ�����ӽ���");
			
			//��ȡ����Э��
			InputStream is = socket.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
			
			//��Ӧ��Ϣ
			D3Response response = new D3Response(socket);
			response.print("����server���صĽ��");
			response.pushToBrowser(200);
			System.out.println(response.headInfo);
			System.out.println(response.content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ����쳣");
		}
	}
	
	public void stop() {
		
	}
}
