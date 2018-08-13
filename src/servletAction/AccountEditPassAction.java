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


@WebServlet("/AccountEditPassAction")
public class AccountEditPassAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AccountEditPassAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		System.out.println("ass: " + username);
		String passOld = request.getParameter("passOld");
		System.out.println("passold: " + passOld);
		String passNew = request.getParameter("passNew");
		System.out.println("passnew: " + passNew);
		Account acc = null;
		try {
			acc = new AccountModel().getAccount(username, passOld);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		

		if(acc != null) {
			System.out.println("Dung passs !");
			acc.setUserpass(passNew);
			acc.setUsername(username);
			try {
				new AccountModel().updateAccountPass(acc);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("Không đúng mật khẩu cũ !");
		}
		
		response.sendRedirect("./admin.jsp?f=EditAccount&username=" + username);
	}

}
