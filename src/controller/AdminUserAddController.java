package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.been.User;
import model.dao.UserDao;
import util.StringUtil;

public class AdminUserAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserDao userDao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUserAddController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/admin/user/addUser.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String username = request.getParameter("username");
		String fullname = request.getParameter("fullname");
		String password = StringUtil.md5(request.getParameter("password"));
		User objUser = new User(0, username, fullname, password);
		userDao = new UserDao();
		if(userDao.checkUser(username)!= null) {
			//da ton tai user
			response.sendRedirect(request.getContextPath()+"/admin/user/add?msg=0");
			return;
		}else {
			if (userDao.addItem(objUser)>0) {
				response.sendRedirect(request.getContextPath()+"/admin/users?msg=1");
			}else {
				response.sendRedirect(request.getContextPath()+"/admin/users?msg=0");
			}
		}
	}

}
