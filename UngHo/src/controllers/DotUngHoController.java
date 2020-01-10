package controllers;


import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.DonViUngHoBEAN;
import model.bean.DotUngHoBEAN;
import model.bo.DonViUngHoBO;
import model.bo.DotUngHoBO;

/**
 * Servlet implementation class DotUngHoController
 */
@WebServlet("/DotUngHoController")
public class DotUngHoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DotUngHoController() {
        super();
        // TODO Auto-generated constructor stub
    }

    DonViUngHoBO dvBO = new DonViUngHoBO();
    DotUngHoBO duhBO = new DotUngHoBO();
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			ArrayList<DonViUngHoBEAN> dv = dvBO.getDVUH();
			
			
			ArrayList<DotUngHoBEAN> duh = duhBO.getListUH();
			
			
			if(request.getParameter("themDotUngHo")!=null) {
				String madotungho = request.getParameter("madotungho");
				String madonviungho = request.getParameter("nguoiungho");
				
				String ngay = request.getParameter("ngayungho");
				java.util.Date d = new SimpleDateFormat("yyyy-MM-dd").parse(ngay);
				Date ngayungho = new Date(d.getTime());
				
				String hinhhthuc = request.getParameter("hinhthuc");
				int soluong = Integer.parseInt(request.getParameter("soluong"));
				String donvi = request.getParameter("donvi");
				boolean kt = duhBO.checkMaDotUngHo(madotungho);
				if(kt) {
					request.setAttribute("kq","loi");
					System.out.println(kt);
					
				}else {
					System.out.println(kt);
					duhBO.addDotUngHo(madotungho, madonviungho, ngayungho, hinhhthuc, soluong, donvi);
					request.setAttribute("kq", "them");
				}
			}
			
			
			request.setAttribute("dv", dv);
			request.setAttribute("duh", duh);
			request.getRequestDispatcher("index.jsp").forward(request, response);
			
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
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
