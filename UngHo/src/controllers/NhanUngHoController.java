package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.NhanUngHoBEAN;
import model.bo.NhanUngHoBO;

/**
 * Servlet implementation class NhanUngHoController
 */
@WebServlet("/NhanUngHoController")
public class NhanUngHoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NhanUngHoController() {
        super();
        // TODO Auto-generated constructor stub
    }
    NhanUngHoBO nuhBO = new NhanUngHoBO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		if(request.getParameter("xoaNhanUngHo")!=null) {
			String ma = request.getParameter("xMaDotNhanUngHo");
			nuhBO.deleteNUH(ma);
			System.out.println(ma);
		}
		ArrayList<NhanUngHoBEAN> nuh = nuhBO.getListNUH();
		request.setAttribute("nuh", nuh);
		RequestDispatcher rd = request.getRequestDispatcher("nhanungho.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
