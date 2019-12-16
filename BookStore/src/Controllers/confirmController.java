package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.bo.hoadonbo;

@WebServlet("/confirmController")
public class confirmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public confirmController() {
        super();
    }
    hoadonbo hdb = new hoadonbo();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String mhd = request.getParameter("Duyet");
			if(mhd!=null) {
				hdb.confirm(mhd);
				response.sendRedirect("confirmController");
			}else {
			request.setAttribute("confirm",hdb.getHoaDon());
			RequestDispatcher rd = request.getRequestDispatcher("confirm.jsp");
			rd.forward(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
