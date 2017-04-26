//导入必需的 java 库
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//扩展 HttpServlet 类
public class MusicList extends HttpServlet {

private String message;

public void init() throws ServletException
{
   // 执行必需的初始化
	
   message = new GetFoldFileNames().getFileName("d:\\music");
}

public void doGet(HttpServletRequest request,
                 HttpServletResponse response)
         throws ServletException, IOException
{
   // 设置响应内容类型
	request.setCharacterEncoding("utf-8");
   response.setContentType("text/json");
   response.setCharacterEncoding("utf-8");

   // 实际的逻辑是在这里
   PrintWriter out = response.getWriter();
   out.println("{\"status\":true,\"data\":"+message+"}");
}

public void destroy()
{
   // 什么也不做
}
}
