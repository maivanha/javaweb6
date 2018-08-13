package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountModel;
import model.etity.Account;
import model.etity.Customer;



@WebServlet("/AccountRegisterAction")
public class AccountRegisterAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public AccountRegisterAction() {

	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2 Dòng dưới để lấy dữ liệu không bị lỗi font chữ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		String email = request.getParameter("email");
		String fullname = request.getParameter("fullname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		
		
		System.out.println("fullname: " + fullname + "    address: " + address);
		
		Customer cus = new Customer();
		cus.setEmail(email);
		cus.setAddress(address);
		cus.setFullname(fullname);
		cus.setMobile(Integer.parseInt(phone));

		System.out.println("register");

		AccountModel aModel = new AccountModel();
		Account acc = null;

		try {
			acc = aModel.getAccount(username, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(acc == null) {
			try {
				aModel.insertAccount(username, password, email, cus);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			response.sendRedirect("./data/dangnhap.jsp");
		} else {
			System.out.println(">>>>> Tai khoan da ton tai");
			response.sendRedirect("./data/dangky.jsp");
		}

		
	}

}
