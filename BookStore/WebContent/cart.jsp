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
			                        <a href="logoutController"class="dropdown-item">Logout</a>
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
                                    <form action="#">
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
							<div class="cart_title">Shopping Cart</div>
							<div class="cart_items">
								<%if(gh !=null){ %>
								<ul class="cart_list">
									<li class="cart_item clearfix" style="background: linear-gradient( #0e8ce470,#f8f9fa)">
											<div class="cart_item_image_title" style="width: 133px;float: left;height: 10px;"></div>
											<div
											class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
											<div class="cart_item_name cart_info_col">
												<div class="cart_item_title">Name</div>
											</div>
											
											<div class="cart_item_quantity cart_info_col">
												<div class="cart_item_title">Quantity</div>
											</div>
											
											<div class="cart_item_price cart_info_col">
												<div class="cart_item_title">Price</div>
											</div>
											<div class="cart_item_total cart_info_col">
												<div class="cart_item_title">Total</div>
											</div>
										</div>
										
									</li>
									<hr><hr>
									<% for(giohangbean g:gh.ds){%>
									<li class="cart_item clearfix">
										<div class="cart_item_image"><img src="<%=g.getAnh() %>" alt=""></div>
											<div
											class="cart_item_info d-flex flex-md-row flex-column justify-content-between">
											<div class="cart_item_name cart_info_col">
												<div class="cart_item_text"><%=g.getTensach() %></div>
											</div>
											
											<div class="cart_item_quantity cart_info_col">
												<div class="cart_item_text"><%=g.getSoluong() %></div>
											</div>
											
											<div class="cart_item_price cart_info_col">
												<div class="cart_item_text"><%=g.getGia()%> đ</div>
											</div>
											<div class="cart_item_total cart_info_col">
												<div class="cart_item_text"><%=g.getThanhtien()%> đ</div>
											</div>
										</div>
									</li>
									<hr>
								</ul>
									<%}}else { %>
									<h2>Giỏ hàng trống !!!</h2>
									<%} %>
							</div>

							<!-- Order Total -->
							<div class="order_total">
								<div class="order_total_content text-md-right">
									<div class="order_total_title">Order Total:</div>
									<div class="order_total_amount"><%=total%> đ</div>
								</div>
							</div>

							<div class="cart_buttons">
								<button type="button" class="button cart_button_clear">Update Cart</button>
								<a 
									<%if(session.getAttribute("makh")==null){ %> 
										href="#myModal" data-toggle="modal"
									<%} else{ %> 
									href="checkoutController"
									<%} %>
								type="button" class="button cart_button_checkout">
								Proceed to ordering
								</a>
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
    
	<!-- Modal HTML -->
	<div id="myModal" class="modal fade">
		<div class="modal-dialog modal-login">
			<div class="modal-content">
				<div class="modal-header">			
					<h2 class="modal-title">Member Login</h2>	
	                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
				</div>
				<div class="modal-body">
					<form action="loginController" method="post">
						<div class="form-group">
							<input type="text" class="form-control" name="username" placeholder="Username" required="required">		
						</div>
						<div class="form-group">
							<input type="password" class="form-control" name="password" placeholder="Password" required="required">	
						</div>        
						<div class="form-group">
							<button type="submit" class="btn btn-primary btn-lg btn-block login-btn">Login</button>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<a href="#">Forgot Password?</a>
				</div>
			</div>
		</div>
	</div> 
    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"></script>
    <script src="js/shop_custom.js"></script>
</body>

</html>