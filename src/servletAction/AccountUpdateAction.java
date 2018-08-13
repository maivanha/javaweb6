package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountModel;
import model.etity.Customer;


@WebServlet("/AccountUpdateAction")
public class AccountUpdateAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountUpdateAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 2 Dòng dưới để lấy dữ liệu không bị lỗi font chữ
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
				
		Customer cus = new Customer();
		cus.setUsername(request.getParameter("username"));
		cus.setFullname(request.getParameter("fullname"));
		cus.setAddress(request.getParameter("address"));
		cus.setMobile(Integer.parseInt(request.getParameter("mobile")));
		cus.setEmail(request.getParameter("email"));
		cus.setId(Integer.parseInt(request.getParameter("id")));
		
		System.out.println("cus " + cus.getUsername() + "   " + cus.getId());
		AccountModel aModel = new AccountModel();
		try {
			aModel.updateDetail(cus);
			response.sendRedirect("./admin.jsp?username="+cus.getUsername()+"&f=EditAccount");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
