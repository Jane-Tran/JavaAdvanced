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
                        <h3 class="h5 mb-0 text-gray-800">  Quản lý sách  </h3>
                    </div>
                    <div class = "container-fluid">
						<br>
						<% sachbean sc = (sachbean)request.getAttribute("chon"); %>
						<div class ="card card-body">
						<form action="manageSachController" method="get" id="carform">
						  <div class="form-row">
						  	<div class="col-3">
							    <label>Mã sách</label>
							    <input type="text" class="form-control"  name="masach"value="<%=sc!=null?sc.getMasach():""%>">
							</div>
							<div class="col-5">
							    <label>Tên sách</label>
							    <input type="text" class="form-control"  name="tensach"value="<%=sc!=null?sc.getTensach():""%>">
							</div>
							
						  </div>
						  <div class="form-row pt-3">
						  	<div class="col-3">
							    <label>Số lượng</label>
							    <input type="text" class="form-control"  name="soluong"value="<%=sc!=null?sc.getSoluong():""%>">
							</div>
							<div class="col-3">
							    <label>Giá</label>
							    <input type="text" class="form-control"  name="gia"value="<%=sc!=null?sc.getGia():""%>">
							</div>
							<div class="col-3">
							    <label>Số tập</label>
							    <input type="text" class="form-control"  name="sotap"value="<%=sc!=null?sc.getSotap():""%>">
							</div>
						  </div>
						  <div class="form-row pt-3">
						  	<div class="col-4">
							    <label>Ngày nhập</label>
							    <input type="date" class="form-control" placeholder="yyyy/MM/dd" name="ngaynhap"value="<%=sc!=null?sc.getNgaynhap():""%>">
							</div>
							<div class="col-3">
							    <label>Mã loại</label><br>
							    <select name="maloai" form="carform" class="form-control" >
								  <option value="<%=sc!=null?sc.getMaloai():""%>"><%=sc!=null?sc.getMaloai():""%></option>
								  <% ArrayList<loaibean> loai=new ArrayList<loaibean>();
									loai=(ArrayList<loaibean>)request.getAttribute("loai");
									for(loaibean l: loai ){%>
								  <option value="<%=l.getMaloai()%>"><%=l.getMaloai()%></option>
								  <%} %>
								</select>
							</div>
						  </div>
						  <div class="form-row pt-3">
							<div class="col-3">
							    <label>Tác giả</label>
							    <input type="text" class="form-control"  name="tacgia"value="<%=sc!=null?sc.getTacgia():""%>">
							</div>
						  	<div class="col-3">
							    <label> Ảnh</label>
							    <input type="file" class="form-control"  name="anh"value="<%=sc!=null?sc.getAnh():""%>">
							</div>
						  </div>
						  <div class="pt-3">
							  <input type="submit" class="btn btn-primary " name="btnThem" value="Thêm">
							  <input type="submit" class="btn btn-success" name="btnSua" value="Lưu">
						</div>
						</form>
						</div>
						<hr>
						<br>
						<% if(request.getAttribute("kt")!=null){
							String key = (String)request.getAttribute("kt");
							switch (key) {
							case "them":
								out.print("<div class='alert alert-success' role='alert'>Thêm mới thành công !!!!!!!</div>");
								break;
							case "sua":
								out.print("<div class='alert alert-warning' role='alert'> Đã sửa thành công !!!!!!!</div>");
								break;
							case "xoa":
								out.print("<div class='alert alert-danger' role='alert'> Đã xóa :((  </div>");
								break;
							default:
								break;
							}	
							%>
							
						<% }%>
						<br>
						<div class="card card-body mt-10">
						   <div class="row">
						   		<h3 class="card-title">Danh sách sách</h3>
						         <div class="col-md-12">
						             <input class="form-control" type="text" placeholder="Sách cần tìm...">
						         </div>
						   </div>
						   <br>
						   <table class="table table-striped table-hover">
						         <tr>
						           <th style="width: 3%">Mã sách</th>
						           <th style="width: 15%">Tên sách</th>
						           <th style="width: 3%">Số lượng</th>
						           <th style="width: 5%">Giá</th>
						           <th style="width: 10%">Mã loại</th>
						           <th style="width: 5%">Số tập</th>
						           <th style="width: 10px">Ảnh</th>
						           <th style="width: 10%">Ngày nhập</th>
						           <th style="width: 15%">Tác giả</th>
						           <th style="width: 15%">Xử lý</th>
						           
						         </tr>
						         <%
									ArrayList<sachbean> sach=new ArrayList<sachbean>();
									sach=(ArrayList<sachbean>)request.getAttribute("sach");
									for(sachbean sb:sach){%>
						         <tr>
						           <td><%=sb.getMasach() %></td>
						           <td><%=sb.getTensach()%></td>
						           <td><%=sb.getSoluong()%></td>
						           <td><%=sb.getGia()%></td>
						           <td><%=sb.getMaloai()%></td>
						           <td><%=sb.getSotap()%></td>
						           <td><%=sb.getAnh()%></td>
						           <td><%=sb.getNgaynhap()%></td>
						           <td><%=sb.getTacgia()%></td>
						           <td>
						           		<a class="btn btn-info btn-sm" href="manageSachController?msChon=<%=sb.getMasach()%>">Chọn</a> 
						           		<a class="btn btn-danger btn-sm" href="manageSachController?msXoa=<%=sb.getMasach()%>">Xóa</a>
						           	</td>
						         </tr>
						         
						       <%} %>
						       </table>
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
            <script src="js/admin.js"></script>
</body>

</html>