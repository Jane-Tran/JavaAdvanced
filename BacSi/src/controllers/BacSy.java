package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bean.BenhAnBEAN;
import model.bo.BacSyBO;
import model.bo.BenhAnBO;

/**
 * BacSy
 * 
 * Date: 15-12-2018
 * 
 * Copyright
 * 
 * Modification Logs: DATE AUTHOR DESCRIPTION
 * ------------------------------------- 15-12-2018 NhaHuyen Create
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		ArrayList<BenhAnBEAN> listBenhAn = null;
		BacSyBO bs = new BacSyBO();
		BenhAnBO ba = new BenhAnBO();
		HttpSession session = request.getSession();
		if (session.getAttribute("taikhoan") != null) {
			request.setAttribute("taikhoan", session.getAttribute("taikhoan"));
			try {

				if (request.getParameter("doctorID") != null) {
					String doctorID = request.getParameter("doctorID");
					listBenhAn = ba.getBenhAnTheoBacSy(doctorID);
				} else {
					listBenhAn = ba.getBenhAn();
				}
				request.setAttribute("dsBenhAnTheoBacSy", listBenhAn);
				request.setAttribute("dsBacSy", bs.getBacSy());
				RequestDispatcher rd = request.getRequestDispatcher("BacSy.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			response.sendRedirect("DangNhap");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			if (request.getParameter("xoaBenhAn") != null) {
				BenhAnBO ba = new BenhAnBO();
				String patientID = request.getParameter("xPatientID");
				String doctorID = request.getParameter("xDoctorID");
				String examineDate = request.getParameter("xExamineDate");
				ba.xoaBenhAn(patientID, doctorID, examineDate);
				System.out.println("hihi");
				response.sendRedirect("BacSy");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
