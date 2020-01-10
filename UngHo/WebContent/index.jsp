<%@page import="model.bean.DotUngHoBEAN"%>
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
				<a href="#" class="list-group-item list-group-item-action active" role="tab"><b>Đợt ủng hộ</b></a>
				<a href="ThongKeController" class="list-group-item list-group-item-action" role="tab"><b>Thống kê tiền mặt của mỗi hộ dân</b></a>
				<a href="NhanUngHoController" class="list-group-item list-group-item-action" role="tab"><b>Đợt nhận ủng hộ</b></a>
			</div>
		</div>
		<div class="table-wrapper col-lg-9">
			<div class="table-title">
				<div class="row">
					<div class="col-sm-6">
						<h2>Thông tin <b> Các đợt ủng hộ</b></h2>
					</div>

				</div>
			</div>
			<div class="card">
				<div class="card-header">
					<h3>Thêm mới một đợt ủng hộ</h3>
				</div>
				<div class="card-body" style="font-size: 18px">
					<form action="DotUngHoController" method="POST">
					<%
					String kq = (String)request.getAttribute("kq");
					if(kq=="them"){ %>
						<div class="alert alert-success alert-dismissible">
						  <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
						  <strong>Thêm thành công!</strong> một đợt ủng hộ mới.
						</div>
						<%} %>
						<div class="form-row">
							<div class="form-group col-md-4">
								<label for="inputCity">Mã đợt ủng hộ</label>
								<input type="text" class="form-control" name="madotungho" id="inputCity" required><br>
								<%
									if(kq=="loi"){ %>
									<div class="alert alert-danger alert-dismissible">
									    <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
									    Mã đã tồn tại !
								  	</div>
								  	<%} %>
							</div>
							<div class="form-group col-md-4">
								<label for="inputState">Người đại diện Ủng hộ</label>
									<select id="inputState"   name ="nguoiungho"class="form-control " required>
										<option value="" selected>Chọn người ủng hộ ...</option>
										<%if(request.getAttribute("dv")!=null){
											ArrayList<DonViUngHoBEAN> dv = new ArrayList<DonViUngHoBEAN>();
											dv = (ArrayList<DonViUngHoBEAN>)request.getAttribute("dv");
											for(DonViUngHoBEAN d:dv){%>
										<option value="<%=d.getMaDVUH()%>"> <%=d.getHoTenDVUH() %> </option>
										<%}} %>
									</select>
							</div>	
							<div class="form-group col-md-4">
								<label for="inputNgayUngHo">Ngày ủng hộ</label>
								<input type="date" class="form-control" name="ngayungho" id="inputNgayUngHo" required>
							</div>
						</div>
						<div class="form-row">
							<div class="form-group col-md-6">
								<label for="inputCity">Hình thức ủng hộ</label>
								<input type="text" class="form-control" name="hinhthuc" id="inputCity" required>
							</div>
							<div class="form-group col-md-4">
								<label for="inputSL">Số lượng</label>
								<input type="number" class="form-control" name="soluong" id="inputSL" min="1" required>
							</div>
							<div class="form-group col-md-2">
								<label for="inputDV">Đơn vị tính</label>
								<input type="text" class="form-control" name="donvi" id="inputDV" required>
							</div>
						</div>
						
						<button type="submit" name="themDotUngHo" class="btn btn-success btn-right">Thêm</button>
					</form>
				</div>
			</div>
			<p class="text-light text-center bg-dark">-*-</p>
			<h3>Danh sách đợt Ủng hộ</h3><br>
			<table id="DUHTable" class="table table-striped table-hover">
				<thead>
					<tr>
						<th>
							<span class="custom-checkbox">
								<input type="checkbox" id="selectAll">
								<label for="selectAll"></label>
							</span>
						</th>
						<th>Họ tên người đại diện Ủng hộ</th>
						<th>Ngày Ủng hộ</th>
						<th>Hình thức ủng hộ</th>
						<th>Số lượng ủng hộ</th>
						<th>Đơn vị tính</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
						<% if(request.getAttribute("duh")!=null){
							ArrayList<DotUngHoBEAN> list = new ArrayList<DotUngHoBEAN>();
							list = (ArrayList<DotUngHoBEAN>)request.getAttribute("duh");
							for(DotUngHoBEAN dot : list){%>
						<tr>
							<td>
								<span class="custom-checkbox">
									<input type="checkbox" id="checkbox1" name="options[]" value="1">
									<label for="checkbox1"></label>
								</span>
							</td>
							<td><%=dot.getHoTenNguoiDaiDien() %></td>
							<td><%=dot.getNgayUngHo() %></td>
							<td><%=dot.getHinhThucUngHo() %></td>
							<td><%=dot.getSoLuongUngHo() %></td>
							<td><%=dot.getDonViTinh() %></td>
							<td>
								<a href="#editEmployeeModal" class="edit"
									 onclick="EditDUH('<%=dot.getMaDotUngHo() %>',
									 '<%=dot.getMaDVUH() %>',
									 '<%=dot.getNgayUngHo() %>',
									 '<%=dot.getHinhThucUngHo() %>', 
									 '<%=dot.getSoLuongUngHo()%>',
									 '<%=dot.getDonViTinh() %>')"
									data-toggle="modal">
									<i class="material-icons" data-toggle="tooltip" title="Edit">&#xE254;</i>
								</a>
								<a href="#deleteEmployeeModal" class="delete" data-toggle="modal"><i class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
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
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="SuaDUHController" method="POST">
				<div class="modal-header">
					<h4 class="modal-title">Chỉnh sửa đợt Ủng hộ</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group">
						<label for="eMaDotUngHo">Mã đợt ủng hộ</label>
						<input type="text" id="eMaDotUngHo" disabled class="form-control" required>
					</div>
					<div class="form-group">
						<input type="hidden" id="eMaDotUngHoHidden" name="madotungho"  class="form-control" required>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputState">Người đại diện Ủng hộ</label>
									<select id="eHoTenNDD"   name ="nguoiungho"class="form-control " required>
										<option value="" selected>Chọn người ủng hộ ...</option>
										<%if(request.getAttribute("dv")!=null){
											ArrayList<DonViUngHoBEAN> dv = new ArrayList<DonViUngHoBEAN>();
											dv = (ArrayList<DonViUngHoBEAN>)request.getAttribute("dv");
											for(DonViUngHoBEAN d:dv){%>
										<option value="<%=d.getMaDVUH()%>"> <%=d.getHoTenDVUH() %> </option>
										<%}} %>
									</select>
						</div>
						<div class="form-group col-md-6">
							<label for="eNgayUngHo">Ngày ủng hộ</label>
							<input type="date" class="form-control" name="ngayungho" id="eNgayUngHo" required>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="eHinhThuc">Hình thức Ủng hộ</label>
							<input type="text" class="form-control" name="hinhthuc" id="eHinhThuc" required>
						</div>
						<div class="form-group col-md-4">
							<label for="eSoLuong">Số lượng</label>
							<input type="number" class="form-control" name="soluong" id="eSoLuong" min="1" required>
						</div>
						<div class="form-group col-md-2">
							<label for="eDonVi">Đơn vị tính</label>
							<input type="text" class="form-control" name="donvi" id="eDonVi" required>
						</div>
					</div>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" name="suaDotUngHo" class="btn btn-info" value="Save">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form>
				<div class="modal-header">
					<h4 class="modal-title">Delete Employee</h4>
					<button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Are you sure you want to delete these Records?</p>
					<p class="text-warning"><small>This action cannot be undone.</small></p>
				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel">
					<input type="submit" class="btn btn-danger" value="Delete">
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="scripts.jsp"></jsp:include>
<jsp:include page="footer.jsp"></jsp:include>