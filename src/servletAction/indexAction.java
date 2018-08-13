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


@WebServlet("/indexAction")
public class indexAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public indexAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductModel pModel = new ProductModel();
		try {
			List<Product> dsSanPham = pModel.getProduct();
			request.setAttribute("dsSanPham", dsSanPham);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		<%/* %>
//		
//		<c:forEach items="${requestScope.dsSanPham}" var="sp">
//			<div class="boxSanPham">
//				<a href="#" title="${sp.nameProduct}">
//					<div class="boxImageSP">
//						<img src="${sp.image}">
//					</div>
//					<h3><c:out value ="${sp.nameProduct}"></c:out></h3>
//					
//					<h5><c:out value ="${sp.price}"></c:out></h5>
//				</a>
//				<div class="butMuaNgay">
//					<a href="./BuyProduct?codeProduct=${sp.codeProduct}"><b> Mua ngay </b></a>
//				</div>
//			</div>
//		</c:forEach>
//		<%*/ %>
	}

}
