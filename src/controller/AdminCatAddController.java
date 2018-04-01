package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.been.Category;
import model.dao.CatDao;

/**
 * Servlet implementation class AdminCatAddController
 */
public class AdminCatAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCatAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/admin/category/addCat.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String name_cat = request.getParameter("category");
		CatDao catDao = new CatDao();
		Category objCat = new Category(0,name_cat);
		if(catDao.checkNameCat(name_cat)!=null) {
			//ko cho thêm
			response.sendRedirect(request.getContextPath()+"/admin/cat/add?msg=0");
		}else {
			if(catDao.addItem(objCat)>0) {
				response.sendRedirect(request.getContextPath()+"/admin/cat?msg=1");
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/cat?msg=0");
			}
		}
	}

}
