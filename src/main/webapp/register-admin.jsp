<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head><script type="text/javascript" src="/utils/scripts/flat-ui.js"></script><meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"><link rel="shortcut icon" href="/utils/image/favicon.ico" type="image/x-icon" />
		<meta charset="UTF-8">
		<title>学生信息管理系统</title>
		<script type="text/javascript" src="/utils/js/jquery-3.3.1.min.js"></script>
		<!-- Loading Bootstrap -->
		<link href="/utils/css/vendor/bootstrap.min.css" rel="stylesheet">
		<!-- Loading Flat UI Pro -->
		<link href="/utils/css/flat-ui.css" rel="stylesheet">
		<!-- Loading Flat UI JS -->
		<script type="text/javascript" src="/utils/scripts/flat-ui.min.js"></script>
	<script type='text/javascript' src='/utils/scripts/particles.js'></script><link href="/utils/css/animate.css" rel="stylesheet"></head>
	
	<body><div id="particles-js"><canvas class="particles-js-canvas-el" width="1322" height="774" style="width: 100%; height: 100%;"></canvas></div>
	<div class="container">
		<div class="row">
			<div class="col-md-6">
				<h5>管理员注册</h5>
				<form action="/RegisterHandler/addAdmin" method="post">
					<h6>用户名</h6>
						<input type="text" id="tname" name="tname" class="form-control" maxlength="20"></input>
						<h6>密&nbsp;&nbsp;码</h6>
						<input type="password" id="tpassword" name="tpassword" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16"></input>
						<h6>确认密码</h6><span id="tpasswordremsg" style="color: #ff0000;"></span>
					<input type="password" id="tpasswordre" name="tpasswordre" class="form-control" onkeyup="this.value=this.value.replace(/(^\s+)|(\s+$)/g,'');" maxlength="16" onblur="checkPwd()"></input>
					<input type="submit" value="注册" class="btn btn-primary btn-wide login-btn" style="margin-top:2rem"/>
						<input type="button" value="返回登录" class="btn btn-primary btn-wide login-btn" style="margin-top:2rem" onclick="window.location.href = '/'"/>

				</form>
			</div>
		</div>	
	</div>
	<script type="text/javascript" src="/utils/scripts/flat-ui.js"></script><script src="/utils/scripts/bganimation.js"></script>
	<script type="text/javascript">
		function checkPwd() {
			var tpassword = $("#tpassword").val();
			var tpasswordre = $("#tpasswordre").val();
			if (tpassword !== tpasswordre) {
				alert("两次密码不一致");
				return false;
			}
			return true;
		}

		$("form").submit(function(){
			//当表单提交的时候，对字段验证，并根据需要放出提示
			if($.trim($("#tname").val())==""){
				alert("用户名不能为空");
				return false;//终止表单提交

			}
			if($.trim($("#tpassword").val())==""){
				alert("密码不能为空");
				return false;//终止表单提交

			}
			return checkPwd();
		});
	</script>
	</body>
</html>