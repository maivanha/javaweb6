package servletAction;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.etity.Product;


@WebServlet("/ChangeCountBuy")
public class ChangeCountBuy extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public ChangeCountBuy() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		int countBuy = Integer.parseInt(request.getParameter("countBuy"));
		
		System.out.println(codeProduct + "    " + countBuy);
		HttpSession session = request.getSession();
		List<Product> list =  (List<Product>) session.getAttribute("dsGioHang");
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getCodeProduct() == codeProduct) {
				list.get(i).setCountbuy(countBuy);
			}
		}
		
		session.setAttribute("dsGioHang", list);
		request.setAttribute("listGioHang", list);
		RequestDispatcher rd = request.getRequestDispatcher("./cart.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
