package cn.juni.pojo;

public class User {

	private int uid;				//用户ID
	private String uname;			//用户姓名
	private String upwd;			//用户密码
	private int state;				//用户状态 0正常 1禁用
	private int role;				//用户角色 0管理员 1普通用户
	
	public User() {}

	public User(int uid, String uname, String upwd, int state, int role) {
		this.uid = uid;
		this.uname = uname;
		this.upwd = upwd;
		this.state = state;
		this.role = role;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpwd() {
		return upwd;
	}

	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uname=" + uname + ", upwd=" + upwd + ", state=" + state + ", role=" + role + "]";
	}
	
}
