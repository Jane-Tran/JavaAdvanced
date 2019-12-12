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
	        <a  href="hangController" class="navbar-brand mr-auto mr-lg-0" href="#">Storage</a>
	        <form class="form-inline my-3 my-lg-2 col-lg-8" action="hangController" method="get">
	            <input class="form-control mr-sm-3" type="text" placeholder="Search" aria-label="Search"name="seach" />
	            <button class="btn btn-outline-success my-3 my-sm-0" type="submit" >
	                Search
	            </button>
	        </form>
	    </div>
    </nav>

    <main role="main" class="container pt-5">
        <div class="my-3 p-3 bg-white rounded shadow-sm ">
            <h6 class="border-bottom border-gray pb-2 mb-0"><a href="hangController">Storage</a> > <strong class="text-danger"><%=request.getParameter("tenhang") %></strong></h6>
            <div class="media text-muted pt-3">
                <img class="anh mr-5 " src="image_hang/<%=request.getParameter("anh") %>" width="400" height="400">
                <div class="media-body pb-3 pt-3 mb-0 small lh-125 border-bottom border-gray">
                    <div class="  w-100">
                    	<h2><strong class="text-danger"><%=request.getParameter("tenhang") %></strong></h2> <br/>
                        <strong class="text-gray-dark">Mã hàng :</strong> <strong class="text-danger"><%=request.getParameter("mahang") %></strong>
                       
                    </div>
                    <span class="d-block"><strong class="text-warning">Nhà cung cấp :</strong> <%=request.getParameter("ncc") %></span>
                    <p><strong class="text-gray-dark">Giá:</strong> <%=request.getParameter("gia") %></p>
                    <p><strong class="text-success">Số lượng :</strong><%=request.getParameter("sl") %></p>
                </div>
					<button>Đặt mua</button>
            </div>
        </div>
    </main>
    
</body>

</html>