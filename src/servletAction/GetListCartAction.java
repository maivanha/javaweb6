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

/**
 * Servlet implementation class GetListCartAction
 */
@WebServlet("/GetListCartAction")
public class GetListCartAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetListCartAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		List<Product> list = new ArrayList<>();
		if(session.getAttribute("dsGioHang") == null || session.getAttribute("dsGioHang").toString().length() == 0) {
			list = null;
			request.setAttribute("listGioHang", list);
			RequestDispatcher rd = request.getRequestDispatcher("./cart.jsp");
			rd.forward(request, response);
		} else {
			list = (List<Product>) session.getAttribute("dsGioHang");

			request.setAttribute("listGioHang", list);
			RequestDispatcher rd = request.getRequestDispatcher("./cart.jsp");
			rd.forward(request, response);
		}
	
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
