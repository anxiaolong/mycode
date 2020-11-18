package java_10_net;
/**
 * tcp：单项通信socket服务器端
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BasicSocketServer {
	public static void main(String[] args) {
		Socket socket = null;
		BufferedWriter bw = null;
		try {
			ServerSocket serverSocket = new ServerSocket(9001);//指定监听端口
			socket = serverSocket.accept();//监听，等待客户端请求，并愿意接收连接
			//获取socket的输出流，并使用缓冲流进行包装
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("来自服务端的消息");//向客户端发送消息
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (bw!=null) {
					bw.close();
//					System.out.println("bw关闭");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (socket!=null) {
					socket.close();
//					System.out.println("socket关闭");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
