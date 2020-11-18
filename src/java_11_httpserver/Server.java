package java_11_httpserver;
/**
 * ����servlet
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Server {
private ServerSocket serverSocket;
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		WebXml.parserXml();//�Ƚ�����xml
		Server server = new Server();
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
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("һ�����ӽ���");
				//��������������ʵ�ֶ��߳�
				Dispatcher dispatcher = new Dispatcher(socket);
				new Thread(dispatcher).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ����쳣");
		}
	}
	
	public void stop() {
		try {
			if (serverSocket!=null) {
				serverSocket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
