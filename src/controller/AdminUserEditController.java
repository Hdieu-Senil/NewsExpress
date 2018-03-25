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
import util.StringUtil;

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
		request.setCharacterEncoding("UTF-8");
		int idUser = Integer.parseInt(request.getParameter("idUser"));
		System.out.println(idUser);
		String pasword = request.getParameter("password");
		String fullname = request.getParameter("fullname");
		userDao = new UserDao();
		if("".equals(pasword)) {
			pasword = StringUtil.md5(userDao.getItem(idUser).getPassword());
		}else {
			pasword = StringUtil.md5(pasword);
		}
		User objUser = new User(idUser, "", fullname, pasword);
		if(userDao.editUser(objUser)>0) {
			response.sendRedirect(request.getContextPath()+"/admin/users?msg=2");
		}else {
			response.sendRedirect(request.getContextPath()+"/admin/users?msg=0");
		}
	}

}
