<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<jsp:include page="component/header.jsp"></jsp:include>
<jsp:include page="component/sidebarANDnav.jsp"></jsp:include>
<div class="container-fuild phanhienthi">
	<div class="row">
		<div class="col-sm-12">
			<h3 style="Text-align: center; color: #0A0A2A; margin-bottom: 30px;margin-top:20px">
				<strong>DANH SÁCH </strong>
			</h3>
			<jsp:include page="component/seach.jsp"></jsp:include>
		</div>
	</div>
</div>
<jsp:include page="component/table.jsp"></jsp:include>
<jsp:include page="component/scriptANDfooter.jsp"></jsp:include>