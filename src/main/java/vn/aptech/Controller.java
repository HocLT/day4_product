package vn.aptech;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.aptech.dto.ProductDto;
import vn.aptech.dto.dal.ProductDal;

import java.io.IOException;

/**
 * Servlet implementation class Controller
 */
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		ProductDal dal = new ProductDal();
		if (a == null) {
			// truyền dữ liệu
			request.setAttribute("prods", dal.findAll());
			// chuyển trang
			request.getRequestDispatcher("product/index.jsp").forward(request, response);
		} else {
			switch (a) {
			case "DisplayCreate": {
				response.sendRedirect("product/create.jsp");
			}
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String a = request.getParameter("a");
		ProductDal dal = new ProductDal();
		if (a != null) {
			switch (a) {
			case "Create": {
				String name = request.getParameter("name");
				String price = request.getParameter("price");
				int nPrice = Integer.parseInt(price);
				ProductDto p = new ProductDto();
				p.setName(name);
				p.setPrice(nPrice);
				dal.create(p);
				response.sendRedirect("Controller");
				break;
			}
			}
		}
	}

}
