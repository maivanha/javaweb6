package servletAction;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.OrdersModel;
import model.etity.Orders;

@WebServlet("/OrderEditAction")
public class OrderEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderEditAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2 Dòng dưới để lấy dữ liệu không bị lỗi font chữ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		String codeOrder = request.getParameter("codeOrder");
		String receiveddate = request.getParameter("receiveddate");
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		System.out.println("1 " + receiveddate);
		System.out.println("code " + codeOrder);
		
//		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//		Date date = null;
//		try {
//			date = formatter.parse(receiveddate);
//		} catch (ParseException e1) {
//			e1.printStackTrace();
//		}
//		
//		
//		Calendar c = Calendar.getInstance();
//		c.setTime(date);
//		java.sql.Date datee = new java.sql.Date(c.getTimeInMillis());
//		System.out.println("2 " + datee);
		Orders o = new Orders();
		o.setCodeOrder(Integer.parseInt(codeOrder));
		o.setFullname(fullname);
		o.setAddress(address);
		o.setEmail(email);
		//o.setReceivedDate(datee);
		
		try {
			new OrdersModel().updateOrder(o);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./admin.jsp?f=EditOrder");
	}

}
