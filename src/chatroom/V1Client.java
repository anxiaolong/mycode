package chatroom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;


public class V1Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket(InetAddress.getLocalHost(), 9001);
		System.out.println("client");
		(new Thread(new SendMsg(socket))).start();
		(new Thread(new ReceiveMsg(socket))).start();
	}
}


