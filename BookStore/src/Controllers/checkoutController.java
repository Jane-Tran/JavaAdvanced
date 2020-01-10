package Controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.bo.giohangbo;
import model.dao.giohangdao;

@WebServlet("/checkoutController")
public class checkoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public checkoutController() {
        super();
    }
    giohangdao ghd = new giohangdao();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			HttpSession session = request.getSession();
			String mkh = (String)session.getAttribute("makh");
			giohangbo ghb = (giohangbo)session.getAttribute("gh");
			if(mkh != null  && ghb != null) {
				int check = ghd.checkout(mkh,ghb.ds);
				if(check==2) {
					response.getWriter().append("Thêm thành công hóa đơn và chi tiết");
					//remove session sau thi dat hang
					session.removeAttribute("gh");
					request.setAttribute("checkout", "1");
				}else
					response.getWriter().append("Thêm ko thành công");
				//System.out.println("hihi");
				RequestDispatcher rd = request.getRequestDispatcher("viewCartController");
				rd.forward(request, response);
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("viewCartController");
				rd.forward(request, response);
				response.getWriter().append("Served at: ").append(request.getContextPath());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
