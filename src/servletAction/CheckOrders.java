package servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdersModel;
import model.etity.Orders;


@WebServlet("/CheckOrders")
public class CheckOrders extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CheckOrders() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		List<Orders> list = new ArrayList<>();
		try {
			list = new OrdersModel().getOrderByEmail(email);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("listOrder", list);
		RequestDispatcher rd = request.getRequestDispatcher("./show/CheckOrder.jsp");
		rd.forward(request, response);
		
	}

}
