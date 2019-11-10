package httpserver;
/**
 * 封装响应response
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

public class Response {
	private BufferedWriter bw;
	//响应正文
	public StringBuilder content;
	//协议头信息（状态行与请求头 回车）
	public StringBuilder headInfo;
	private int len;
	
	private final String blank = " ";
	private final String crlf = "\r\n";//Linux下换行
	
	public Response() {
		content = new StringBuilder();
		headInfo = new StringBuilder();
		len = 0;
	}
	
	//通过socket构造响应对象
	public  Response(Socket socket) {
		this();//调用空构造
		try {
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//通过输出流构造响应对象
	public Response(OutputStream os) {
		this();
		bw = new BufferedWriter(new OutputStreamWriter(os));
	}
	
	//响应正文添加内容
	public Response print(String s) {
		content.append(s);
		len+= s.getBytes().length;
		return this;
	}
	//响应正文添加并换行
	public Response println(String s) {
		content.append(s).append(crlf);
		len += (s+crlf).getBytes().length;
		return this;
	}
	
	//构建头信息
	public void createHeadInfo(int code) {
		//1.响应行：HTTP/1.1 200 OK
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
		//2.响应头（最后一行为空）
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
			//这里只能使用append追加信息，write是重新写入
			bw.append(headInfo);
			bw.append(content);
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端异常");
		}
	}
}

