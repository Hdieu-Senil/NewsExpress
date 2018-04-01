package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.dao.CatDao;

/**
 * Servlet implementation class AdminCatDelController
 */
public class AdminCatDelController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminCatDelController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CatDao catDao = new CatDao();
		int idCat = Integer.parseInt(request.getParameter("cid"));
		if(catDao.delItem(idCat)>0) {
			response.sendRedirect(request.getContextPath()+"/admin/cat?msg=3");
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/cat?msg=0");
		}
	}

}
