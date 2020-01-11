<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<div class="wrapper">
		<!-- Sidebar  -->
		<nav id="sidebar">
			<div id="dismiss">
				<i class="fas fa-arrow-left"></i>
			</div>

			<div class="sidebar-header">
				<br>
				<h4 style="text-align: center; margin-top: 5px;">QUẢN LÝ xxx</h4>
			</div>

			<ul class="list-unstyled components">
				<li><a href="./tam1.jsp">Quản lý aaa</a></li>
				<li><a href="">Quản lý bbb</a></li>
				<li><a href="">Quản lý ccc</a></li>
			</ul>

			<ul class="list-unstyled CTAs">
				<li><a class="article">Tran Van Quang Huy</a></li>
			</ul>
		</nav>

		<!-- Page Content  -->
		<div id="content">

			<nav class="navbar navbar-expand-lg navbar-light bg-light">
				<div class="container-fluid">

					<button type="button" id="sidebarCollapse" class="btn btn-info">
						<i class="fas fa-align-left"></i> <span>QUẢN LÝ PHÒNG XXX</span>
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
										Welcome --
									</button>
									<div class="dropdown-menu" aria-labelledby="dropdownMenu2">
										<a href="DangNhap?logout=true" style="text-decoration: none;"><button
												class="dropdown-item" type="button">Đăng xuất</button></a>
									</div>
								</div></li>
						</ul>
					</div>
				</div>
			</nav>