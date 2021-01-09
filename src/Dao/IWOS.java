package Dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;

import com.mysql.jdbc.Connection;

import pojo.Customer;
import pojo.Firm;
import pojo.Goods;
import pojo.Order;
import util.Conn;

public class IWOS {
	
	/**商家上架新商品*/
	public static void addGoods(Goods goods) {
		
		Connection connection = Conn.getConnection();
		String sql = "insert into goods(gid,kind,price,num,fid) values(?,?,?,?,?)";
		PreparedStatement pStatement = null;
		
		try {
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, goods.getGid());
			pStatement.setString(2, goods.getKind());
			pStatement.setDouble(3, goods.getPrice());
			pStatement.setInt(4, goods.getNum());
			pStatement.setInt(5, goods.getFid());
			
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
		
	}
	
	
	/**商家更新库存*/
	public static void updateGoods(int fid,int gid,int num) {
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		
		String sql = "update goods set num=? where fid=? and gid=?";
		
		try {
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, num);
			pStatement.setInt(2, fid);
			pStatement.setInt(3, gid);
			
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
		
	}
	
	
	
	/**商家查看订单*/
	public static ResultSet getAllOrder(){
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		String sql = "select * from test";
		
		try {
			
			pStatement = connection.prepareStatement(sql);
			
			rSet = pStatement.executeQuery();
			
			return rSet;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return rSet;
		}
	}  
	
	
	/**商家查看自己的订单*/
	public static ResultSet getmyOrder(int fid){
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		String sql = "select * from test where fid=?";
		
		try {
			
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, fid);
			
			rSet = pStatement.executeQuery();
			
			return rSet;
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return rSet;
		}
	}  
	
	
	/**商家查看自己的商品*/
	public static ResultSet getmyGoods(int fid){
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		String sql = "select * from goods where fid=?";
		
		try {
			
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, fid);
			
			rSet = pStatement.executeQuery();
			
			return rSet;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return rSet;
			
		}	
	}
	
	
	
	/**商家下架自己的商品*/
	public static ResultSet removemyGoods(int fid,int gid){
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		String sql = "delete from goods where fid=? and gid=?";
		
		try {
			
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, fid);
			pStatement.setInt(2, gid);
			
			pStatement.execute();
			
			return rSet;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return rSet;
			
		}	
	}
	
	
	
	/**客户查看商品*/
	public static ResultSet getAllGoods(){
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		
		String sql = "select * from goods";
		
		try {
			
			pStatement = connection.prepareStatement(sql);
			
			rSet = pStatement.executeQuery();
			
			return rSet;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return rSet;
			
		}
		
		
	}
	
	/**客户下单*/
	public static void addOrder(Order order) {
		
		Connection connection = Conn.getConnection();
		String sql = "insert into test(gid,kind,price,num,address,arrival,date,fid) value(?,?,?,?,?,?,?,?)";
		
		PreparedStatement pStatement = null;
		
		
		try {
			
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, order.getGid());
			pStatement.setString(2, order.getKind());
			pStatement.setDouble(3, order.getPrice());
			pStatement.setInt(4, order.getNum());
			pStatement.setString(5, order.getAddress());
			pStatement.setString(6, order.getArrival());
			pStatement.setString(7, order.getDate());
			pStatement.setInt(8, order.getFid());
			
			pStatement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
	}
	
	/**客户下单后，对应商品数减少*/
	public static void decreaseGoods(Order order) {
		
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		
		String sql = "update goods set num=num-? where fid=? and gid=?";
		
		try {
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, order.getNum());
			pStatement.setInt(2, order.getFid());
			pStatement.setInt(3, order.getGid());
			
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
		
	}
	
	
	/**商家确认送达*/
	public static void isArrival(int oid) {
		Connection connection = Conn.getConnection();
		String sql = "update test set arrival=? where oid=?";
		PreparedStatement pStatement = null;
		String yeString = "1";
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, yeString);
			pStatement.setInt(2, oid);
			
			pStatement.execute();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
	}
	
	/**商家入驻*/
	public static void addFirm(Firm firm) {
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement = null;
		String sql = "insert into firm(fid,name,password) values(?,?,?)";
		
		try {
			pStatement = connection.prepareStatement(sql);
			
			pStatement.setInt(1, firm.getFid());
			pStatement.setString(2, firm.getName());
			pStatement.setString(3, firm.getPassword());
			
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
		
	}
	
	
	/**客户注册*/
	public static void addCustomer(Customer customer) {
		Connection connection = Conn.getConnection();
		PreparedStatement pStatement =null;
		
		String sql = "insert into customer(cid,name,password) values(?,?,?)";
		
		try {
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, customer.getCid());
			pStatement.setString(2, customer.getName());
			pStatement.setString(3, customer.getPassword());
			
			pStatement.execute();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, pStatement, null);
		}
	}
	
	
	/**商家登录验证*/
	public static boolean isFirm(int id,String password) {
		Connection connection = Conn.getConnection();
		PreparedStatement psStatement = null;
		ResultSet rSet = null;
		boolean flag = false;
		String sql = "select * from firm where fid=? and password=?";
		
		try {
			psStatement = connection.prepareStatement(sql);
			
			psStatement.setInt(1, id);
			psStatement.setString(2, password);
			
			rSet = psStatement.executeQuery();
			if(rSet.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, psStatement, rSet);
			
		}
		return flag;
	}
	
	
	/**客户登录验证*/
	public static boolean isCustomer(int id,String password) {
		Connection connection = Conn.getConnection();
		PreparedStatement psStatement = null;
		ResultSet rSet = null;
		boolean flag = false;
		String sql = "select * from customer where cid=? and password=?";
		
		try {
			psStatement = connection.prepareStatement(sql);
			
			psStatement.setInt(1, id);
			psStatement.setString(2, password);
			
			rSet = psStatement.executeQuery();
			if(rSet.next()) {
				flag = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			Conn.release(connection, psStatement, rSet);
			
		}
		return flag;
	}
	
}
