package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.hoadonbo;


@WebServlet("/historyController")
public class historyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public historyController() {
        super();
    }

    hoadonbo hdb = new hoadonbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String mkh = (String)session.getAttribute("makh");
		String viewid = request.getParameter("viewid");
		if(mkh != null){
			if(hdb.getHoaDon(mkh)!=null)
				request.setAttribute("dshd", hdb.getHoaDon(mkh));
		}
		RequestDispatcher rd = request.getRequestDispatcher("history.jsp");
		rd.forward(request, response);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
