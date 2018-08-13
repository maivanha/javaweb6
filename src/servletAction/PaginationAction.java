package servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ProductModel;
import model.etity.Product;


@WebServlet("/PaginationAction")
public class PaginationAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public PaginationAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getParameter("page"));
		int pageid = Integer.parseInt(request.getParameter("page"));
		
		int countp = 8;
		
		if(pageid == 1) {
			
		} else {
			pageid = pageid - 1;
			pageid = pageid * countp + 1;
		}
		
		ProductModel pModel = new ProductModel();
		List<Product> dsSanPham = null;
		try {
			dsSanPham = pModel.getPageProduct(pageid - 1, countp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("dsSanPham", dsSanPham);
		
		RequestDispatcher rd = request.getRequestDispatcher("./show/ShowProduct.jsp");
		rd.forward(request, response);
	}

}
