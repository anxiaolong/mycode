package httpserver;
/**
 * 接收浏览器请求
 */
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class D3Server01 {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) {
		D3Server01 server = new D3Server01();
		server.start();
	}
	
	public void start() {
		//新建一个ServerSocket对象
		try {
			serverSocket = new ServerSocket(9001);
			receive();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("启动失败");
		}
	}
	
	public void receive() {
		try {
			Socket socket = serverSocket.accept();
			System.out.println("一个连接进来");
			
			//获取请求协议
			InputStream is = socket.getInputStream();
			byte[] datas = new byte[1024*1024];
			int len = is.read(datas);
			String requestInfo = new String(datas, 0, len);
			System.out.println(requestInfo);
			
			StringBuilder content = new StringBuilder();
			content.append("<html>");
			content.append("<head>");
			content.append("<title>");
			content.append("服务器响应成功");
			content.append("</title>");
			content.append("</head>");
			content.append("<body>");
			content.append("server回来了");
			content.append("</body>");
			content.append("</html>");
			int size = content.toString().getBytes().length;
			StringBuilder responseInfo = new StringBuilder();
			String blank = " ";
			String crlf = "\r\n";
			//返回
			//1.相应行：HTTP/1.1 200 OK
			responseInfo.append("HTTP/1.1").append(blank);
			responseInfo.append("200").append(blank);
			responseInfo.append("OK").append(crlf);
			//2.响应头，最后一行为空
			/*
			 * Date:Mon,31Dce209904:25:57GMT
			 * Server:anxiaolong_test Server/0.01;charset=GBK
			 * Content-type:text/html
			 * Content-length:898893
			 */
			responseInfo.append("Date:").append(new Date()).append(crlf);
			responseInfo.append("Server:").append("anxiaolong_test Server/0.01;charset=GBK").append(crlf);
			responseInfo.append("Content-type:").append("text/html").append(crlf);
			responseInfo.append("Content-length:").append(size).append(crlf);
			responseInfo.append(crlf);
			//3.添加正文
			responseInfo.append(content.toString());
			
			//写出到客户端
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bw.write(responseInfo.toString());
			bw.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("客户端异常");
		}
	}
	
	public void stop() {
		
	}
}
