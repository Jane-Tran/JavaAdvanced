
<%@page import="model.bean.BenhAnNamBEAN"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<jsp:include page="block/block_top.jsp"></jsp:include>

<div class="container-fuild phanhienthi">
	<div class="row">
		<div class="col-sm-12">

			<%
				ArrayList<BenhAnNamBEAN> dsBenhAnNam=null;
				if(request.getAttribute("dsBenhAnNam")!=null){
					dsBenhAnNam=(ArrayList<BenhAnNamBEAN>) request.getAttribute("dsBenhAnNam");
				}
				int currentSelectNam = (Integer)(request.getAttribute("currentSelectNam"));
			%>
			<h3 style="text-align: center; color: #0A0A2A; margin-bottom: 30px;">
				<strong>THÔNG TIN BỆNH ÁN</strong>
			</h3>

		
				<form action="" class="row">
				<div class="col-auto my-1">
						<label class="mr-sm-2 sr-only" for="inlineFormCustomSelect">Theo
							năm</label> <select class="custom-select mr-sm-2"
							id="inlineFormCustomSelect" name="txt_nam">
							<option selected value="<%=currentSelectNam%>">Năm: <%=currentSelectNam != -1 ? currentSelectNam : "ALL"%></option>
							<option value="2018">2018</option>
							<option value="2019">2019</option>
							<option value="2020">2020</option>

						</select>
					</div>
				<div class="col-auto my-1">
						<button type="submit" class="btn btn-primary">Báo Cáo</button>
				</div>
				</form>
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
						<th scope="col">Doctor ID</th>
						<th scope="col">Doctor Name</th>
						<th scope="col">Examine Date</th>
						<th scope="col">Result</th>
						<th scope="col">Treatments</th>
					</tr>
				</thead>
				<tbody>
				
					<%	SimpleDateFormat dd= new SimpleDateFormat("dd-MM-yyyy");
					int i=1;
						if(dsBenhAnNam!=null){
							for(BenhAnNamBEAN cd:dsBenhAnNam){
					%>
					<tr>
						<% String date=dd.format(cd.getExamineDate()); %>
						<th scope="row"><%=i%></th>
						<td><%=cd.getPatientID()%></td>
						<td><%=cd.getPatientName() %></td>
						<td><%=cd.getDoctorID()%></td>
						<td><%=cd.getDoctorName()%></td>
						<td><%=date %></td>
						<td><%=cd.getResult()%></td>
						<td><%=cd.getTreatments()%></td>
						
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

<jsp:include page="block/block_down.jsp"></jsp:include>