package servletAction;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.RatingModel;
import model.etity.Rating;


@WebServlet("/RatingAction")
public class RatingAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RatingAction() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		double rating = Double.parseDouble(request.getParameter("rating"));
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		String username = (String) session.getAttribute("username");
		Rating r = new Rating();
		r.setCodeProduct(codeProduct);
		r.setUsername(username);
		r.setValueRating(rating);
		
		
		
		try {
			Rating rs = new RatingModel().getRating(codeProduct, username);
			if(rs.getIdRating() == 0) {
				new RatingModel().insertRating(r);
			} else {
				new RatingModel().updateRating(r);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		response.sendRedirect("./InformationProduct.jsp?codeProduct="+codeProduct);
	}

}
