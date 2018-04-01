package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.been.News;
import util.ConnectDBUtil;

public class NewsDao {
	private ConnectDBUtil connectDBUtil;
	private Connection conn;
	private Statement st;
	private PreparedStatement pst;
	private ResultSet rs;

	public NewsDao() {
		connectDBUtil = new ConnectDBUtil();
	}

	public ArrayList<News> getItems() {
		ArrayList<News> listNews = new ArrayList<News>();
		News objnews = null;
		conn = connectDBUtil.getConnection();
		String sql = "SELECT * FROM `news` INNER JOIN category ON id_cat=category.id INNER JOIN users on id_user = users.id ";
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				objnews = new News(rs.getInt("id"), rs.getInt("id_cat"), rs.getInt("id_user"), rs.getInt("count_view"),
						rs.getString("news_name"), rs.getString("description"), rs.getString("detail"),
						rs.getString("picture"), rs.getString("cat_name"), rs.getString("username"),
						rs.getTimestamp("time_created"));
				listNews.add(objnews);

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
		return listNews;
	}

}
