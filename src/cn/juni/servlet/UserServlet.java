package cn.juni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import cn.juni.pojo.User;
import cn.juni.service.UserService;
import cn.juni.service.impl.UserServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/userServlet")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
    	userService = new UserServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		String uinfo = request.getParameter("uinfo");
		JSONObject jsonObject = JSON.parseObject(uinfo);
		String uname = jsonObject.getString("uname");
		String upwd = jsonObject.getString("upwd");
		User user = userService.login(uname, upwd);
		
		Map<String,Object> map = new HashMap<String,Object>();
		if(user != null) {
			session.setAttribute("user", user);
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", 1);
			map.put("data", user);
		}else {
			map.put("code", 0);
			map.put("msg", "");
			map.put("count", 1);
		}
		out.print(JSON.toJSON(map));
		out.close();
		
		
	}

}
