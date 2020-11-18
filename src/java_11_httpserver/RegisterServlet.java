package java_11_httpserver;

public class RegisterServlet implements Servlet {
	@Override
	public void service(Request request,Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("结果：");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("注册成功");
		response.print("</body>");
		response.print("</html>");
	}
}
