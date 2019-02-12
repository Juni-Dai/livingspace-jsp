package cn.juni.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import cn.juni.service.DailyService;
import cn.juni.service.impl.DailyServiceImpl;

/**
 * Servlet implementation class DailyDelServlet
 */
@WebServlet("/dailyDelServlet")
public class DailyDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DailyDelServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		Map<String,Object> map = new HashMap<String,Object>();
		DailyService dailyService = new DailyServiceImpl();
		
		String[] delIds = request.getParameterValues("delId");
		
		int result = dailyService.delDailyById(delIds);
		
		if(result>0) {
				map.put("code", 0);
				map.put("msg", "删除成功");
				map.put("count", 0);
			}else {
				map.put("code", 500);
				map.put("msg", "服务器异常，删除失败");
				map.put("count", 0);
			}
		out.print(JSON.toJSON(map));
		out.close();
	}

}
