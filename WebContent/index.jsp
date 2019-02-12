<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>后台登录-X-admin2.0</title>
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<meta http-equiv="Cache-Control" content="no-siteapp" />

<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="js/jquery-3.1.1.js"></script>
<script src="./lib/layui/layui.js" charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>

</head>
<body>

	<!-- 权限控制 用户未登录不能打开该页面 -->
	<c:if test="${empty user }">
		<c:redirect url="login.jsp" />
	</c:if>

	<!-- 顶部开始 -->
	<div class="container">
		<div class="main layui-clear">
			<div class="logo">
				<a href="./index.html">生活-空间</a>
			</div>
			<ul class="layui-nav right" lay-filter="">
				<li class="layui-nav-item"><c:if test="${not empty user }">
						<a href="javascript:;">${user.uname }</a>
					</c:if>
					<dl class="layui-nav-child">
						<!-- 二级菜单 -->
						<dd>
							<a onclick="x_admin_show('个人信息','http://www.baidu.com')">个人信息</a>
						</dd>
						<dd>
							<a onclick="x_admin_show('切换帐号','http://www.baidu.com')">切换帐号</a>
						</dd>
						<dd>
							<a href="./login.html">退出</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item to-index"><a href="/">前台首页</a></li>
			</ul>
		</div>

	</div>
	<!-- 中间主体部分 -->
	<div style="width: 100%; position: absolute; top: 36px; bottom: 0;">
		<iframe src='./home.jsp' frameborder="0" width="100%" height="100%"
			class="x-iframe"></iframe>
	</div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<!-- 底部开始 -->
	<div class="footer">
		<div class="copyright">Copyright ©2017 x-admin v2.3 All Rights
			Reserved</div>
	</div>
	<!-- 底部结束 -->
</body>
</html>