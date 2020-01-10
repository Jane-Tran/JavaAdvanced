
<%@page import="model.bean.BenhAnBEAN"%>
<%@page import="model.bean.BacSyBEAN"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.bean.BenhNhanBEAN"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<jsp:include page="block/block_top.jsp"></jsp:include>

<div class="container-fuild phanhienthi">
	<div class="row">
		<div class="col-sm-12">

			<%
				ArrayList<BacSyBEAN> dsBacSy = null;
				if (request.getAttribute("dsBacSy") != null) {
					dsBacSy = (ArrayList<BacSyBEAN>) request.getAttribute("dsBacSy");
				}
			%>
			<h3 style="Text-align: center; color: #0A0A2A; margin-bottom: 30px;">
				<strong>DANH SÁCH BÁC SỸ VÀ BỆNH ÁN</strong>
			</h3>

			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<form class="form-inline my-2 my-lg-0" action="" method="get">
						<input class="form-control mr-sm-2" type="search"
							placeholder="Tìm kiếm" name="key" aria-label="Search">
						<button class="btn btn-outline-success my-2 my-sm-0" type="submit">
							<i class="fas fa-search"></i> Tìm kiếm
						</button>
					</form>
				</div>
				<div class="col-sm-2">
					<button type="button" style="margin-right: 8px; float: right;"
						class="btn btn-outline-primary"
						onclick="document.getElementById('id01').style.display='block'">
						<i class="fas fa-plus-circle"></i> Thêm bệnh án
					</button>

				</div>
			</div>
			<div class="row sapxep_dhm1">
				<div class="col-sm-2"></div>
				<div class="col-sm-7"></div>
				<div class="col-sm-3"></div>
			</div>
			<div class="row">
				<div class="col-sm-4">
					<div class="list-group">
						<h4
							style="text-align: center; color: #0A0A2A; margin-bottom: 10px;">
							<strong>DANH SÁCH BÁC SỸ</strong>
						</h4>
						<a href="BacSy" class="list-group-item 
						<%if (request.getParameter("doctorID") == null)
							out.print("active");%>">Tất cả
						</a>
						<%if (dsBacSy != null) {%>
						<%for (BacSyBEAN lb : dsBacSy) {%>
						<%
							if (request.getParameter("doctorID") != null
											&& request.getParameter("doctorID").equals(lb.getDoctorID())) {
						%>
						<a href="BacSy?doctorID=<%=lb.getDoctorID()%>"
							class="list-group-item active" style="color: black;"><%=lb.getDoctorID()%></a>
						<%
							} else {
						%>
						<a href="BacSy?doctorID=<%=lb.getDoctorID()%>"
							class="list-group-item" style="color: black;"><%=lb.getDoctorName()%></a>
						<%
							}
								}
							}
						%>
					</div>
				</div>
				<div class="col-sm-8">
					<%
						ArrayList<BenhAnBEAN> dsBenhAn = null;
						if (request.getAttribute("dsBenhAn") != null) {
							dsBenhAn = (ArrayList<BenhAnBEAN>) request.getAttribute("dsBenhAn");
						}
					%>
					<%
						ArrayList<BenhAnBEAN> dsBenhAnTheoBacSy = null;
						if (request.getAttribute("dsBenhAnTheoBacSy") != null) {
							dsBenhAnTheoBacSy = (ArrayList<BenhAnBEAN>) request.getAttribute("dsBenhAnTheoBacSy");
						}
					%>
					<h4
						style="Text-align: center; color: #0A0A2A; margin-bottom: 10px;">
						<strong>DANH SÁCH BỆNH ÁN</strong>
					</h4>
					<table class="table table-striped table-bordered ds_dhm"
						style="background-color: white;">
						<thead class="thead-dark">
							<tr>
								<th scope="col">STT</th>
								<th scope="col">Patient ID</th>
								<th scope="col">Examine Date</th>
								<th scope="col">Result</th>
								<th scope="col">Treatments</th>
								<th scope="col">Hành động</th>
							</tr>
						</thead>
						<tbody>

							<%
								SimpleDateFormat dd = new SimpleDateFormat("dd-MM-yyyy");
								int i = 1;
								if (dsBenhAnTheoBacSy != null) {
									for (BenhAnBEAN ba : dsBenhAnTheoBacSy) {
							%>
							<tr>
								<%
									String date = dd.format(ba.getExamineDate());
								%>
								<th scope="row"><%=i%></th>
								<td><%=ba.getPatientID()%></td>
								<td><%=date%></td>
								<td><%=ba.getResult()%></td>
								<td><%=ba.getTreatments()%></td>
								<td><button data-toggle="modal"
										data-target="#myModal<%=ba.getExamineDate()%>" type="button"
										class="btn btn-outline-danger">
										<i class="fas fa-minus-circle"></i> Xóa
									</button></td>
							</tr>
							<%
								i++;
									}
								}
							%>

						</tbody>
					</table>
				</div>
			</div>
		</div>
	</div>
</div>
<%
	if (dsBenhAn != null) {
		for (BenhAnBEAN ls : dsBenhAn) {
%>
<div class="modal fade" id="myModal<%=ls.getExamineDate()%>"
	role="dialog" style="padding-right: 100px;">
	<div class="modal-dialog modal-sm">
		<div class="modal-content" style="width: 150%;">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<h3 class="modal-title">
					<b>Xóa Lịch sử lưu trú</b>
				</h3>
			</div>
			<div class="modal-body">
				<p>Bạn có muốn XÓA Lịch sử lưu trú này?</p>
			</div>
			<div class="modal-footer">
				<button type="button" class="btn btn-success" data-dismiss="modal">Không</button>
				<a
					href="BacSy?xoa=1&patientID=<%=ls.getPatientID()%>&doctorID=<%=ls.getDoctorID()%>&examineDate=<%=ls.getExamineDate()%>"><button
						type="button" class="btn btn-danger">Có</button></a>
			</div>
		</div>
	</div>
</div>
<%
	}
	}
%>



<jsp:include page="block/block_down.jsp"></jsp:include>