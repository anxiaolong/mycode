package httpserver;
/**
 * ��װ��Ӧresponse
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	private BufferedWriter bw;
	//��Ӧ����
	public StringBuilder content;
	//Э��ͷ��Ϣ��״̬��������ͷ �س���
	public StringBuilder headInfo;
	private int len;
	
	private final String blank = " ";
	private final String crlf = "\r\n";//Linux�»���
	
	public Response() {
		content = new StringBuilder();
		headInfo = new StringBuilder();
		len = 0;
	}
	
	//ͨ��socket������Ӧ����
	public  Response(Socket socket) {
		this();//���ÿչ���
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//ͨ�������������Ӧ����
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	//��Ӧ�����������
	public Response print(String s) {
		content.append(s);
		len+= s.getBytes().length;
		return this;
	}
	//��Ӧ������Ӳ�����
	public Response println(String s) {
		content.append(s).append(crlf);
		len += (s+crlf).getBytes().length;
		return this;
	}
	
	//����ͷ��Ϣ
	public void createHeadInfo(int code) {
		//1.��Ӧ�У�HTTP/1.1 200 OK
		headInfo.append("HTTP/1.1").append(blank);
		headInfo.append(code).append(blank);
		switch (code) {
			case 200:
				headInfo.append("OK").append(crlf);
				break;
			case 404:
				headInfo.append("NOT FOUND").append(crlf);
				break;
			case 505:
				headInfo.append("SERVER ERROR").append(crlf);
				break;
		}
		//2.��Ӧͷ�����һ��Ϊ�գ�
		headInfo.append("Date:").append(new Date()).append(crlf);
		headInfo.append("Server:").append("test_axl Server/0.0.1;charset=GBK").append(crlf);
		headInfo.append("Content-length:").append(len).append(crlf);
		headInfo.append(crlf);
	}
	
	public void pushToBrowser(int code) {
		if (null==headInfo) {
			code = 505;
		}
		createHeadInfo(code);
		try {
			//����ֻ��ʹ��append׷����Ϣ��write������д��
			bw.append(headInfo);
			bw.append(content);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("�ͻ����쳣");
		}
	}
}

