package Controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.loaibean;
import model.bean.sachbean;
import model.bo.loaibo;
import model.bo.sachbo;


@WebServlet("/sachController")
public class sachController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public sachController() {
        super();
    }
    
    sachbo sbo = new sachbo();
    loaibo lbo = new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		//tìm kiếm 
		String tk = request.getParameter("seach");
		//get loai
		ArrayList<loaibean> loai = lbo.getLoai();
		request.setAttribute("loai", loai);
		//get sach
		String ml = request.getParameter("maloai");
		ArrayList<sachbean> ds = null;
		
		if(tk !=null || ml != null) {
			if(tk != null) {
				ds=sbo.timkey(tk);
			}
			if(ml != null) {
				ds = sbo.timsach(ml);
			}
		}else
			ds = sbo.getSach();
		
		request.setAttribute("ds", ds);
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
