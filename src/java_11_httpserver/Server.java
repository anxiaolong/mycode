package java_11_httpserver;
/**
 * 引入servlet
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;


public class Server {
private ServerSocket serverSocket;
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		WebXml.parserXml();//先解析好xml
		Server server = new Server();
		server.start();
	}
	
	public void start() {
		//新建一个ServerSocket对象
		try {
			serverSocket = new ServerSocket(9001);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("启动失败");
		}
	}
	
	public void receive() {
		try {
			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("一个连接进来");
				//创建调度器对象，实现多线程
				Dispatcher dispatcher = new Dispatcher(socket);
				new Thread(dispatcher).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端异常");
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
