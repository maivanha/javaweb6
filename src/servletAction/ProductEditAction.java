package servletAction;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import model.ProductModel;
import model.etity.Product;

@WebServlet("/ProductEditAction")
public class ProductEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProductEditAction() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		request.setCharacterEncoding("UTF-8");

		String nameProduct = null;
		int price = 0;
		int numberOfpro = 0;
		String image = null;
		String codeSP = null;
		String codeCompany = null;

		boolean isMultipart = ServletFileUpload.isMultipartContent(request); // bình thường bỏ đi cũng được 
		if(isMultipart){
			FileItemFactory fileItemFactory = new DiskFileItemFactory(); // lấy từ trình duyệt về
			ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);

			List items;
			try {
				items = servletFileUpload.parseRequest(request); // Lấy dữ liệu từ form
				FileItem fItem ;
				for(Object item : items){
					fItem = (FileItem) item;
					if(fItem.isFormField()){
						switch (fItem.getFieldName()) { // Nó có phải form phiu bình thuwongf thì lấy bình thuwongf 
						case "nameProduct":
							nameProduct = fItem.getString("UTF-8");
							break;
						case "price":
							price = Integer.parseInt(fItem.getString()); 
							break;
						case "numberOfpro":
							numberOfpro = Integer.parseInt(fItem.getString());
							break;
						case "codeSP":
							codeSP = fItem.getString("UTF-8");
							break;
						case "codeCompany":
							codeCompany = fItem.getString("UTF-8");
							break;
						default:
							break;
						}
					} else {
						if(fItem.getName() != null && fItem.getName().trim().length() > 0){ // Đường dẫn cứng đến folder chứa file
							//String filePath = getServletContext().getRealPath("/") + "/data/img/smartphone";  // ĐƯờng dẫn này lên tomcat thật
							String filePath = "D:\\Study\\javaCore\\javaWeb1\\WebContent\\data\\img\\smartphone";
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
		Product p = new Product();
		p.setCodeProduct(Integer.parseInt(request.getParameter("codeProduct")));
		p.setNameProduct(nameProduct);
		p.setPrice(price);
		p.setNumberOfpro(numberOfpro);
		p.setImage(image);
		p.setCodeSP(codeSP);
		p.setCodeCompany(codeCompany);
		
		if(image == null) {
			try {
				p.setImage(new ProductModel().getProductById(p.getCodeProduct()).getImage());   
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			p.setImage(image);
		}
		

		try {
			new ProductModel().updateProduct(p);
			response.sendRedirect("./admin.jsp?f=product");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
//		response.setContentType("text/html;charset=UTF-8");
//		request.setCharacterEncoding("utf-8");
//		
//		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
//		int price = Integer.parseInt(request.getParameter("price"));
//		int numberOfpro = Integer.parseInt(request.getParameter("numberOfpro"));
//		
//		String nameProduct = request.getParameter("nameProduct");
//		//String price = request.getParameter("price");
//		//String numberOfpro = request.getParameter("numberOfpro");
//		String image = request.getParameter("image");
//		String codeSP = request.getParameter("codeSP");
//		String codeCompany = request.getParameter("codeCompany");
//		Product p = new Product();
//		
//		p.setCodeProduct(codeProduct);
//		p.setNameProduct(nameProduct);
//		p.setPrice(price);
//		p.setNumberOfpro(numberOfpro);
//		p.setImage(image);
//		p.setCodeSP(codeSP);
//		p.setCodeCompany(codeCompany);
//
//		try {
//			new ProductModel().updateProduct(p);
//			response.sendRedirect("./admin.jsp?f=product");
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}

}
