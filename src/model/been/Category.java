package model.been;

public class Category {
	private int idCat;
	private String cat_name;
	public Category() {
		super();
	}
	public Category(int idCat, String cat_name) {
		super();
		this.idCat = idCat;
		this.cat_name = cat_name;
	}
	public int getIdCat() {
		return idCat;
	}
	public void setIdCat(int idCat) {
		this.idCat = idCat;
	}
	public String getCat_name() {
		return cat_name;
	}
	public void setCat_name(String cat_name) {
		this.cat_name = cat_name;
	}

}
