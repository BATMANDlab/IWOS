package pojo;

public class Firm {
	
	private int fid;
	private String name;
	private String password;
	
	public Firm() {
		super();
	}

	public Firm(int fid, String name, String password) {
		super();
		this.fid = fid;
		this.name = name;
		this.password = password;
	}

	public int getFid() {
		return fid;
	}

	public void setFid(int fid) {
		this.fid = fid;
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
