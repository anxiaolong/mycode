package java_11_httpserver;

public class LoginServlet implements Servlet  {
	@Override
	public void service(Request request,Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print(request.decode("结果：", "utf-8"));
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print(request.getName()+"登陆成功");
		response.print("</body>");
		response.print("</html>");
	}
}
