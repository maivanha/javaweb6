package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.OrdersModel;

@WebServlet("/OrderDeleteAction")
public class OrderDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public OrderDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int codeOrder = Integer.parseInt(request.getParameter("codeOrder"));
		
		//OrdersModel oModel = new OrdersModel();
		
		try {
			new OrdersModel().deleteOrder(codeOrder);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./admin.jsp?f=order");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
