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

import bo.BacSyBO;
import bo.BenhAnBO;

/**
 * BacSy
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
@WebServlet("/BacSy")
public class BacSy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BacSy() {
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
		BacSyBO bs=new BacSyBO();
		BenhAnBO ba=new BenhAnBO();
		HttpSession session=request.getSession();
		if(session.getAttribute("taikhoan")!=null) {
			request.setAttribute("taikhoan", session.getAttribute("taikhoan"));
			try {
				request.setAttribute("dsBenhAnTheoBacSy", ba.getBenhAn());	
				if(request.getParameter("doctorID")!=null) {
					String doctorID = request.getParameter("doctorID");
					request.setAttribute("dsBenhAnTheoBacSy", ba.getBenhAnTheoBacSy(doctorID));
				}
				if(request.getParameter("xoa")!=null) {
					String patientID=request.getParameter(request.getParameter("patientID"));
					String doctorID=request.getParameter(request.getParameter("doctorID"));
					String dd=request.getParameter("examineDate");
					Date examineDate = new SimpleDateFormat("yyyy-MM-dd").parse(dd);
					ba.xoaBenhAn(patientID, doctorID,examineDate);
				}
				request.setAttribute("dsBacSy", bs.getBacSy());
				RequestDispatcher rd = request.getRequestDispatcher("BacSy.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				// TODO: handle exception
			}
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
