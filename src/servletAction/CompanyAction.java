package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CompanyModel;
import model.etity.Company;


@WebServlet("/CompanyAction")
public class CompanyAction extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public CompanyAction() {
		super();
		// TODO Auto-generated constructor stub
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String codeCompany = request.getParameter("codeCompany");

		if(action.equals("delete")) {
			try {
				new CompanyModel().deleteCompany(codeCompany);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		response.sendRedirect("./admin.jsp?f=company");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeCompany = request.getParameter("codeCompany");
		String nameCompany = request.getParameter("nameCompany");

		Company c = new Company();
		c.setCodeCompany(codeCompany);
		c.setNameCompany(nameCompany);

		try {
			new CompanyModel().insertCompany(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("./admin.jsp?f=company");
	}

}
