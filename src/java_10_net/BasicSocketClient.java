package java_10_net;
/**
 * tcp������ͨ�ſͻ���
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
			socket = new Socket(InetAddress.getLocalHost(), 9001);//ָ������˶˿�
			//��ȡscoket������������ʹ�û��������а�װ
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//���շ������˷��͵���Ϣ
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
