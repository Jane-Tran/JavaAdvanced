<%@page import="model.bean.TaiKhoanBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Đăng nhập</title>
<link rel="icon" href="assets/img/logo.png" type="image/gif"
	sizes="16x16">
<link rel="stylesheet" type="text/css"
	href="assets/bootstrap/bootstrap.min.css">
<script type="text/javascript"
	src="assets/bootstrap/jquery-3.3.1.slim.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/popper.min.js"></script>
<script type="text/javascript" src="assets/bootstrap/bootstrap.min.js"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.5.0/js/all.js"
	integrity="sha384-GqVMZRt5Gn7tB9D9q7ONtcp4gtHIUEW/yG7h98J7IpE3kpi+srfFyyB/04OV6pG0"
	crossorigin="anonymous"></script>
<style type="text/css">
html, body {
	height: 100%;
}

.form-signin {
	width: 100%;
	max-width: 330px;
	padding: 15px;
	margin: auto;
}

.form-signin .checkbox {
	font-weight: 400;
}

.form-signin .form-control {
	position: relative;
	box-sizing: border-box;
	height: auto;
	padding: 10px;
	font-size: 16px;
}

.form-signin .form-control:focus {
	z-index: 2;
}

.form-signin input[type="email"] {
	margin-bottom: -1px;
	border-bottom-right-radius: 0;
	border-bottom-left-radius: 0;
}

.form-signin input[type="password"] {
	margin-bottom: 10px;
	border-top-left-radius: 0;
	border-top-right-radius: 0;
}
</style>

</head>
<body class="text-center">
	<%
		TaiKhoanBEAN taikhoan = null;
		if (request.getAttribute("taikhoan") != null) {
			taikhoan = (TaiKhoanBEAN) request.getAttribute("taikhoan");
		}

		String noti = "1";
		noti = (String) request.getAttribute("noti");
		if (noti != null) {
	%>


	<div>
		<%
			if (noti.equals("-1")) {
		%>
		<!-- Thông báo -->
		<div class="alert alert-success" role="alert">
			Xin Chào, Admin <br> <b>Đăng nhập thành công!</b> chuyển sang trang chủ trong <span id="time">3</span>s...
			<svg aria-hidden="true" data-prefix="fas" data-icon="spinner"
				role="img" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"
				class="svg-inline--fa fa-spinner fa-w-16 fa-spin fa-lg">
				<path fill="currentColor"
					d="M304 48c0 26.51-21.49 48-48 48s-48-21.49-48-48 21.49-48 48-48 48 21.49 48 48zm-48 368c-26.51 0-48 21.49-48 48s21.49 48 48 48 48-21.49 48-48-21.49-48-48-48zm208-208c-26.51 0-48 21.49-48 48s21.49 48 48 48 48-21.49 48-48-21.49-48-48-48zM96 256c0-26.51-21.49-48-48-48S0 229.49 0 256s21.49 48 48 48 48-21.49 48-48zm12.922 99.078c-26.51 0-48 21.49-48 48s21.49 48 48 48 48-21.49 48-48c0-26.509-21.491-48-48-48zm294.156 0c-26.51 0-48 21.49-48 48s21.49 48 48 48 48-21.49 48-48c0-26.509-21.49-48-48-48zM108.922 60.922c-26.51 0-48 21.49-48 48s21.49 48 48 48 48-21.49 48-48-21.491-48-48-48z"
					class=""></path></svg>

		</div>
		<%
			}
				if (noti.equals("0")) {
		%>
		<div class="alert alert-danger" role="alert">
			<b>Đăng nhập thất bại!</b> email hoặc mật khẩu không chính xác
		</div>
		<%
			}
			}
		%>
	</div>


	<div class="container">
		<form class="form-signin" action="" method="post">
			<img class="mb-4" src="assets/img/logoimg.jpg" alt="" width="200"
				height="120">
			<h2 class="h3 mb-3 font-weight-normal">
				<strong>ĐĂNG NHẬP</strong>
			</h2>
				<label for="inputEmail" class="sr-only">Email</label> 
				<input type="email" id="inputEmail" name="adname" class="form-control" placeholder="Email" required autofocus> 
				<label for="inputPassword" class="sr-only">Mật khẩu</label> 
				<input type="password" id="inputPassword" name="pass" class="form-control" placeholder="Mật khẩu" required>
			<div class="checkbox mb-3">
				<label> <input type="checkbox" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Đăng nhập</button>
			<div class="form-group">
				<div class="col-md-12 control">
					<div style="border-top: 1px solid #888; padding-top: 15px; font-size: 85%; margin-top: 10px;">
						<a href="">Quên mật khẩu?</a>
					</div>
				</div>
			</div>
			<p class="mt-5 mb-3 text-muted">&copy; 2018-2019</p>
		</form>
	</div>

	<script type="text/javascript">
		var jgt = 2;
		document.getElementById('time').innerHTML = jgt;
		function time() {
			document.getElementById('time').innerHTML = jgt;
			jgt = jgt - 1;
			if (jgt == 0) {
				clearInterval(timing);
				location = 'QL_TaiKhoan';
			}
		}
		var timing = setInterval("time();", 1000);
	</script>
</body>
</html>