package pojo;

public class Customer {
	
	private int cid;
	private String name;
	private String password;
	
	public Customer() {
		super();
	}

	public Customer(int cid, String name, String password) {
		super();
		this.cid = cid;
		this.name = name;
		this.password = password;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
