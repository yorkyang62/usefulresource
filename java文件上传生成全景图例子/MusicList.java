//�������� java ��
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//��չ HttpServlet ��
public class MusicList extends HttpServlet {

private String message;

public void init() throws ServletException
{
   // ִ�б���ĳ�ʼ��
	
   message = new GetFoldFileNames().getFileName("d:\\music");
}

public void doGet(HttpServletRequest request,
                 HttpServletResponse response)
         throws ServletException, IOException
{
   // ������Ӧ��������
	request.setCharacterEncoding("utf-8");
   response.setContentType("text/json");
   response.setCharacterEncoding("utf-8");

   // ʵ�ʵ��߼���������
   PrintWriter out = response.getWriter();
   out.println("{\"status\":true,\"data\":"+message+"}");
}

public void destroy()
{
   // ʲôҲ����
}
}
