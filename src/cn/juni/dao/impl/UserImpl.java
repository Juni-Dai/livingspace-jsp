package cn.juni.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.juni.dao.IUser;
import cn.juni.pojo.User;
import cn.juni.util.DBUtil;

public class UserImpl implements IUser {

	@Override
	public User login(String uname, String upwd) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;
		try {
			conn = DBUtil.getConn();
			String sql = "select uid,uname,upwd,state,role from user where uname=? and upwd=?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, upwd);
			rs = ps.executeQuery();
			while(rs.next()) {
				user = new User();
				user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				user.setState(rs.getInt(4));
				user.setRole(rs.getInt(5));
			}
			return user;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(conn, ps, rs);
		}
		return null;
	}

}
