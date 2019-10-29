package net;
/**
 * 测试TCP双向通信
 * 读取数据使用readLine()方法，写入数据最后务必加上\n
 */
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class LoginTwoWayClient {
	public static void main(String[] args) throws IOException {
		System.out.println("client启动");
		//1.从键盘获取用户名和密码
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("输入用户名：");
		String name = br.readLine();
		System.out.println("输入密码：");
		String pwd = br.readLine();
//		System.out.println(name+" "+pwd);
		//2.创建socket对象，指定server，包装成流进行输出
		Socket client = new Socket("localhost", 9001);
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
		//写入数据务必换行，否则使用readLine()方法读取数据会无法结束
		bw.write("name="+name+"&"+"pwd="+pwd+"\n");
		bw.flush();
		//3.接收服务器的返回信息
		DataInputStream dis = new DataInputStream(client.getInputStream());
		System.out.println(dis.readUTF());
		//4.回收资源
		dis.close();
		bw.close();
		br.close();
		client.close();
	}
}
