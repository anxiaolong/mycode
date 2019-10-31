package chatroom;
/**
 * 聊天室消息转发实现
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

//1.实现一个用户无限制收发自己的消息
//2.使用多线程，实现多个用户自己给自己发消息
//3.实现群聊，使用CopyOnWriteArrayList作为容器，一边修改一边使用
//4.给client增加名字
//5.实现私聊
//6.安全退出群聊，处理异常

/**
 * @author Administrator
 *
 */
public class V1Chat {
	static CopyOnWriteArrayList<ChatChannel> all = new CopyOnWriteArrayList<ChatChannel>();
	static boolean isRunning = true;
	public static void main(String[] args) throws IOException  {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("server启动：");
		
		while (V1Chat.isRunning) {
			Socket socket = serverSocket.accept();
			System.out.println("一个连接进来");
			ChatChannel channel = new ChatChannel(socket);
			all.add(channel);
			channel.start();
		}
		serverSocket.close();
	}
}

class ChatChannel extends Thread {
	private Socket socket;
	private String name;
	private DataInputStream dis;
	private DataOutputStream dos;
	boolean isRunning = true;
	
	public ChatChannel(Socket socket) throws IOException {
		this.socket = socket;
		this.name = receive();
		this.send("欢迎加入聊天室");
		this.sendOther(this.name+"加入聊天");
	}
	
	//接收消息
	public String receive() {
		try {
			dis = new DataInputStream(socket.getInputStream());
			String s = dis.readUTF();
			return s;
		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			release();
			return null;
		}
		
	}

	//发送消息
	public void send(String msg) {
		try {
			dos = new DataOutputStream(socket.getOutputStream());
			dos.writeUTF(msg);
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			release();
		}
	}
	
	//发群消息
	public void sendOther(String msg) {
		for (ChatChannel chatChannel : V1Chat.all) {
			if (this!=chatChannel) {
				chatChannel.send(this.name+":"+msg);
			}
		}
	}
	
	//发私聊消息
	public void sendPrivate(String msg) {
		//约定私聊发送信息格式为 @name:msg
		int index = msg.indexOf("：");
		String toname = msg.substring(1, index);
		String tomsg = msg.substring(index+1);
		findSomeone(toname).send(this.name+"@你："+tomsg);
	}
	
	//找到私聊人对应的ChatChannel对象
	public ChatChannel findSomeone(String name) {
		for (ChatChannel chatChannel : V1Chat.all) {
			if (name.equals(chatChannel.name)) {
				return chatChannel;
			}
		}
		return null;
	}
	
	//资源回收
	public void release() {
		isRunning = false;
		V1Chat.all.remove(this);
		CloseTools.closeAll(dos,dis,socket);
		sendOther(this.name+"退出聊天");
	}
	
	@Override
	public void run() {
		while (isRunning) {
			try {
				String msg = receive();
				if (msg.startsWith("@")) {
					sendPrivate(msg);
				} else {
					sendOther(msg);
				}
			} catch (Exception e) {
				System.out.println("一个客户退出聊天");
				receive();
			}
		}
	}
}


