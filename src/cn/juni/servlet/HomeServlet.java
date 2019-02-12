package cn.juni.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/homeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final String SHOW = "show";
	private static final String RECORD = "add";
	private static final String CLEAR = "del";
	private static final String UPDATE = "up";
	
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		if(SHOW.equals(action)) {
			response.sendRedirect("dailyListServlet");
		}else if(RECORD.equals(action)) {
			response.sendRedirect("daily-record.jsp");
		}else if(CLEAR.equals(action)) {
			response.sendRedirect("daily-clear.jsp");
		}else {
			response.sendRedirect("daily-update.jsp");
		}
	}

}
