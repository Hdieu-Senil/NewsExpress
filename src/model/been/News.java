package model.been;

import java.sql.Timestamp;

public class News {
	private int idNews;
	private String news_name;
	private String description;
	private String detail;
	private String picture;
	private int count_view;
	private int id_cat;
	private String cat_name;
	private int id_user;
	private String user_name;
	private Timestamp time_created;

	public News() {
		super();
	}

	public News(int idNews, int id_cat, int id_user, String news_name, String description, String detail,
			String picture, String cat_name, String user_name) {
		super();
		this.idNews = idNews;
		this.news_name = news_name;
		this.description = description;
		this.detail = detail;
		this.picture = picture;
		this.id_cat = id_cat;
		this.cat_name = cat_name;
		this.id_user = id_user;
		this.user_name = user_name;
	}

	public News(int idNews, int id_cat, int id_user, int count_view, String news_name, String description,
			String detail, String picture, String cat_name, String user_name, Timestamp time_created) {
		super();
		this.idNews = idNews;
		this.news_name = news_name;
		this.description = description;
		this.detail = detail;
		this.picture = picture;
		this.count_view = count_view;
		this.id_cat = id_cat;
		this.cat_name = cat_name;
		this.id_user = id_user;
		this.user_name = user_name;
		this.time_created = time_created;
	}

	public int getIdNews() {
		return idNews;
	}

	public void setIdNews(int idNews) {
		this.idNews = idNews;
	}

	public String getNews_name() {
		return news_name;
	}

	public void setNews_name(String news_name) {
		this.news_name = news_name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public int getCount_view() {
		return count_view;
	}

	public void setCount_view(int count_view) {
		this.count_view = count_view;
	}

	public String getCat_name() {
		return cat_name;
	}

	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public int getId_cat() {
		return id_cat;
	}

	public void setId_cat(int id_cat) {
		this.id_cat = id_cat;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public Timestamp getTime_created() {
		return time_created;
	}

	public void setTime_created(Timestamp time_created) {
		this.time_created = time_created;
	}

}
