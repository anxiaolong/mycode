package httpserver;
/**
 * ��װ��Ӧresponse
 * ��װ����request
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
			
			//��ȡ����Э��
			D3Request request = new D3Request(socket);
			request.parseRequestInfo();
			request.coverMap();
			//��Ӧ��Ϣ
			D3Response response = new D3Response(socket);
			response.print("<html>");
			response.print("<head>");
			response.print("<title>");
			response.print("����server���صĽ����");
			response.print("</title>");
			response.print("</head>");
			response.print("<body>");
			response.print("��Ӧ�ɹ���");
			response.print("</body>");
			response.print("</html>");
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
