package model.bean;

public class khachhangbean {
	private String makh;
	private String username;
	private String password;
	private String name;
	public khachhangbean() {
		super();
	}
	
	public khachhangbean(String makh, String username, String password, String name) {
		super();
		this.makh = makh;
		this.username = username;
		this.password = password;
		this.name = name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getMakh() {
		return makh;
	}

	public void setMakh(String makh) {
		this.makh = makh;
	}

	
}
