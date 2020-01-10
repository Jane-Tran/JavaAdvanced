<%@page import="model.bean.NhanUngHoBEAN"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="model.bean.DonViUngHoBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
  
<jsp:include page="header.jsp"></jsp:include>
    <div class="container-fluid">
	<a href="#" style="text-decoration:none;">
		<h1 class=" pt-4 pb-2 "><img src="https://gudlogo.com/wp-content/uploads/2019/06/gulogo-6.jpg" width="80px" height="80px" alt=""> Ủng hộ lũ lụt</h1>
	</a>
</div>
<hr>
	<div class="row">
		<div class="col-lg-2">
			<div class="list-group" id="list-tab" role="tablist">
				<a href="DotUngHoController" class="list-group-item list-group-item-action " role="tab"><b>Đợt ủng hộ</b></a>
				<a href="ThongKeController" class="list-group-item list-group-item-action" role="tab"><b>Thống kê tiền mặt của mỗi hộ dân</b></a>
				<a href="NhanUngHoController" class="list-group-item list-group-item-action active" role="tab"><b>Đợt nhận ủng hộ</b></a>
			</div>
		</div>
		<div class="table-wrapper col-lg-9">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Thông tin <b> Các đợt nhận ủng hộ</b></h2>
					</div>

				</div>
			</div>
			<table id="DUHTable" class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>Mã đợt nhận ủng hộ</th>
						<th>Mã hộ dân</th>
						<th>Ngày giờ nhận ủng hộ</th>
						<th>Hình thức nhận ủng hộ</th>
						<th>Số lượng nhận ủng hộ</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
						<% if(request.getAttribute("nuh")!=null){
							ArrayList<NhanUngHoBEAN> list = new ArrayList<NhanUngHoBEAN>();
							list = (ArrayList<NhanUngHoBEAN>)request.getAttribute("nuh");
							for(NhanUngHoBEAN nhan : list){%>
						<tr>
							<td>
								<span class="custom-checkbox">
									<input type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
								</span>
							</td>
							<td><%=nhan.getMaDotNhanUngHo() %></td>
							<td><%=nhan.getMaHoDan() %></td>
							<td><%=nhan.getNgayNhanUngHo() %></td>
							<td><%=nhan.getHinhThucNhanUngHo() %></td>
							<td><%=nhan.getSoLuongNhanUngHo() %></td>
							<td>
								<a href="#editEmployeeModal" class="edit"
									
									data-toggle="modal">
									<i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
								</a>
								<a href="#deleteEmployeeModal" class="delete" 
									onclick="DeleteDNUH('<%=nhan.getMaDotNhanUngHo()%>')"
									data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
							</td>
						</tr>
							<%}} %>
					<?php } ?>
				</tbody>
			</table>
			<div class="col-sm-6">
				<a href="#deleteEmployeeModal" class="btn btn-danger btn-sm" data-toggle="modal"><i class="material-icons">&#xE15C;</i> </a>
			</div>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="NhanUngHoController" method="post" >
				<div class="modal-header">
					<h4 class="modal-title">Xóa đợt nhận ủng hộ</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Bạn chắc chắn là muốn xóa dòng dữ liệu này</p>
					<p class="text-warning"><small>Việc này sẽ không hoàn tác lại được</small></p>
				</div>
				<div class="modal-footer">
					<input type="hidden" name="xMaDotNhanUngHo" id="xMaDotNhanUngHo">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-danger" name="xoaNhanUngHo" value="Delete">
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="scripts.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>