package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.been.Category;
import model.dao.CatDao;

/**
 * Servlet implementation class AdminCatEditController
 */
public class AdminCatEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CatDao catDao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AdminCatEditController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCat = Integer.parseInt(request.getParameter("cid"));
		catDao = new CatDao();
		Category objcat = catDao.getItem(idCat);
		request.setAttribute("objCat", objcat);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/category/editCat.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String catName = request.getParameter("catName");
		int idCat = Integer.parseInt(request.getParameter("idCat"));
		catDao = new CatDao();
		Category objCat = new Category(idCat, catName);
		if (catDao.checkNameCat(catName) != null & !catName.equals(catDao.getItem(idCat).getCat_name())) {
			response.sendRedirect(request.getContextPath() + "/admin/cat/edit?msg=0&cid="+idCat);
		} else {
			 if(catName.equals(catDao.getItem(idCat).getCat_name())) {
				response.sendRedirect(request.getContextPath() + "/admin/cat");
			}else if (catDao.editCat(objCat) > 0) {
				response.sendRedirect(request.getContextPath() + "/admin/cat?msg=2");
			}
			else {
				response.sendRedirect(request.getContextPath() + "/admin/cat?msg=0");
			}
		}
	}
}
