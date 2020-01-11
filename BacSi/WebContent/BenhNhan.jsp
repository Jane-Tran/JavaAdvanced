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
				ArrayList<BenhNhanBEAN> dsBenhNhan=null;
				if(request.getAttribute("dsBenhNhan")!=null){
					dsBenhNhan=(ArrayList<BenhNhanBEAN>) request.getAttribute("dsBenhNhan");
				}
			%>
			<h3 style="text-align: center; color: #0A0A2A; margin-bottom: 30px;">
				<strong>THÔNG TIN BỆNH NHÂN</strong>
			</h3>
			<div class="row">
				<div class="col-sm-2"></div>
				<div class="col-sm-6">
					<form class="form-inline my-2 my-lg-0" action=""
						method="get">
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
						<i class="fas fa-plus-circle"></i> Thêm bệnh nhân
					</button>

				</div>
			</div>
			<br>
				<% if(request.getAttribute("error") != null){ %>
				<div class="alert alert-danger" role="alert">
				 <%= request.getAttribute("error") %>
				</div>
			<%} %>
			<div class="row sapxep_dhm1">
				<div class="col-sm-2"></div>
				<div class="col-sm-7"></div>
				<div class="col-sm-3"></div>
			</div>
			<table class="table table-striped table-bordered ds_dhm"
				style="background-color: white;">
				<thead class="thead-dark">
					<tr>
						<th scope="col">STT</th>
						<th scope="col">Patient ID</th>
						<th scope="col">Patient Name</th>
						<th scope="col">Sex</th>
						<th scope="col">BirthDay</th>
						<th scope="col">Address</th>
						<th scope="col">Phone Number</th>

					</tr>
				</thead>
				<tbody>
				
					<%	SimpleDateFormat dd= new SimpleDateFormat("dd-MM-yyyy");
						int i=1;
						if(dsBenhNhan!=null){
							for(BenhNhanBEAN cd:dsBenhNhan){
					%>
					<tr>
						<% String date=dd.format(cd.getBirthDay()); %>
						<th scope="row"><%=i%></th>
						<td><%=cd.getPatientID()%></td>
						<td><%=cd.getPatientName() %></td>
						<td><%=cd.getSex()%></td>
						<td><%=date%></td>
						<td><%=cd.getAddress() %></td>
						<td><%=cd.getPhoneNumber()%></td>
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

<!-- phần popup thêm đợt hiến máu -->
			<div id="id01" class="modal1">
				<span onclick="document.getElementById('id01').style.display='none'"
					class="close" title="Close Modal1">&times;</span>
				<form class="modal-content" action="BenhNhan"
					method="post">
					<div class="container">
						<h1>Thêm bệnh nhân</h1>
						<p>Vui lòng điền đầy đủ thông tin vào form bên dưới.</p>
						<hr>
						<label for="email"><b>Patient ID</b></label> <input
							type="text" placeholder="nhập ID" name="patientID" required>
						 <label
							for="email"><b>Patient Name</b></label> <input type="text"
							placeholder="nhập tên" name="patientName" required>
						<label for="email"><b>Sex</b></label> <input type="text"
							placeholder="nhập giới tính" name="sex" required>
					  	<label
							for="email"><b>Birthday</b></label> <input type="date"
							placeholder="Ngày sinh" name="birthDay" required>
						 <label
							for="email"><b>Address</b></label><input type="text"
							placeholder="Địa chỉ" name="address" required>
							<label
							for="email"><b>Phone Number</b></label><input type="text"
							placeholder="số điện thoại" name="phoneNumber" required>

						<div class="clearfix">
							<button type="button"
								onclick="document.getElementById('id01').style.display='none'"
								class="cancelbtn button_popup">Quay lại</button>
							<button type="submit" class="signupbtn button_popup">Thêm</button>
						</div>
					</div>
				</form>
			</div>

			<script>
				// Get the modal
				var modal = document.getElementById('id01');

				// When the user clicks anywhere outside of the modal, close it
				window.onclick = function(event) {
					if (event.target == modal) {
						modal.style.display = "none";
					}
				}
			</script>
			

<jsp:include page="block/block_down.jsp"></jsp:include>