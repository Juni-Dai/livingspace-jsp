<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>生活记录</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<link rel="stylesheet" href="./css/font.css">
<link rel="stylesheet" href="./css/xadmin.css">
<script type="text/javascript"
	src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./lib/layui/layui.js"
	charset="utf-8"></script>
<script type="text/javascript" src="./js/xadmin.js"></script>
<!-- 让IE8/9支持媒体查询，从而兼容栅格 -->
<!--[if lt IE 9]>
      <script src="https://cdn.staticfile.org/html5shiv/r29/html5.min.js"></script>
      <script src="https://cdn.staticfile.org/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
    	img{
    		width:200px;
    		height:200px;
    		border:1px solid whitesmoke;
    		background-color:white;
    		cursor:pointer;
    	}
    	.layui-upload{
    		display:inline-block;
    	}
    	.layui-form-label{
    		width:90px;
    	}
    	.layui-input-block{
    		margin-left:120px;
    	}
    </style>
</head>

<body>
	<div class="x-body layui-anim layui-anim-up">
		<form class="layui-form">
			<div class="layui-form-item">
				<label for="title" class="layui-form-label"> <span
					class="x-red">*</span>标题：
				</label>
				<div class="layui-input-inline">
					<input type="text" id="title" name="title" required
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">今日事迹：</label>
				<div class="layui-input-block">
					<textarea placeholder="请输入内容" class="layui-textarea" name="context" id="context"></textarea>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">今日语录：</label>
				<div class="layui-input-block">
					<input type="text" name="records" id="records" required
						autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">今日份美照：</label>
				<div class="layui-upload">
					<blockquote class="layui-elem-quote layui-quote-nm"
						style="margin-top: 10px;">
						<div class="layui-upload-list" id="demo2">
							<img id="upload" src="./images/img-add.png" class="layui-upload-img">
						</div>
					</blockquote>
				</div>
			</div>
			
			<div class="layui-form-item">
				<label for="L_repass" class="layui-form-label"> </label>
				<button class="layui-btn" lay-filter="add" lay-submit="">记录时刻</button>
			</div>
		</form>
	</div>
	<script>
		layui.use([ 'form', 'layer','upload' ], function() {
			$ = layui.jquery;
			var form = layui.form, layer = layui.layer,upload = layui.upload

			//自定义验证规则
			form.verify({
				nikename : function(value) {
					if (value.length < 5) {
						return '昵称至少得5个字符啊';
					}
				},
				pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
				repass : function(value) {
					if ($('#L_pass').val() != $('#L_repass').val()) {
						return '两次密码不一致';
					}
				}
			});

			//监听提交
			form.on('submit(add)', function(data) {
				var uname = $('#title').val();
				var context = $('#context').val();
				var records = $('#records').val();
				var daily = "{\"title\":\"" + uname + "\",\"context\":\"" + context +"\",\"records\":\""+ records +"\",\"imgAddress\":\""+imgAddress+"\"}";
				$.ajax({
					method:'POST',
					url:"dailyAddServlet",
					contentType:"application/x-www-form-urlencoded; charset=UTF-8",
					data:{"daily":daily},
					success:function(){
						layer.alert("记录成功", {icon: 6,closeBtn:0},function(){
							// 获得frame索引
			                var index = parent.layer.getFrameIndex(window.name);
			                //关闭当前frame
			                parent.layer.close(index);
			                window.parent.location.href = "dailyListServlet?pageIndex=1";
						});
					},
					error:function(){
						layer.msg("添加失败，请重新添加");
					}
				});
				return false;
			});
			var imgAddress = new Array();
			var i=0;
			//多图片上传
			  upload.render({
			    elem: '#upload'
			   ,url: 'dailyAddServlet'
			    ,multiple: true
			    ,before: function(obj){
			      //预读本地文件示例，不支持ie8
			      obj.preview(function(index, file, result){
			    	i++;
			        $('#upload').before('<img src="'+ result +'" alt="'+ file.name +'" class="layui-upload-img">');
			        //imgAddress[i] = result;
			      });
			    }
			    ,done: function(res){
			      console.log(res,"---");
			    }
			  });
		});
	</script>
</body>

</html>