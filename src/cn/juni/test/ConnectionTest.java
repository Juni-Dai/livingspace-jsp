package cn.juni.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import cn.juni.pojo.Daily;
import cn.juni.service.DailyService;
import cn.juni.service.impl.DailyServiceImpl;
import cn.juni.util.DBUtil;

public class ConnectionTest {

	DailyService dailyService = new DailyServiceImpl();
	
	@Test
	public void conntest() {
		DBUtil.getConn();
	}
	
	@Test
	public void insertDailyTest() {
		Daily daily = new Daily();
		daily.setDid(1);
		daily.setTitle("test");
		daily.setContext("测试数据....");
		daily.setPic("");
		daily.setRecords("加油，变的更好");
		daily.setUid(2);
		daily.setCreatetime(new java.sql.Date(new Date().getTime()));
		int result = dailyService.insertDaily(daily);
		System.out.println(result);
	}
	
	@Test
	public void getAllDailyTest() {
		List<Daily> dailyList = dailyService.getAllDaily();
		System.out.println(dailyList);
	}
	
	@Test
	public void getCountTest() {
		int count = dailyService.getCount();
		System.out.println(count);
	}
	
}
