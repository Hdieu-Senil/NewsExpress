package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.naming.spi.DirStateFactory.Result;

import org.w3c.dom.stylesheets.LinkStyle;

import model.been.User;
import util.ConnectDBUtil;

public class UserDao {
	private ConnectDBUtil connectDBUtil;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public UserDao() {
		connectDBUtil = new ConnectDBUtil();
	}

	// Medthod ArrayList chua cac doi tuong User
	public ArrayList<User> getItems() {
		ArrayList<User> listItems = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "Select * from users order by id";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				User objItem = new User(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("password"));
				listItems.add(objItem);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return listItems;
	}

	public int addItem(User objUser) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO users(username, fullname, password) Value (?,?,?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getUsername());
			pst.setString(2, objUser.getFullname());
			pst.setString(3, objUser.getPassword());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	public User checkUser(String username) {
		User objuser = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM users WHERE username = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, username);
			rs = pst.executeQuery();
			if (rs.next()) {
				objuser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objuser;
	}

	public int delItem(int idUser) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "DELETE FROM users WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idUser);
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public User getItem(int idUser) {
		User objUser = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM users WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idUser);
			rs = pst.executeQuery();
			if (rs.next()) {
				objUser = new User(rs.getInt("id"), rs.getString("username"), rs.getString("fullname"),
						rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objUser;
	}

	public int editUser(User objUser) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "UPDATE users SET password=?,fullname=? WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objUser.getPassword());
			pst.setString(2, objUser.getFullname());
			pst.setInt(3, objUser.getIdUser());
			result = pst.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
}
