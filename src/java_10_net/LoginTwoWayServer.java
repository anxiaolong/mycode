package java_10_net;
/**
 * 测试TCP双向通信
 * 读取数据使用readLine()方法，写入数据最后务必加上\n
 */
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class LoginTwoWayServer {
	public static void main(String[] args) throws IOException {
		System.out.println("server启动");
		//1.创建ServerSocket服务，创建socket接收
		ServerSocket serverSocket = new ServerSocket(9001);
		Socket server = serverSocket.accept();
		//2.创建流接收数据并处理
		BufferedReader br = new BufferedReader(new InputStreamReader(server.getInputStream()));
		String acceptString = br.readLine();
		String[] namepwd = acceptString.split("&");
		String[] name = namepwd[0].split("=");
		String[] pwd = namepwd[1].split("=");
		//处理数据并返回结果
		DataOutputStream dos = new DataOutputStream(server.getOutputStream());
		if (name[1].equals("anxiaolong")&&pwd[1].equals("123456")) {
			System.out.println("登陆成功");
			dos.writeUTF("登陆成功");
		} else {
			System.out.println("用户名或密码错误");
			dos.writeUTF("用户名或密码错误");
		}
		dos.flush();
		//4.回收资源
		dos.close();
		br.close();
		serverSocket.close();
	}
}
