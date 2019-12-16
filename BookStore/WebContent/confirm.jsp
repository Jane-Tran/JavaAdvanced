<%@page import="model.bean.hoadonbean"%>
<%@page import="model.bo.giohangbo"%>
<%@page import="model.bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.sachdao"%>
<%@page import="model.bean.sachbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <title> Dashboard</title>
    <!-- Custom fonts for this template-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet"
        type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">
    <!-- Custom styles for this template-->
    <link href="css/admin.css" rel="stylesheet">

</head>

<body id="page-top">
    <!-- Page Wrapper -->
    <div id="wrapper">
        <!-- Sidebar -->
        <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

            <!-- Sidebar - Brand -->
            <a class="sidebar-brand d-flex align-items-center justify-content-center" href="manageLoaiController">
                <div class="sidebar-brand-icon rotate-n-15">
                    <i class="fas fa-laugh-wink"></i>
                </div>
                <div class="sidebar-brand-text mx-3">Admin</div>
            </a>

            <!-- Divider -->
            <hr class="sidebar-divider my-0">

            <!-- Nav Item - Dashboard -->
            <li class="nav-item active">
                <a class="nav-link" href="manageLoaiController">
                    <i class="fas fa-fw fa-cog"></i>
                    <span>Dashboard</span></a>
            </li>

            <!-- Divider -->
            <hr class="sidebar-divider">

            <!-- Heading -->
            <div class="sidebar-heading">
                Interface
            </div>

            <!-- Nav Item - Pages Collapse Menu -->
            <li class="nav-item">
                <a class="nav-link" href="manageLoaiController" >
                    <i class="fas fa-bookmark"></i>
                    <span>Quản lý loại</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="manageSachController" >
                    <i class="fas fa-book-dead"></i>
                    <span>Quản lý sách</span>
                </a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="confirmController" >
                    <i class="fas fa-truck"></i>
                    <span>Xác nhận đơn hàng</span>
                </a>
            </li>
            <!-- Divider -->
            <hr class="sidebar-divider d-none d-md-block">
            <!-- Sidebar Toggler (Sidebar) -->
            <div class="text-center d-none d-md-inline">
                <button class="rounded-circle border-0" id="sidebarToggle"></button>
            </div>

        </ul>
        <!-- End of Sidebar -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
                <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                    <!-- Sidebar Toggle (Topbar) -->
                    <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                        <i class="fa fa-bars"></i>
                    </button>

                    <!-- Topbar Search -->
                    <form
                        class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                                aria-label="Search" aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="button">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                    <!-- Topbar Navbar -->
                    <ul class="navbar-nav ml-auto">
                        <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                        <li class="nav-item dropdown no-arrow d-sm-none">
                            <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-search fa-fw"></i>
                            </a>
                            <!-- Dropdown - Messages -->
                            <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                                aria-labelledby="searchDropdown">
                                <form class="form-inline mr-auto w-100 navbar-search">
                                    <div class="input-group">
                                        <input type="text" class="form-control bg-light border-0 small"
                                            placeholder="Search for..." aria-label="Search"
                                            aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="button">
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                            </div>
                        </li>
                        <div class="topbar-divider d-none d-sm-block"></div>
                        <!-- Nav Item - User Information -->
                        <li class="nav-item dropdown no-arrow">
                            <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                <span class="mr-2 d-none d-lg-inline text-gray-600 small">
                                    Huy
                                </span>
                                <i class="fas fa-user-shield"></i>
                            </a>
                            <!-- Dropdown - User Information -->
                            <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                                aria-labelledby="userDropdown">
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Profile
                                </a>
                                <a class="dropdown-item" href="#">
                                    <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Settings
                                </a>
                                <div class="dropdown-divider"></div>
                                <a class="dropdown-item" href="login-admin.php">
                                    <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                    Logout
                                </a>
                            </div>
                        </li>

                    </ul>

                </nav>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-left justify-content-left mb-4">
                        <h1 class="h5 mb-0 text-gray-900">Dashboard  <i class="fas fa-chevron-right"></i> </h1>
                        <h3 class="h5 mb-0 text-gray-800">  Xác nhận mua hàng  </h3>
                    </div>
                    <div class = "container">
				<br>
				
				<div class="card card-body">
				   <div class="row ">
				   		<h3 class="card-title">Danh sách đơn hàng</h3>
				   </div>
				   <br>
				   <table id="mytable" class="table table-striped table-hover">
				         <tr>
				           <th>
						   		<input type="checkbox" id="checkall" />
						   </th>
				           <th># Mã hóa đơn</th>
				           <th>Tên khách hàng</th>
				           <th>Ngày mua</th>
				           <th style=" width: 200px;">Tình trạng</th>
				           
				         </tr>
				         <%
							ArrayList<hoadonbean> dshd=new ArrayList<hoadonbean>();
							dshd=(ArrayList<hoadonbean>)request.getAttribute("confirm");
							for(hoadonbean hd:dshd){
								%>
				         <tr>
				         	<% if(!hd.isDamua()){%>
				         	<td>
								<input type="checkbox" class="checkthis" />
							</td>
							<%}else{ %>
				           		<td></td>
				           	<%} %>
				           <td>#<%=hd.getMahoadon() %></td>
				           <td><%=hd.getMakhachhang()%></td>
				           <td><%=hd.getNgaymua()%></td>
				          	<% if(hd.isDamua()){%>
				          		<td><img src="images/approval_48px.png"></td>
				           	<%}else{ %>
				           		<td>
				           			<img src="images/pos_terminal_48px.png">
				           			<a class="btn btn-info btn-small pr-2" href="confirmController?Duyet=<%=hd.getMahoadon()%>">Duyệt đơn</a> 
				           		</td>
				           	<%} %>
				         </tr>
				       <%} %>
				   </table>
				 </div>
				 </div>
				</div>
                <!-- End of Content Wrapper -->

            </div>
            <!-- End of Page Wrapper -->
            <!-- Scroll to Top Button-->
            <a class="scroll-to-top rounded" href="#page-top">
                <i class="fas fa-angle-up"></i>
            </a>
            <!-- Bootstrap core JavaScript-->
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
            <!-- Custom scripts for all pages-->
            <script src="js/history.js"></script>
</body>

</html>