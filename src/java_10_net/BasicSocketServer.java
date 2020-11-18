package java_10_net;
/**
 * tcp������ͨ��socket��������
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
			ServerSocket serverSocket = new ServerSocket(9001);//ָ�������˿�
			socket = serverSocket.accept();//�������ȴ��ͻ������󣬲�Ը���������
			//��ȡsocket�����������ʹ�û��������а�װ
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write("���Է���˵���Ϣ");//��ͻ��˷�����Ϣ
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				if (bw!=null) {
					bw.close();
//					System.out.println("bw�ر�");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				if (socket!=null) {
					socket.close();
//					System.out.println("socket�ر�");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
