package chatroom;
/**
 * ��������Ϣת��ʵ��
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CopyOnWriteArrayList;

//1.ʵ��һ���û��������շ��Լ�����Ϣ
//2.ʹ�ö��̣߳�ʵ�ֶ���û��Լ����Լ�����Ϣ
//3.ʵ��Ⱥ�ģ�ʹ��CopyOnWriteArrayList��Ϊ������һ���޸�һ��ʹ��
//4.��client��������
//5.ʵ��˽��
//6.��ȫ�˳�Ⱥ�ģ������쳣

/**
 * @author Administrator
 *
 */
public class V1Chat {
	static CopyOnWriteArrayList<ChatChannel> all = new CopyOnWriteArrayList<ChatChannel>();
	static boolean isRunning = true;
	public static void main(String[] args) throws IOException  {
		ServerSocket serverSocket = new ServerSocket(9001);
		System.out.println("server������");
		
		while (V1Chat.isRunning) {
			Socket socket = serverSocket.accept();
			System.out.println("һ�����ӽ���");
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
		this.send("��ӭ����������");
		this.sendOther(this.name+"��������");
	}
	
	//������Ϣ
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

	//������Ϣ
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
	
	//��Ⱥ��Ϣ
	public void sendOther(String msg) {
		for (ChatChannel chatChannel : V1Chat.all) {
			if (this!=chatChannel) {
				chatChannel.send(this.name+":"+msg);
			}
		}
	}
	
	//��˽����Ϣ
	public void sendPrivate(String msg) {
		//Լ��˽�ķ�����Ϣ��ʽΪ @name:msg
		int index = msg.indexOf("��");
		String toname = msg.substring(1, index);
		String tomsg = msg.substring(index+1);
		findSomeone(toname).send(this.name+"@�㣺"+tomsg);
	}
	
	//�ҵ�˽���˶�Ӧ��ChatChannel����
	public ChatChannel findSomeone(String name) {
		for (ChatChannel chatChannel : V1Chat.all) {
			if (name.equals(chatChannel.name)) {
				return chatChannel;
			}
		}
		return null;
	}
	
	//��Դ����
	public void release() {
		isRunning = false;
		V1Chat.all.remove(this);
		CloseTools.closeAll(dos,dis,socket);
		sendOther(this.name+"�˳�����");
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
				System.out.println("һ���ͻ��˳�����");
				receive();
			}
		}
	}
}


