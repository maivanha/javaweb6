package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductTypeModel;
import model.etity.ProductType;

@WebServlet("/ProductTypeAction")
public class ProductTypeAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductTypeAction() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String codeSP = request.getParameter("codeSP");

		if(action.equals("delete")) {
			try {
				new ProductTypeModel().deleteCompany(codeSP);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("./admin.jsp?f=ProductType");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2 Dòng dưới để lấy dữ liệu không bị lỗi font chữ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
				
		String codeSP = request.getParameter("codeSP");
		String nameSP = request.getParameter("nameSP");
		
		ProductType pt = new ProductType();
		pt.setCodeSP(codeSP);
		pt.setNameSP(nameSP);
		
		try {
			new ProductTypeModel().insertCompany(pt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("./admin.jsp?f=ProductType");
	}

}
