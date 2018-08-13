package servletAction;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ProductModel;
import model.etity.Product;


@WebServlet("/BuyProduct")
public class BuyProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BuyProduct() {
		super();
	}


	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		
		int codeProduct = Integer.parseInt(request.getParameter("codeProduct"));
		System.out.println(codeProduct);
		HttpSession session = request.getSession();
		PrintWriter o = response.getWriter();
		//new ProductModel().ThemGioHang(Integer.parseInt(codeProduct));
		/*Cookie dsGioHang = new Cookie("dsGioHang", codeProduct);
		dsGioHang.setMaxAge(60*60*24);
		response.addCookie(dsGioHang);*/

		List<Product> list = new ArrayList<>();
		Product quanti = null;
		try {
			quanti = new ProductModel().getProductById(codeProduct);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if(quanti.getNumberOfpro() == 0) {
			request.setAttribute("Mess", "Sản phẩm đã bán hết !");

		} else {
			if(session.getAttribute("username") != null) {
				if(session.getAttribute("dsGioHang") == null) {
					try {
						Product p = new ProductModel().getProductById(codeProduct);
						p.setCountbuy(1);

						list.add(p);
						session.setAttribute("dsGioHang", list);
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}

				} else {
					list = (List<Product>) session.getAttribute("dsGioHang");
					boolean check = false;
					try {

						Product p = new ProductModel().getProductById(codeProduct);
						for(int i = 0; i < list.size(); i++) {
							if(list.get(i).getCodeProduct() == p.getCodeProduct()) {
								if((quanti.getNumberOfpro() - list.get(i).getCountbuy()) == 0) {
									request.setAttribute("Mess", "Số lượng sản phẩm còn lại: " + quanti.getNumberOfpro());
									check = true;
									break;
								} else {
									list.get(i).setCountbuy(list.get(i).getCountbuy() + 1);
									session.setAttribute("dsGioHang", list);
									check = true;
								}
							}
						}
						if(check == false) {
							p.setCountbuy(1);
							list.add(p);
							session.setAttribute("dsGioHang", list);
						}
					} catch (NumberFormatException e) {
						e.printStackTrace();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				RequestDispatcher rd = request.getRequestDispatcher("./index.jsp");
				rd.forward(request, response);
			} else {
				response.sendRedirect("./data/dangnhap.jsp");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
