package servletAction;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ChangeLanguage")
public class ChangeLanguage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangeLanguage() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String selected = (String)request.getParameter("lang");
		
		HttpSession session = request.getSession();
		
		if(selected != null && selected.equals("vi")) {
			session.setAttribute("language", new Locale("vi", "VN"));
		} else {
			session.setAttribute("language", null);
		}
		
		response.sendRedirect("./index.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
