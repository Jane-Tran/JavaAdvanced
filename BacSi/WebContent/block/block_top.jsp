
<%@page import="model.bean.TaiKhoanBEAN"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<title>Quản Lý</title>

<link rel="icon" href="assets/img/logo.png" type="image/gif" sizes="16x16">

<!-- Bootstrap CSS CDN -->
	<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
	integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
	crossorigin="anonymous">
<!-- Our Custom CSS -->
<link rel="stylesheet" href="assets/css/style3.css">
<!-- Scrollbar Custom CSS -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/malihu-custom-scrollbar-plugin/3.1.5/jquery.mCustomScrollbar.min.css">

<!-- Font Awesome JS -->
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.5.0/css/all.css"
	integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU"
	crossorigin="anonymous">
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/solid.js"
	integrity="sha384-tzzSw1/Vo+0N5UhStP3bvwWPq+uvzCMfrN1fEFe+xBmv1C/AtVX5K0uZtmcHitFZ"
	crossorigin="anonymous"></script>
<script defer
	src="https://use.fontawesome.com/releases/v5.0.13/js/fontawesome.js"
	integrity="sha384-6OIrr52G08NpOFSZdxxz1xdNSndlD4vdcf/q2myIUVO0VsqaGHJsB0RaBE01VTOY"
	crossorigin="anonymous"></script>

<!-- google font -->
<link href="https://fonts.googleapis.com/css?family=Fira+Sans" rel="stylesheet">
<style type="text/css">
body {
	background-color: #f1f2f4;
	font-family: 'Fira Sans', sans-serif;
}

.sapxep_dhm {
	width: 333px;
}

.sapxep_dhm div button {
	margin-left: 9px;
	width: 112px;
}

.sapxep_dhm1 {
	margin-top: 10px;
}

.ds_dhm {
	margin-top: 10px
}

.phanhienthi {
	max-width: 1200px;
	margin: 0px auto;
	font-family: 'Fira Sans', sans-serif;
}

/* phần style popup thêm đợt hiến máu */
/* Full-width input fields */
input[type=text], input[type=password], input[type=number], input[type=date],
	input[type=email] {
	width: 100%;
	padding: 12px 20px;
	margin: 8px 0;
	display: inline-block;
	border: 1px solid #ccc;
	box-sizing: border-box;
}

/* Set a style for all buttons */
.button_popup {
	background-color: #4CAF50;
	color: white;
	padding: 14px 20px;
	margin: 8px 0;
	border: none;
	cursor: pointer;
	width: 100%;
	opacity: 0.9;
}

.button_popup:hover {
	opacity: 1;
}

/* Extra styles for the cancel button */
.cancelbtn {
	width: auto;
	padding: 10px 18px;
	background-color: #f44336;
}

/* Center the image and position the close button */
.imgcontainer {
	text-align: center;
	margin: 24px 0 12px 0;
	position: relative;
}

img.avatar {
	width: 40%;
	border-radius: 50%;
}

.container {
	padding: 16px;
}

span.psw {
	float: right;
	padding-top: 16px;
}

/* The Modal (background) */
.modal1 {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
	padding-top: 60px;
}

/* Modal Content/Box */
.modal-content {
	background-color: #fefefe;
	margin: 5% auto 15% auto;
	/* 5% from the top, 15% from the bottom and centered */
	border: 1px solid #888;
	width: 55%; /* Could be more or less, depending on screen size */
}

/* The Close Button (x) */
.close {
	position: absolute;
	right: 25px;
	top: 0;
	color: #000;
	font-size: 35px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: red;
	cursor: pointer;
}

/* Add Zoom Animation */
.animate {
	-webkit-animation: animatezoom 0.6s;
	animation: animatezoom 0.6s
}

@
-webkit-keyframes animatezoom {
	from {-webkit-transform: scale(0)
}

to {
	-webkit-transform: scale(1)
}

}
@
keyframes animatezoom {
	from {transform: scale(0)
}

to {
	transform: scale(1)
}
}
</style>
</head>

<body>
	<% 
	TaiKhoanBEAN taikhoan = null;
	if(request.getAttribute("taikhoan")!=null){
		 taikhoan = (TaiKhoanBEAN) request.getAttribute("taikhoan");
	}%>
	<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div id="dismiss">
				<i class="fas fa-arrow-left"></i>
			</div>

			<div class="sidebar-header">
				<br>
				<h4 style="text-align: center; margin-top: 5px;">QUẢN LÝ PHÒNG KHÁM BỆNH</h4>
			</div>

			<ul class="list-unstyled components">
				<li class="active"><a href="#homeSubmenu"
					data-toggle="collapse" aria-expanded="false"
					class="dropdown-toggle">Tài khoản</a>
					<ul class="collapse list-unstyled" id="homeSubmenu">
						<li><a href="">Thông tin cá nhân</a></li>
						<li><a href="">Đổi mật khẩu</a></li>
						<li><a href="DangNhap?logout=true">Đăng xuất</a></li>
					</ul></li>
				<li><a href="BenhNhan">Quản lý bệnh nhân</a></li>
				<li><a href="BacSy">Quản lý bệnh án</a></li>
				<li><a href="BenhAnNam">Quản lý bệnh án theo năm</a></li>
			</ul>

			<ul class="list-unstyled CTAs">
				<li><a class="article">Nguyễn Trần Nhã Huyền</a></li>
			</ul>
		</nav>

		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>QUẢN LÝ PHÒNG KHÁM BỆNH</span>
					</button>
					<button class="btn btn-dark d-inline-block d-lg-none ml-auto"
						type="button" data-toggle="collapse"
						data-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<i class="fas fa-align-justify"></i>
					</button>

					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="nav navbar-nav ml-auto">
							<!-- <li class="nav-item active"><a class="nav-link"
								href="QL_TaiKhoan.jsp">Xin chào, Admin</a></li> -->
							<li class="nav-item active"><div class="dropdown">
									<button class="btn btn-link dropdown-toggle" type="button"
										id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
										aria-expanded="false"
										style="width: 196px; margin-right: 70px; text-decoration: none; color: black">
										Xin chào,<%
										if (taikhoan != null) {
									%>
										<%=taikhoan.getAdname()%>
										<%
											}
										%>
									</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
										<a href="#"><button class="dropdown-item"
												type="button">Thông tin cá nhân</button></a> 
										<a href="#"><button class="dropdown-item"
												type="button">Đổi mật khẩu</button></a>
										<div class="dropdown-divider"></div>
										<a href="DangNhap?logout=true"><button
												class="dropdown-item" type="button">Đăng xuất</button></a>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>