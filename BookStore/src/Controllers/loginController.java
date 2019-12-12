package Controllers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.khachhangbean;
import model.bo.khachhangbo;


@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public loginController() {
        super();
       
    }
	
    khachhangbo khbo = new khachhangbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String un = request.getParameter("username");
			String pw = request.getParameter("password");
			if(un!=null && pw !=null) {
				khachhangbean kh =  (khachhangbean)khbo.Authentication(un, pw);
				if(kh!=null) {
					HttpSession session = request.getSession();
					session.setAttribute("makh", kh.getMakh());
					session.setAttribute("hoten", kh.getName());
				}
				response.sendRedirect("sachController");
//				RequestDispatcher rd = request.getRequestDispatcher("sachController");
//				rd.forward(request, response);
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
