package java_11_httpserver;

import java.io.File;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

import org.apache.commons.io.FileUtils;


public class Dispatcher implements Runnable {
	Socket socket;
	Request request;
	Response response;
	String ClassString;
	
	public Dispatcher(Socket socket) {
		this.socket = socket;
		request = new Request(socket);
		response = new Response(socket);
		ClassString = null;
	}
	
	@Override
	public void run() {
		//通过请求参数创建servlet
		Servlet servlet = null;
		//通过url找到对应的类名
		List<Mapping> l1 = WebHandler.getMappings();
		for (Mapping mapping : l1) {
			if (mapping.getPatterns().contains(request.getUrl())) {
				List<Entity> l2 = WebHandler.getEntities();
				for (Entity entity : l2) {
					if (entity.getName().equals(mapping.getName())) {
						ClassString = entity.getClassString();
					}
				}
			}
		}
		if (ClassString == null) {
			try {
				byte[] html = FileUtils.readFileToByteArray(new File("D:\\eclipse-workspace\\mycode\\src\\httpserver\\login.html"));
				response.print(new String(html));
				response.pushToBrowser(200);
				return ;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//通过找到的类名创建servlet对象
		try {
			Class clz = Class.forName(ClassString);
			servlet = (Servlet)clz.getConstructor().newInstance();
			servlet.service(request, response);
			response.pushToBrowser(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void release() {
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
