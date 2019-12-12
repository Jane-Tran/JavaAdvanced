package tranVanQuangHuy.controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tranVanQuangHuy.bean.hangbean;
import tranVanQuangHuy.bo.hangbo;

@WebServlet("/hangController")
public class hangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public hangController() {
        super();
        
    }
    hangbo hbo = new hangbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<hangbean> ds = null;
		String tk = request.getParameter("seach");
		if(tk!=null) {
			ds= hbo.timkey(tk);
		}else
			ds = hbo.getHang();
		request.setAttribute("ds", ds);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
