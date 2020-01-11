<%@page import="bean.ThongKeBEAN"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="bean.HoatDongBEAN"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<jsp:include page="header.jsp"></jsp:include>
<div class="container-fluid pr-5 pl-5">
<div class="row">
<div class="table-wrapper col-lg-3 pr-5">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-12">
					<h2>
						Thống kê <b> Điểm trung bình của trưởng đoàn</b>
					</h2>
				</div>
			</div>
		</div>
		<table class="table table-striped table-hover" style="border: solid 1px">
			<thead>
				<tr>

					<th>Mã thành viên</th>
					<th>Họ tên</th>
					<th>Điểm trung bình</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (request.getAttribute("tk") != null) {
						ArrayList<ThongKeBEAN> list = new ArrayList<ThongKeBEAN>();
						list = (ArrayList<ThongKeBEAN>) request.getAttribute("tk");
						for (ThongKeBEAN tk : list) {
				%>
				<tr>

					<td><%=tk.getMaTV()%></td>
					<td><%=tk.getHoTen()%></td>
					<td><%=tk.getDiemtrungbinh()%></td>
				</tr>
				<%
					}
					}
				%>

			</tbody>
		</table>

	</div>
	<hr>
	<div class="table-wrapper col-lg-9">
		<div class="table-title">
			<div class="row">
				<div class="col-sm-6">
					<h2>
						Danh sách <b> hoạt động</b>
					</h2>
				</div>
				<div class="col-sm-6">
					<a href="#addEmployeeModal" class="btn btn-success"
						data-toggle="modal"><i class="material-icons">&#xE147;</i> <span>Add
							Hoạt động</span></a>
				</div>
			</div>
		</div>
		<table class="table table-striped table-hover" style="border: solid 1px">
			<thead>
				<tr>

					<th>Mã hoạt động</th>
					<th>Tên hoạt động</th>
					<th>Mô tả</th>
					<th>Ngày bắt đầu</th>
					<th>Ngày kết thúc</th>
					<th>Số lượng tối thiểu</th>
					<th>Số lượng tối đa</th>
					<th>Thời hạn đăng kí</th>
					<th>Trạng thái</th>
					<th>Mã trưởng đoàn</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
					if (request.getAttribute("ds") != null) {
						ArrayList<HoatDongBEAN> list = new ArrayList<HoatDongBEAN>();
						list = (ArrayList<HoatDongBEAN>) request.getAttribute("ds");
						SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
						for (HoatDongBEAN hd : list) {
				%>
				<tr>

					<td><%=hd.getMaHD()%></td>
					<td><%=hd.getTenHD()%></td>
					<td><%=hd.getMoTaHD()%></td>
					<td><%=hd.getNgayGioBD()%></td>
					<td><%=hd.getNgayGioKT()%></td>
					<td><%=hd.getsLToiThieuYC()%></td>
					<td><%=hd.getsLToiDaDK()%></td>
					<td><%=hd.getThoiHanDK()%></td>
					<td><%=hd.getTrangThai()%></td>
					<td><%=hd.getMaTV()%></td>

					<td><a href="#editEmployeeModal" class="edit"
							onclick="EditHoatDong('<%=hd.getMaHD()%>',
								 '<%=hd.getTenHD() %>',
								 '<%=hd.getMoTaHD() %>',
								 '<%=df.format(hd.getNgayGioBD())%>', 
								 '<%=df.format(hd.getNgayGioKT())%>',
								 '<%=hd.getsLToiThieuYC() %>',
								 '<%=hd.getsLToiDaDK() %>',
								 '<%=hd.getThoiHanDK() %>',
								 '<%=hd.getTrangThai() %>',
								 '<%=hd.getMaTV() %>'
							)"
							data-toggle="modal"><i class="material-icons"
							data-toggle="tooltip" title="Edit">&#xE254;</i></a> 
						<%if(!hd.getTrangThai().equals("Da ket thuc")) {%>
						<a href="#deleteEmployeeModal" class="delete" data-toggle="modal"
							onclick="DeleteHoatDong('<%=hd.getMaHD()%>')"><i
						class="material-icons" data-toggle="tooltip" title="Delete">&#xE872;</i></a>
						<%} %>	
					</td>
				</tr>
				<%
					}
					}
				%>

			</tbody>
		</table>
</div>
	</div>
</div>
<!-- Add Modal HTML -->
<div id="addEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="HoatDongController" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Thêm hoạt động</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group row">
							<label for="addMaHD" class="col-4 col-form-label">Mã hoạt động :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="addMaHD" id="addMaHD" required>
							</div>
						</div>	

						<div class="form-group row">
							<label for="addTenHD" class="col-4 col-form-label">Tên hoạt động :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="addTenHD"  id="addTenHD" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="addMoTaHD" class="col-4 col-form-label">Mô tả :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="addMoTaHD"  id="addMoTaHD" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="addNgayGioBD" class="col-4 col-form-label">Ngày giờ bắt đầu : </label>
							<div class="col-8">
								<input class="form-control" type="datetime-local" name="addNgayGioBD"  id="addNgayGioBD" required>
							</div>
						</div>	

						<div class="form-group row">
							<label for="addNgayGioKT" class="col-4 col-form-label">Ngày giờ kết thúc :</label>
							<div class="col-8">
								<input class="form-control" type="datetime-local" name="addNgayGioKT" id="addNgayGioKT" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="addSLToiThieuYC" class="col-4 col-form-label right">Số lượng tối thiểu:</label>
							<div class="col-2 pr-2">
								<input class="form-control " type="number" min=1 name="addSLToiThieuYC" id="addSLToiThieuYC" required>
							</div>
							<label for="addSLToiDaYC" class="col-4 col-form-label">Số lượng tối đa:</label>
							<div class="col-2">
								<input class="form-control" type="number" name="addSLToiDaYC" min=1 id=""addSLToiDaYC"" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="addThoiHanDK" class="col-4 col-form-label">Thời hạn đăng kí :</label>
							<div class="col-8">
								<input class="form-control" type="date" name="addThoiHanDK" id="addThoiHanDK" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="addMaTV" class="col-4 col-form-label">Mã trưởng đoàn :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="addMaTV"  id="addMaTV" required>
							</div>
						</div>

				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal" value="Cancel"> 
					<input type="submit" name="addHoatDong" class="btn btn-success" value="Add">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Edit Modal HTML -->
<div id="editEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="HoatDongController" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Sửa hoạt động</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<div class="form-group row">
							<label for="editMaHD" class="col-4 col-form-label">Mã hoạt động :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="editMaHD" id="editMaHD" required>
							</div>
						</div>	

						<div class="form-group row">
							<label for="editTenHD" class="col-4 col-form-label">Tên hoạt động :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="editTenHD"  id="editTenHD" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="editMoTaHD" class="col-4 col-form-label">Mô tả :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="editMoTaHD"  id="editMoTaHD" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="editNgayGioBD" class="col-4 col-form-label">Ngày giờ bắt đầu : </label>
							<div class="col-8">
								<input class="form-control" type="datetime-local" name="editNgayGioBD"  id="editNgayGioBD" required>
							</div>
						</div>	

						<div class="form-group row">
							<label for="editNgayGioKT" class="col-4 col-form-label">Ngày giờ kết thúc :</label>
							<div class="col-8">
								<input class="form-control" type="datetime-local" name="editNgayGioKT" id="editNgayGioKT" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="editSLToiThieuYC" class="col-4 col-form-label right">Số lượng tối thiểu:</label>
							<div class="col-2 pr-2">
								<input class="form-control " type="number" min=1 name="editSLToiThieuYC" id="editSLToiThieuYC" required>
							</div>
							<label for="editSLToiDaYC" class="col-4 col-form-label">Số lượng tối đa:</label>
							<div class="col-2">
								<input class="form-control" type="number" name="editSLToiDaYC" min=1 id="editSLToiDaYC" required>
							</div>
						</div>

						<div class="form-group row">
							<label for="editThoiHanDK" class="col-4 col-form-label">Thời hạn đăng kí :</label>
							<div class="col-8">
								<input class="form-control" type="date" name="editThoiHanDK" id="editThoiHanDK" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="editTrangThai" class="col-4 col-form-label">Trạng thái :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="editTrangThai"  id="editTrangThai" required>
							</div>
						</div>
						<div class="form-group row">
							<label for="editMaTV" class="col-4 col-form-label">Mã trưởng đoàn :</label>
							<div class="col-8">
								<input class="form-control" type="text" name="editMaTV"  id="editMaTV" required>
							</div>
						</div>

				</div>
				<div class="modal-footer">
					<input type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit" name="editHoatDong" class="btn btn-info"
						value="Save">
				</div>
			</form>
		</div>
	</div>
</div>
<!-- Delete Modal HTML -->
<div id="deleteEmployeeModal" class="modal fade">
	<div class="modal-dialog">
		<div class="modal-content">
			<form action="HoatDongController" method="post">
				<div class="modal-header">
					<h4 class="modal-title">Xóa hoạt động</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<p>Bạn chắc chắn muốn xóa ?</p>
				</div>
				<div class="modal-footer">
					<input type="hidden" id="DeleteMaHD" name="DeleteMaHD"> <input
						type="button" class="btn btn-default" data-dismiss="modal"
						value="Cancel"> <input type="submit" name="DeleteHoatDong"
						class="btn btn-danger" value="Delete">
				</div>
			</form>
		</div>
	</div>
</div>
<jsp:include page="scripts.jsp"></jsp:include>
