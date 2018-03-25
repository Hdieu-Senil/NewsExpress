package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.been.User;
import model.dao.UserDao;

/**
 * Servlet implementation class AdminUserEditController
 */
public class AdminUserEditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    UserDao userDao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserEditController() {
        super();
        // TODO Auto-generated constructor stub
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		userDao = new UserDao();
		int idUser = Integer.parseInt(request.getParameter("uid"));
		User objUser = new User();
		objUser = userDao.getItem(idUser);
		request.setAttribute("objUser", objUser);
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/editUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
