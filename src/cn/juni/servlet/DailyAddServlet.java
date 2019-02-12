package cn.juni.servlet;

import java.io.IOException;
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

import cn.juni.pojo.Daily;
import cn.juni.pojo.User;
import cn.juni.service.DailyService;
import cn.juni.service.impl.DailyServiceImpl;

/**
 * Servlet implementation class DailyAddServlet
 */
@WebServlet("/dailyAddServlet")
public class DailyAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DailyAddServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");
		String dailyJson = request.getParameter("daily");
		
		JSONObject jsonObject = JSON.parseObject(dailyJson);
		String title = jsonObject.getString("title");
		String context = jsonObject.getString("context");
		String records = jsonObject.getString("records");
		
		Daily daily = new Daily();
		daily.setTitle(title);
		daily.setContext(context);
		daily.setUid(user.getUid());
		daily.setRecords(records);
		
		DailyService dailyService = new DailyServiceImpl();
		int result = dailyService.insertDaily(daily);
		Map<String,Object> map = new HashMap<String,Object>();
		if(result>0) {
			map.put("code", 0);
			map.put("msg", "添加成功");
			map.put("count", 0);
		}else {
			map.put("code", 500);
			map.put("msg", "服务器异常，添加失败");
			map.put("count", 0);
		}
		response.getWriter().print(JSON.toJSON(map));
		response.getWriter().close();
	}

}
