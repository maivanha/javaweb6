package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.NewsModel;


@WebServlet("/NewDeleteAction")
public class NewDeleteAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NewDeleteAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String codeNews = request.getParameter("id");
		System.out.println("xóa");
		try {
			new NewsModel().deleteNews(Integer.parseInt(codeNews));
			response.sendRedirect("./admin.jsp?f=new");
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
