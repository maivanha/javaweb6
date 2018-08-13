package servletAction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.etity.Product;


@WebServlet("/DeleteOneProduct")
public class DeleteOneProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteOneProduct() {
        super();
        // TODO Auto-generated constructor stub
    }


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		String codeProduct = request.getParameter("codeProduct");
//		System.out.println("code: " + codeProduct);
//		new ProductModel().closeOneProduct(Integer.parseInt(codeProduct));
//		
		HttpSession session = request.getSession();
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		List<Product> list = new ArrayList<>();
		list = (List<Product>) session.getAttribute("dsGioHang");
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCodeProduct() == codeProduct) {
				list.remove(i);
			}
		}
		
		
		if(list.size() == 0) {
			list = null;
		}
		session.setAttribute("dsGioHang", list);
		request.setAttribute("listGioHang", list);
		RequestDispatcher rd = request.getRequestDispatcher("./cart.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
