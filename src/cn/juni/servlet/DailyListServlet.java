package cn.juni.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.juni.pojo.Daily;
import cn.juni.pojo.DailyCustom;
import cn.juni.service.DailyService;
import cn.juni.service.impl.DailyServiceImpl;

@WebServlet("/dailyListServlet")
public class DailyListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private DailyService dailyService;
	
    public DailyListServlet() {
    	dailyService = new DailyServiceImpl();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pageI = request.getParameter("pageIndex");
		
		int pageIndex = 1;
		int pageSize = 5;
		
		if(pageI!=null && pageI!="") {
			pageIndex = Integer.parseInt(pageI);
		}
		
		DailyCustom dailyCustom = new DailyCustom();
		int count = dailyService.getCount();
		List<Daily> dailyList = dailyService.getAllDailyByPage(pageIndex, pageSize);
		dailyCustom.setPageIndex(pageIndex);
		dailyCustom.setPageSize(pageSize);
		dailyCustom.setCount(count);
		dailyCustom.setDailyList(dailyList);
		request.setAttribute("dailyCustom", dailyCustom);
		request.getRequestDispatcher("daily-list.jsp").forward(request, response);
	}

}
