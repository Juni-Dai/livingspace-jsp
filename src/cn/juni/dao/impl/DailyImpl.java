package cn.juni.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.juni.dao.IDaily;
import cn.juni.pojo.Daily;
import cn.juni.util.DBUtil;

public class DailyImpl implements IDaily {

	@Override
	public int insertDaily(Daily daily) {
		int result=0;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			df.format(new Date());
			String sql = "insert into daily(title,context,recorded,uid,createtime) values(?,?,?,?,?)";
			Object[] objects = {daily.getTitle(),daily.getContext(),daily.getRecords(),daily.getUid(),
					new java.sql.Timestamp(df.parse(df.format(new Date())).getTime())};
			result = DBUtil.method(sql, objects);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Daily> getAllDaily() {
		List<Daily> dailyList = new ArrayList<Daily>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select did,title,context,pic,uid,recorded,createtime from daily";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Daily daily = new Daily();
				daily.setDid(rs.getInt(1));
				daily.setTitle(rs.getString(2));
				daily.setContext(rs.getString(3));
				daily.setPic(rs.getString(4));
				daily.setUid(rs.getInt(5));
				daily.setRecords(rs.getString(6));
				daily.setCreatetime(rs.getDate(7));
				dailyList.add(daily);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return dailyList;
	}

	@Override
	public List<Daily> getAllDailyByPage(int pageIndex, int pageSize) {
		List<Daily> dailyList = new ArrayList<Daily>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select did,title,context,pic,uid,recorded,createtime from daily limit ?,?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageIndex-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			while(rs.next()) {
				Daily daily = new Daily();
				daily.setDid(rs.getInt(1));
				daily.setTitle(rs.getString(2));
				daily.setContext(rs.getString(3));
				daily.setPic(rs.getString(4));
				daily.setUid(rs.getInt(5));
				daily.setRecords(rs.getString(6));
				daily.setCreatetime(rs.getTimestamp(7));
				dailyList.add(daily);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return dailyList;
	}

	@Override
	public int getCount() {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		try {
			conn = DBUtil.getConn();
			String sql = "select count(1) from daily";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return result;
	}

	@Override
	public int delDailyById(String[] dids) {
		String sql = "";
		if(dids.length>1) {
			sql = "delete from daily where did in(";
			for(int i=0;i<dids.length;i++) {
				if(i!=dids.length-1) {
					sql += "?,";
				}else {
					sql += "?)";
				}
			}
		}else {
			sql = "delete from daily where did=?";
		}
		Object[] objects = new Object[dids.length];
		for(int i=0;i<objects.length;i++) {
			objects[i] = dids[i];
		}
		int result = DBUtil.method(sql, objects);
		return result;
	}

	@Override
	public Daily getDescById(int did) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Daily daily = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select did,title,context,recorded,pic,uid,createtime from daily where did=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, did);
			rs = ps.executeQuery();
			while(rs.next()) {
				daily = new Daily();
				daily.setDid(rs.getInt(1));
				daily.setTitle(rs.getString(2));
				daily.setContext(rs.getString(3));
				daily.setRecords(rs.getString(4));
				daily.setPic(rs.getString(4));
				daily.setUid(rs.getInt(6));
				daily.setCreatetime(rs.getTimestamp(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return daily;
	}

}
