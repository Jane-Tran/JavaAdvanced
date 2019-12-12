<%@page import="tranVanQuangHuy.bean.hangbean"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
pageEncoding="utf-8"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors" />
    <meta name="generator" content="Jekyll v3.8.5" />
    <title>Kiem Tra</title>

    <!-- Bootstrap core CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" />

    <!-- Custom styles for this template -->
    <link href="css/style.css" rel="stylesheet" />
</head>

<body class="bg-light">
    <nav class="navbar navbar-expand-lg fixed-top navbar-dark bg-dark">
    	<div class='container'>
	        <a href="hangController" class="navbar-brand mr-auto mr-lg-0" href="#">Storage</a>
	        <form class="form-inline my-3 my-lg-2 col-lg-8">
	            <input class="form-control mr-sm-3" type="text" placeholder="Search" aria-label="Search" name="seach"/>
	            <button class="btn btn-outline-success my-3 my-sm-0" type="submit">
	                Search
	            </button>
	        </form>
	    </div>
    </nav>

    <main role="main" class="container">
        <div class="d-flex align-items-center p-3 my-3 text-white-50 bg-purple rounded shadow-sm">
             <div class="lh-100">
                <h6 class="mb-0 text-white lh-100 ">Kho hàng</h6>
                <small>Since 2020</small>
            </div>
        </div>
        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h2 class="border-bottom border-gray pb-2 mb-0">Danh sách Hàng</h2>
            <%
            ArrayList<hangbean> ds= new ArrayList<hangbean>();
			ds= (ArrayList<hangbean>)request.getAttribute("ds");
    		int hangsize=ds.size();
    		if(hangsize>0){
				for(int i=0;i<hangsize;i++){
					hangbean h=ds.get(i);%>
		            <div class="media text-muted pt-3">
		                <img class="anh mr-3 " src="image_hang/<%=h.getAnh() %>" width="100" height="100">
		                <div class="media-body pb-3 mb-0 pt-4 small lh-125 border-bottom border-gray">
		                    <div class="d-flex justify-content-between align-items-center w-100">
		                        <strong class="text-danger"><%=h.getMahang() %></strong>
		                        <a class="chitiet" href="detailController?mahang=<%=h.getMahang() %>&tenhang=<%=h.getTenhang() %>&ncc=<%=h.getNhacungcap()%>&sl=<%=h.getSoluong() %>&gia=<%=h.getGia() %>&anh=<%=h.getAnh() %>">
		                        	Chi tiết
		                        </a>
		                    </div>
		                    <span class="d-block"><%=h.getTenhang() %></span>
		                </div>
		            </div>
	            <%}
				
    		}else{ %>
	            	<h3 class="text-danger">Mặt hàng này không tồn tại !</h3>
	            <%} %>
            
        </div>
    </main>
    
    
</body>

</html>