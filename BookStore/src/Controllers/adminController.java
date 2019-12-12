package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.loaibean;
import model.bo.loaibo;


@WebServlet("/adminController")
public class adminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public adminController() {
        super();
    }
    loaibo lbo = new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String ml = request.getParameter("maloai");
			String tl = request.getParameter("tenloai");
			
			if(request.getParameter("subThem")!=null) {
				int n= lbo.Them(ml, tl);
				if(n!=0)
					request.setAttribute("kt", "them");
			}
			if(request.getParameter("subSua")!=null) {
				int n= lbo.Sua(ml, tl);
				if(n!=0)
					request.setAttribute("kt", "sua");		
			}
			if(request.getParameter("mlXoa")!=null) {
				String mlXoa =request.getParameter("mlXoa");
				int n = lbo.Xoa(mlXoa);
				if(n!=0)
					request.setAttribute("kt", "xoa");
			}
			if(request.getParameter("mlChon")!=null) {
				String mlChon =request.getParameter("mlChon");
				loaibean chonl = lbo.chon(mlChon);
				if(chonl!=null)
					request.setAttribute("chon", chonl);
			
			}
			request.setAttribute("loai", lbo.getLoai());
			RequestDispatcher rd = request.getRequestDispatcher("admin.jsp");
			rd.forward(request, response);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
