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


@WebServlet("/CompanyEditAction")
public class CompanyEditAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public CompanyEditAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeCompany = request.getParameter("codeCompany");
		String nameCompany = request.getParameter("nameCompany");
		
		Company c = new Company();
		c.setCodeCompany(codeCompany);
		c.setNameCompany(nameCompany);
		
		try {
			new CompanyModel().updateCompany(c);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		response.sendRedirect("./admin.jsp?f=EditCompany&codeCompany=" + codeCompany);
	}

}
