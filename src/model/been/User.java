package model.been;

public class User {
	private int idUser;
	private String username;
	private String fullname;
	private String password;
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(int idUser, String username, String fullname, String password) {
		super();
		this.idUser = idUser;
		this.username = username;
		this.fullname = fullname;
		this.password = password;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	//tạo đối tượng
}
