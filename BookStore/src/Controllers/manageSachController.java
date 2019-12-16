package Controllers;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bean.sachbean;
import model.bo.loaibo;
import model.bo.sachbo;


@WebServlet("/manageSachController")
public class manageSachController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public manageSachController() {
        super();
    }
    sachbo sbo = new sachbo();
    loaibo lbo = new loaibo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String ms = request.getParameter("masach");
			String ts = request.getParameter("tensach");
			long sl = 0,g=0;
			if(request.getParameter("soluong")!=null && request.getParameter("gia")!=null){
				 sl = Long.parseLong(request.getParameter("soluong"));
				 g = Long.parseLong(request.getParameter("gia"));
			};
			String ml = request.getParameter("maloai");
			String st = request.getParameter("sotap");
			String anh = request.getParameter("anh");
			String tg = request.getParameter("tacgia");
			String time = request.getParameter("ngaynhap");
			//System.out.println(time);
		
				Date nn = null;
				if(time!=null) {
					nn = Date.valueOf(time);
				}
				if(request.getParameter("btnThem")!=null) {
					//System.out.println(ms+ts+sl+g+ml+st+anh+nn+tg);
					int n= sbo.Them(ms,ts,sl,g,ml,st,anh,nn,tg);
					if(n!=0)
						request.setAttribute("kt", "them");
				}
				if(request.getParameter("btnSua")!=null) {
					int n= sbo.Sua(ms,ts,sl,g,ml,st,anh,nn,tg);
					if(n!=0)
						request.setAttribute("kt", "sua");		
				}
				if(request.getParameter("msXoa")!=null) {
					String msXoa =request.getParameter("msXoa");
					int n = sbo.Xoa(msXoa);
					if(n!=0)
						request.setAttribute("kt", "xoa");
				}
				if(request.getParameter("msChon")!=null) {
					String msChon =request.getParameter("msChon");
					sachbean chonl = sbo.Chon(msChon);
					if(chonl!=null)
						request.setAttribute("chon", chonl);
				
				}
			
			
			request.setAttribute("sach", sbo.getSach());
			request.setAttribute("loai", lbo.getLoai());
			RequestDispatcher rd = request.getRequestDispatcher("manageSach.jsp");
			rd.forward(request, response);
			response.getWriter().append("Served at: ").append(request.getContextPath());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
