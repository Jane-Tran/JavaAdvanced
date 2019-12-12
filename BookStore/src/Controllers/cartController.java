package Controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.giohangbo;

@WebServlet("/cartController")
public class cartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public cartController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String ms = request.getParameter("masach");
		String ts = request.getParameter("tensach");
		String anh = request.getParameter("anh");
		String tam = request.getParameter("gia") ;
		long gia = 0;
		giohangbo gh = null;
		if(tam!=null) {
			gia = Long.parseLong(tam);
			if(session.getAttribute("gh")==null) {
				gh = new giohangbo();
				session.setAttribute("gh", gh);
			}
			gh=(giohangbo)session.getAttribute("gh");
			gh.Add(ms, ts, anh, gia, (int)1);
			session.setAttribute("gh", gh);
		}
		response.sendRedirect("sachController");
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
