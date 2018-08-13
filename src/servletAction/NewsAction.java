package servletAction;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.NewsModel;
import model.etity.News;


@WebServlet("/NewsAction")
public class NewsAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public NewsAction() {
		super();
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2 Dòng dưới để lấy dữ liệu không bị lỗi font chữ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		String action = request.getParameter("action");
		System.out.println(action);
		
		String title = null;
		String image = null;
		String contents = null;
		
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(request); // bình thường bỏ đi cũng được 
		if(isMultipart){
			FileItemFactory fileItemFactory = new DiskFileItemFactory(); // lấy từ trình duyệt về
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

			List items;
			try {
				items = servletFileUpload.parseRequest(request); // Lấy dữ liệu từ form
				FileItem fItem = null;
				for(Object item : items){
					fItem = (FileItem) item;
					if(fItem.isFormField()){
						switch (fItem.getFieldName()) { // Nó có phải form phiu bình thuwongf thì lấy bình thuwongf 
						case "title":
							title = fItem.getString("UTF-8");
							break;
						case "contents":
							contents = fItem.getString("UTF-8");
							break;
						default:
							break;
						}
					} else {
						if(fItem.getName() != null && fItem.getName().trim().length() > 0){ // Đường dẫn cứng đến folder chứa file
							//String filePath = getServletContext().getRealPath("/") + "/data/img/smartphone";  // ĐƯờng dẫn này lên tomcat thật
							String filePath = "D:\\Study\\javaCore\\javaWeb1\\WebContent\\data\\img\\TinTuc";
							File uploadFolder = new File(filePath);
							if(uploadFolder.exists() == false) uploadFolder.mkdirs();
							filePath += "/" + fItem.getName();
							File uploadedFile = new File(filePath);
							fItem.write(uploadedFile);	// Ghi dữ liệu xuống 
							System.out.println(">>>>>> File:" + uploadedFile.getPath());
							image = fItem.getName(); // Cần lấy tên để lưu tên ảnh
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		News n = new News();
		n.setTitle(title);
		n.setContents(contents);
		
		if(image == null) {
			try {
				n.setImage(new NewsModel().getNewById(id).getImage());
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			n.setImage(image);
		}
		
		switch (action) {
		case "insert":
//			System.out.println(n.getTitle());
//			System.out.println(request.getParameter("title"));
//			System.out.println(n.getImage());
			try {
				new NewsModel().insertNews(n);
				response.sendRedirect("./admin.jsp?f=new");
			} catch (SQLException e) {
				e.printStackTrace();
			}
			break;
		case "edit":
			
			n.setCodeNews(id);

			try {
				new NewsModel().updateNews(n);
				response.sendRedirect("./admin.jsp?f=new");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			break;
		default:
			break;
		}




	}
}
