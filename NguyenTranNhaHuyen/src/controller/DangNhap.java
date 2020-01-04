package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.TaiKhoanBO;

/**
 * DangNhap
 * 
 * Date: 15-12-2018
 * 
 * Copyright
 * 
 * Modification Logs:
 * DATE			AUTHOR		DESCRIPTION
 * -------------------------------------
 * 15-12-2018	NhaHuyen		Create
 */
@WebServlet("/DangNhap")
public class DangNhap extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DangNhap() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			TaiKhoanBO tk = new TaiKhoanBO();
			HttpSession session = request.getSession();
			if(session.getAttribute("taikhoan")!=null) {
				response.sendRedirect("BenhNhan");
			}else {
				String adname=request.getParameter("adname");
				String pass=request.getParameter("pass");
				if(tk.kTDangNhap(adname, pass)!=null) {
					session.setAttribute("taikhoan", tk.kTDangNhap(adname, pass));
					request.setAttribute("taikhoan", tk.kTDangNhap(adname, pass));
					response.sendRedirect("BenhNhan");
				}
			}
			if(request.getParameter("logout")!=null) {
				session.removeAttribute("taikhoan");
				
			}
			RequestDispatcher rd=request.getRequestDispatcher("DangNhap.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
