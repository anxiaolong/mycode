package httpserver;

public class D3LoginServlet implements D3Servlet  {
	@Override
	public void service(D3Request request,D3Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print(request.decode("结果：", "utf-8"));
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print(request.decode(request.getName()+"登陆成功", "utf-8"));
		response.print("</body>");
		response.print("</html>");
	}
}
