package java_11_httpserver;

public class RegisterServlet implements Servlet {
	@Override
	public void service(Request request,Response response) {
		response.print("<html>");
		response.print("<head>");
		response.print("<title>");
		response.print("�����");
		response.print("</title>");
		response.print("</head>");
		response.print("<body>");
		response.print("ע��ɹ�");
		response.print("</body>");
		response.print("</html>");
	}
}
