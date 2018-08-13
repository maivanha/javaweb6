package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountModel;
import model.etity.Account;
@WebServlet(
		urlPatterns = { "/LoginAction" }, 
		initParams = { 
				@WebInitParam(name = "role", value = "admin"), 
				@WebInitParam(name = "permission", value = "admit")
		})
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginAction() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		
		System.out.println(">>>>>> username: " + username);
		AccountModel aModel = new AccountModel();
		Account account = null;
		try {
			account = aModel.getAccount(username, password);
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		if(account != null) {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);

			// Khởi tạo cookies và thiết lập giá trị của username
			//Cookie userCookie = new Cookie("username", username);
			//userCookie.setMaxAge(60*3);
			//response.addCookie(userCookie);

			response.sendRedirect("./index.jsp");
		} else {
			response.sendRedirect("./index.jsp");
		}
	}

}
