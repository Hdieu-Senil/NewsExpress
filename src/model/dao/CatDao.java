package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.been.Category;
import util.ConnectDBUtil;

public class CatDao {
	private ConnectDBUtil connectDBUtil;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;
	

	public CatDao() {
		connectDBUtil = new ConnectDBUtil();
	}

	public ArrayList<Category> getItems() {
		ArrayList<Category> listItems = new ArrayList<>();
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM category";
		Category objItem ;
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				objItem = new Category(rs.getInt("id"), rs.getString("cat_name"));
				listItems.add(objItem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listItems;
	}

	public Category checkNameCat(String name_cat) {
		Category objCat = null;
		conn= connectDBUtil.getConnection();
		String sql = "SELECT * FROM category WHERE cat_name =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, name_cat);
			rs = pst.executeQuery();
			if(rs.next()) {
				objCat = new Category(rs.getInt("id"), rs.getString("cat_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objCat;
	}

	public int addItem(Category objCat) {
		int result = 0;
		conn = connectDBUtil.getConnection();
		String sql = "INSERT INTO category(cat_name) VALUE (?)";
		try {
			pst = conn.prepareStatement(sql);
			pst.setString(1, objCat.getCat_name());
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

	public Category getItem(int idCat) {
		Category objCat = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM category WHERE id = ?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
			rs = pst.executeQuery();
			if(rs.next()) {
				objCat = new Category(rs.getInt("id"), rs.getString("cat_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pst.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return objCat;
	}

	public int editCat(Category objCat) {
		int result=0;
		conn = connectDBUtil.getConnection();
		String  sql = "UPDATE category SET cat_name =? WHERE id = ?";
		try {
			pst =conn.prepareStatement(sql);
			pst.setString(1, objCat.getCat_name());
			pst.setInt(2, objCat.getIdCat());
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

	public int delItem(int idCat) {
		int result =0;
		conn = connectDBUtil.getConnection();
		String sql = "DELETE FROM category WHERE id =?";
		try {
			pst = conn.prepareStatement(sql);
			pst.setInt(1, idCat);
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
