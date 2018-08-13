package model;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class DemoUpload {
	public static void uploadFile(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// Để khóa final truy cập được vào biến nhưng không thay đổi được giá trị của nó
		final String address = "D:\\Study\\javaCore\\javaWeb1\\WebContent\\data\\img";
		final int MaxMemoryFile = 1024 * 1024 * 3; // 3MB 
		final int MaxRequestSize = 1024 * 1024 * 50; 
		
		// Tạo vùng nhớ tạm 
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		// THiết lập kích thước file
		factory.setSizeThreshold(MaxMemoryFile);
		// Thiết lập chỗ chứa tạm
		factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
		
		// create a new file upload handler // Xử lý nó move file
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//Giới hạn kích thước file upload
		upload.setSizeMax(MaxRequestSize);
		
		// Chứa file vào list rồi mới đứa vào chỗ lưu
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> iter = items.iterator();
		while(iter.hasNext()) {
			FileItem item = iter.next();
			if(!item.isFormField()) {
				String filename = item.getName();
				
				// Vị trí muốn upload file vào
				String partFile = address + File.separator + filename;
				
				File fileupload = new File(partFile);
				
				boolean kt = fileupload.exists();
				
				if(kt == true) {
					request.setAttribute("messenge", "File da ton tai");
				} else {
					item.write(fileupload);
					request.setAttribute("messenge", "Upload thanh cong");
					request.setAttribute("img", address + filename);
				}
				
				
			} else {

				request.setAttribute("messenge", "Upload that bai");
			}
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("./View.jsp");
		
		rd.forward(request, response);
	}
}
