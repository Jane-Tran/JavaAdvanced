package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BenhAnNamBO;

/**
 * BenhAnNam
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
@WebServlet("/BenhAnNam")
public class BenhAnNam extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenhAnNam() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		BenhAnNamBO ban=new BenhAnNamBO();
		HttpSession session=request.getSession();
		if(session.getAttribute("taikhoan")!=null) {
			request.setAttribute("taikhoan", session.getAttribute("taikhoan"));
			try {
				request.setAttribute("dsBenhAnNam", ban.getBenhAnNam());
				request.setAttribute("currentSelectNam", -1);
				int nam = Integer.parseInt(request.getParameter("txt_nam"));
				request.setAttribute("currentSelectNam", nam);
			} catch (Exception e) {
				// TODO: handle exception
			}
			RequestDispatcher rd = request.getRequestDispatcher("BenhAnNam.jsp");
			rd.forward(request, response);
		}else {
			response.sendRedirect("DangNhap");
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
