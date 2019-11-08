package httpserver;
/**
 * ����servlet
 */
import java.io.IOException;
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
			
			//��ȡ����
			D3Request request = new D3Request(socket);
			
			//ͨ�������������servlet
			D3Servlet servlet = null;
			if (request.getUrl().equals("/login")) {
				servlet = new D3LoginServlet();
			} else if (request.getUrl().equals("/reg")) {
				servlet = new D3RegisterServlet();
			}
			//������Ӧ����
			D3Response response = new D3Response(socket);
			//��servlet�����������Ӧ����
			servlet.service(request, response);
			//��ע״̬��
			response.pushToBrowser(200);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ����쳣");
		}
	}
	
	public void stop() {
		
	}
}
