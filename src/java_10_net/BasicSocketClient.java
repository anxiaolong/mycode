package java_10_net;
/**
 * tcp：单项通信客户端
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class BasicSocketClient {
	public static void main(String[] args) {
		BufferedReader br = null;
		Socket socket = null;
		try {
			socket = new Socket(InetAddress.getLocalHost(), 9001);//指定服务端端口
			//获取scoket的输入流，并使用缓冲流进行包装
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//接收服务器端发送的信息
			System.out.println(br.readLine());
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (br!=null) {
					br.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (socket!=null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
