package cn.juni.service.impl;

import java.util.List;

import cn.juni.dao.IDaily;
import cn.juni.dao.impl.DailyImpl;
import cn.juni.pojo.Daily;
import cn.juni.service.DailyService;

public class DailyServiceImpl implements DailyService {

	private IDaily dailyDao = null;
	
	public DailyServiceImpl() {
		dailyDao = new DailyImpl();
	}
	
	@Override
	public int insertDaily(Daily daily) {
		return dailyDao.insertDaily(daily);
	}

	@Override
	public List<Daily> getAllDaily() {
		return dailyDao.getAllDaily();
	}

	@Override
	public List<Daily> getAllDailyByPage(int pageIndex, int pageSize) {
		return dailyDao.getAllDailyByPage(pageIndex, pageSize);
	}

	@Override
	public int getCount() {
		return dailyDao.getCount();
	}

	@Override
	public int delDailyById(String[] dids) {
		return dailyDao.delDailyById(dids);
	}

	@Override
	public Daily getDescById(int did) {
		return dailyDao.getDescById(did);
	}

}
