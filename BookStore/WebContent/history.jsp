<%@page import="model.dao.hoadondao"%>
<%@page import="model.bean.hoadonbean"%>
<%@page import="model.bean.giohangbean"%>
<%@page import="model.bo.giohangbo"%>
<%@page import="model.bean.loaibean"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.sachdao"%>
<%@page import="model.bean.sachbean"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <title>Book</title>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="description" content="OneTech shop project">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.11.2/css/all.min.css" rel="stylesheet"
        type="text/css">
    <link rel="stylesheet" type="text/css" href="css/shop_styles.css">
    <link rel="stylesheet" type="text/css" href="css/shop_reponsive.css">
    <link rel="stylesheet" type="text/css" href="css/cart.css">
</head>

<body>
<%
giohangbo gh=(giohangbo)session.getAttribute("gh");
int count=0;
long total=0;
int viewid=0;
try{
	count=gh.Count();
	total=gh.Sum();
}catch(Exception e){
	
}%>
    <div class="super_container">
        <!-- Header -->
        <header class="header">
            <!-- Main Navigation -->

            <nav class="main_nav">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="main_nav_content d-flex flex-row">
                                <!-- Main Nav Menu -->
                                <div class="main_nav_menu ml-auto">
                                    <ul class="standard_dropdown main_nav_dropdown">
                                        <li><a href="#">Home<i class="fas fa-chevron-down"></i></a></li>
                                        <li><a href="#">Blog<i class="fas fa-chevron-down"></i></a></li>
                                        <li><a href="#">Contact<i class="fas fa-chevron-down"></i></a></li>
                                    </ul>
                                </div>
                                <!-- Menu Trigger -->
                                <div class="menu_trigger_container ml-auto">
                                    <div class="menu_trigger d-flex flex-row align-items-center justify-content-end">
                                        <div class="menu_burger">
                                            <div class="menu_trigger_text">menu</div>
                                            <div class="cat_burger menu_burger_inner">
                                                <span></span><span></span><span></span></div>
                                        </div>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
                </div>
            </nav>
            <!-- Header Main -->
            <div class="header_main">
                <div class="container">
                    <div class="row">
                        <!-- Logo -->
                        <div class="col-lg-2 col-sm-3 col-3 order-1">
                            <div class="logo_container">
                                <div class="logo"><a href="sachController">BookStore</a></div>
                            </div>
                        </div>

                        <!-- Search -->
                        <div class="col-lg-6 col-12 order-lg-2 order-3 text-lg-left text-right">
                            <div class="header_search">
                                <div class="header_search_content">
                                    <div class="header_search_form_container">
                                        <form action="#" class="header_search_form clearfix">
                                            <input type="search" required="required" class="header_search_input"
                                                placeholder="Search for products...">
                                            
                                            <button type="submit" class="header_search_button trans_300"
                                                value="Submit"><img src="images/search.png" alt=""></button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Wishlist -->
                        <div class="col-lg-4 col-9 order-lg-3 order-2 text-lg-left text-right">
                            <div class="wishlist_cart d-flex flex-row align-items-center justify-content-end">
                                <div class="wishlist d-flex flex-row align-items-center justify-content-end">
                                <%if(session.getAttribute("hoten")!=null){ %>
                                <div class="user_icon mr-5 " data-toggle="dropdown"><img src="images/user.svg"  alt="account"><%=session.getAttribute("hoten") %></div>
                                <div class="dropdown-menu ">
			                        <a href="historyController"class="dropdown-item"><i class="fas fa-scroll"></i> History buy</a>
			                        <div class="dropdown-divider"></div>
			                        <a href="logoutController"class="dropdown-item"> <i class="fas fa-sign-out-alt"></i> Logout</a>
			                    </div>
                                <%} else { %>
                                    <div class="top_bar_user">
                                        <div class="user_icon"><img src="images/user.svg" alt=""></div>
                                        <div><a href="#">Register</a></div>
                                        <div><a href="#myModal"class="trigger-btn" data-toggle="modal">Sign in</a></div>
                                    </div>
                                <%} %>
                                </div>
                                <!-- Cart -->
                                <div class="cart">
                                    <div class="cart_container d-flex flex-row align-items-center justify-content-end">
                                        <div class="cart_icon">
                                            <img src="images/cart.png" alt="">
                                            <div class="cart_count"><span><%=session.getAttribute("gh")==null?0:count%></span></div>
                                        </div>
                                        <div class="cart_content">
                                            <div class="cart_text"><a href="#">Cart</a></div>
                                            <div class="cart_price" style="font-size:10px"><%=session.getAttribute("gh")==null?0:total%> đ</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>
            </div>

            <!-- Menu -->

            <div class="page_menu">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="page_menu_content">
                                <div class="page_menu_search">
                                    <form action="sachController">
                                        <input type="search" required="required" class="page_menu_search_input"
                                            placeholder="Search for products...">
                                    </form>
                                </div>
                                <ul class="page_menu_nav">
                                    <li class="page_menu_item">
                                        <a href="#">Home<i class="fa fa-angle-down"></i></a>
                                    </li>
                                    <li class="page_menu_item"><a href="#">blog<i
                                                class="fa fa-angle-down"></i></a></li>
                                    <li class="page_menu_item"><a href="#">contact<i
                                                class="fa fa-angle-down"></i></a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </header>

        <!-- Home -->

        <div class="home">
            <div class="home_background parallax-window" data-parallax="scroll"
                data-image-src="images/shop_background.jpg"><img alt="" src="images/shop_background.jpg"></div>
            <div class="home_overlay"></div>
        </div>
  	</div>
        <!-- Cart -->
	<div class="cart_section">
		<div class="container">
			<div class="row">
				<div class="col-lg-10 offset-lg-1">
					<div class="cart_container">
						<div class="cart_title">History Buy</div>
							<div class="row">							        
						        <div class="col-md-12">
						        	
						        	<div class="table-responsive">
									    <%	ArrayList<hoadonbean> dshd = new ArrayList<hoadonbean>();
									    if(request.getAttribute("dshd")!= null && !request.getAttribute("dshd").equals(dshd) ){
									    	dshd = (ArrayList<hoadonbean>)request.getAttribute("dshd");
									    	%>
									    
						            <table id="mytable" class="table table-bordred table-striped">
						            	<thead>
						                    <th>
						                    	<input type="checkbox" id="checkall" />
						                    </th>
						                    <th>#ID Hóa đơn</th>
						                    <th>Ngày mua</th>
						                    <th>Tình trạng</th>
						                    <th>Edit</th>
						                    <th>Delete</th>
						                </thead>
									    <tbody>
									    	<%for(hoadonbean hoadon : dshd ){ %>
										    <tr>
											    <td>
											    	<input type="checkbox" class="checkthis" />
											    </td>
											    <td>#<%=hoadon.getMahoadon() %></td>
											    <td><%=hoadon.getNgaymua() %></td>
											    <td><%=hoadon.isDamua()==true?"Đã thanh toán":"Đang chờ duyệt"%></td>
											    <td><button onclick="<%=viewid=hoadon.getMahoadon()%>" type="button" class="btn btn-info" data-toggle="modal" data-target="#classModal"><i class="far fa-eye"></i></button></td>
											    <td><button type="button" class="btn btn-danger"><i class="fas fa-trash-alt"></i></button></td>
										    </tr>
										    <%} %>
									    </tbody>
									</table>
									 <%}else{ %>
										<hr>
									 	<h2> Bạn chưa có hóa đơn nào được lập </h2>
									 <%} %>
				            	</div>
				        	</div>
						</div>
					</div>	
				</div>
			</div>
		</div>
	</div>

    <!-- Copyright -->

    <div class="copyright">
        <div class="container">
            <div class="row">
                <div class="col">
                    <div
                        class="copyright_container d-flex flex-sm-row flex-column align-items-center justify-content-start">
                        <div class="copyright_content">
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                            Copyright &copy;
                            <script>document.write(new Date().getFullYear());</script> All rights reserved | This
                            template is made with <i class="fa fa-heart" aria-hidden="true"></i> by <a href="#"
                                target="_blank">Bug</a>
                            <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        </div>
                        <div class="logos ml-sm-auto">
                            <ul class="logos_list">
                                <li><a href="#"><img src="images/logos_1.png" alt=""></a></li>
                                <li><a href="#"><img src="images/logos_2.png" alt=""></a></li>
                                <li><a href="#"><img src="images/logos_3.png" alt=""></a></li>
                                <li><a href="#"><img src="images/logos_4.png" alt=""></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
	<!--Modal Table -->
	<div id="classModal" class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="classInfo" aria-hidden="true">
	  <div class="modal-dialog modal-lg">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
	          ×
	        </button>
	        <h4 class="modal-title" id="classModalLabel">
	              Class Info
	         </h4>
	      </div>
	      <div class="modal-body" style="overflow-x: auto;">
	        <table id="classTable" class="table table-bordered">
	          <thead>
	          </thead>
	          <tbody>
	            <tr>
	              <th></th>
	              <th>Name</th>
	              <th>Quantity</th>
	              <th>Price</th>
	              <th>Total</th>
	            </tr>
	            <%if(viewid !=0){
	            	hoadondao hdd = new hoadondao();
	            	ArrayList<giohangbean> dsg = new ArrayList<giohangbean>();
	            	String id = String.valueOf(viewid);
	            	dsg= hdd.getChiTietHoaDon(id);
	            	for(giohangbean ct:dsg){
	           	%>
	            <tr>
	              <td><img alt="" src="<%=ct.getAnh()%>" width="80px" height="100px"></td>
	              <td><%=ct.getTensach() %></td>
	              <td><%=ct.getSoluong() %></td>
	              <td><%=ct.getGia()%></td>
	              <td><%=ct.getThanhtien() %></td>
	            </tr>
	            <%}} %>
	          </tbody>
	        </table>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-primary" data-dismiss="modal">
	          Close
	        </button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="js/history.js"></script>
    <script type="text/javascript">
    function view(id) {
    	$.ajax(
	    {
    		url : "historyController",
    		type : "post", 
	    });
    	
    }
    	
    
    </script>
</body>

</html>