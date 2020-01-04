package Controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


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
			
			DiskFileItemFactory fileItemFactory = new DiskFileItemFactory();
			ServletFileUpload upload = new ServletFileUpload(fileItemFactory);
			//String dirUrl1 = request.getServletContext().getRealPath("")+File.separator+ "image_sach";
			
			//response.getWriter().println(dirUrl1);
			String ms = request.getParameter("masach");
			String ts = request.getParameter("tensach");
			long sl = 0,g=0;
			if(request.getParameter("soluong")!=null && request.getParameter("gia")!=null){
				 sl = Long.parseLong(request.getParameter("soluong"));
				 g = Long.parseLong(request.getParameter("gia"));
			};
			String ml = request.getParameter("maloai");
			String st = request.getParameter("sotap");
			
			String tg = request.getParameter("tacgia");
			String time = request.getParameter("ngaynhap");
			//System.out.println(time);
		
				Date nn = null;
				if(time!=null) {
					nn = Date.valueOf(time);
				}
				if(request.getParameter("btnThem")!=null) {
					//System.out.println(ms+ts+sl+g+ml+st+anh+nn+tg);
					
					List<FileItem> fileItems = upload.parseRequest(request);//Lấy về các đối tượng gửi lên
					String anh = request.getParameter("anh");
					//duyệt qua các đối tượng gửi lên từ client gồm file và các control
					int n= sbo.Them(ms,ts,sl,g,ml,st,anh,nn,tg);
					for (FileItem fileItem : fileItems) {
						if (!fileItem.isFormField()) {//Nếu ko phải các control=>upfile lên
						// xử lý file
						String nameimg = fileItem.getName();
						if (!nameimg.equals("")) {
					           //Lấy đường dẫn hiện tại, chủ ý xử lý trên dirUrl để có đường dẫn đúng
							String dirUrl = request.getServletContext().getRealPath("/image_sach") ;
							System.out.println(dirUrl);
							File dir = new File(dirUrl);
							if (!dir.exists()) {//nếu ko có thư mục thì tạo ra
								dir.mkdir();
							}
						           String fileImg = dirUrl + File.separator + nameimg;
						           File file = new File(fileImg);//tạo file
						            try {
						               fileItem.write(file);//lưu file
						              System.out.println("UPLOAD THÀNH CÔNG...!");
						              System.out.println("Đường dẫn lưu file là: "+dirUrl);
						            } catch (Exception e) {
						            	e.printStackTrace();
						            }
							}
					}
					else//Neu la control
					{
						String tentk=fileItem.getFieldName();
						if(tentk.equals("txthoten"))
							response.getWriter().println(fileItem.getString());
						if(tentk.equals("txtdiachi"))
							response.getWriter().println(fileItem.getString());
					}
					}

					if(n!=0)
						request.setAttribute("kt", "them");
				}
				if(request.getParameter("btnSua")!=null) {
					String anh = request.getParameter("anh");
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
