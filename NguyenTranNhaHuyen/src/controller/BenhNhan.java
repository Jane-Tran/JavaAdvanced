package controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bo.BenhNhanBO;

/**
 * BenhNhan
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
@WebServlet("/BenhNhan")
public class BenhNhan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BenhNhan() {
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
		BenhNhanBO bn=new BenhNhanBO();
		HttpSession session=request.getSession();
		if(session.getAttribute("taikhoan")!=null) {
			request.setAttribute("taikhoan", session.getAttribute("taikhoan"));
			try { 
				if(request.getParameter("patientName")!=null) {
					String patientID=request.getParameter("patientID");	
					String patientName=request.getParameter("patientName");
					SimpleDateFormat dd=new SimpleDateFormat("yyyy-MM-dd");
					Date birthDay =dd.parse(request.getParameter("birthDay"));
					String sex=request.getParameter("sex");
					String address=request.getParameter("address");
					String phoneNumber=request.getParameter("phoneNumber");
					bn.themBenhNhan(patientID, patientName, sex, birthDay, address, phoneNumber);
				}
				request.setAttribute("dsBenhNhan", bn.getBenhNhan());
			} catch (Exception e) {
				// TODO: handle exception
			}
		
			RequestDispatcher rd = request.getRequestDispatcher("BenhNhan.jsp");
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
