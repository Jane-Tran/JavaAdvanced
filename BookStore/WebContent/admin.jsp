<%@page import="model.bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Book</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="OneTech shop project">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet"
        type="text/css">
</head>
<body>


<div class = "container">
<br><br><br>
<% loaibean lc = (loaibean)request.getAttribute("chon"); %>
<div class ="card card-body">
<form action="adminController" method="get">
  <div class="form-group">
    <label>Mã loại</label>
    <input type="text" class="form-control" placeholder="maloai" name="maloai"value="<%=lc!=null?lc.getMaloai():""%>">
  </div>
  <div class="form-group">
    <label>Tên loại</label>
    <input type="text" class="form-control" placeholder="tenloai" name="tenloai" value="<%=lc!=null?lc.getTenloai():""%>">
  </div>
  <input type="submit" class="btn btn-primary" name="subThem" value="Thêm">
  <input type="submit" class="btn btn-warning" name="subSua" value="Sửa">
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
   		<h3 class="card-title">Danh sách loại</h3>
         <div class="col-md-12">
             <input class="form-control" type="text" placeholder="Filter Users...">
         </div>
   </div>
   <br>
   <table class="table table-striped table-hover">
         <tr>
           <th>Mã loại</th>
           <th>Tên loại</th>
           <th>Xử lý</th>
           
         </tr>
         <%
			ArrayList<loaibean> loai=new ArrayList<loaibean>();
			loai=(ArrayList<loaibean>)request.getAttribute("loai");
			int loaisize=loai.size();
			for(int i=0;i<loaisize;i++){
				loaibean ll=loai.get(i);
				%>
         <tr>
           <td><%=ll.getMaloai() %></td>
           <td><%=ll.getTenloai()%></td>
           <td>
           		<a class="btn btn-info" href="adminController?mlChon=<%=ll.getMaloai()%>">Chọn</a> 
           		<a class="btn btn-danger" href="adminController?mlXoa=<%=ll.getMaloai()%>">Xóa</a>
           	</td>
         </tr>
         
       <%} %>
       </table>
 </div>
 </div>
</body>
</html>