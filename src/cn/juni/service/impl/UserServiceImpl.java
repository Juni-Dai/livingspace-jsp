package cn.juni.service.impl;

import cn.juni.dao.IUser;
import cn.juni.dao.impl.UserImpl;
import cn.juni.pojo.User;
import cn.juni.service.UserService;

public class UserServiceImpl implements UserService {

	private IUser iuser = null;
	
	public UserServiceImpl() {
		iuser = new UserImpl();
	}
	
	@Override
	public User login(String uname, String upwd) {
		User user = iuser.login(uname, upwd);
		return user;
	}

}
