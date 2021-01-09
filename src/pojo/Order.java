package pojo;


public class Order {
	
	private int oid;
	private int gid;
	private String kind;
	private double price;
	private int num;
	private String address;
	private String arrival;
	private String date;
	private int fid;
	
	
	
	public Order() {
		super();
	}



	



	public Order(int oid, String kind, double price, int num, String address, String arrival, String date, int fid,
			int gid) {
		super();
		this.oid = oid;
		this.kind = kind;
		this.price = price;
		this.num = num;
		this.address = address;
		this.arrival = arrival;
		this.date = date;
		this.fid = fid;
		this.gid = gid;
	}







	/*
	 * public Order(int oid, String kind, double price, int num, String address,
	 * boolean arrival, String date, int fid, int gid) { super(); this.oid = oid;
	 * this.kind = kind; this.price = price; this.num = num; this.address = address;
	 * this.arrival = arrival; this.date = date; this.fid = fid; this.gid = gid; }
	 */







	public int getGid() {
		return gid;
	}







	public void setGid(int gid) {
		this.gid = gid;
	}







	public int getOid() {
		return oid;
	}



	public void setOid(int oid) {
		this.oid = oid;
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



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



//	public boolean isArrival() {
//		return arrival;
//	}
//
//
//
//	public void setArrival(boolean arrival) {
//		this.arrival = arrival;
//	}



	public String getArrival() {
		return arrival;
	}







	public void setArrival(String arrival) {
		this.arrival = arrival;
	}







	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public int getFid() {
		return fid;
	}



	public void setFid(int fid) {
		this.fid = fid;
	}
	
	

}
