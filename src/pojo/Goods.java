package pojo;

public class Goods {
	
	private int gid;
	private String kind;
	private double price;
	private int num;
	private int fid;
	
	
	public Goods() {
		super();
	}



	public Goods(int gid, String kind, double price, int num) {
		super();
		this.gid = gid;
		this.kind = kind;
		this.price = price;
		this.num = num;
	}



	public int getGid() {
		return gid;
	}



	public void setGid(int gid) {
		this.gid = gid;
	}



	public String getKind() {
		return kind;
	}



	public void setKind(String kind) {
		this.kind = kind;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public int getNum() {
		return num;
	}



	public void setNum(int num) {
		this.num = num;
	}



	public int getFid() {
		return fid;
	}



	public void setFid(int fid) {
		this.fid = fid;
	}
	
	
	
}
