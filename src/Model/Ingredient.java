package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ingredient {
	static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";  
	static final String DB_URL = "jdbc:mariadb://whichsandwich.c25onscqmkzg.ap-northeast-2.rds.amazonaws.com:3306/whichSandwich";
	
	//Database credentials
	static final String USER = "zwaninkt";
	static final String PASS = "whichSandwhich";
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	//Statement stmt = null;
	ResultSet rs = null;

	
	ArrayList<Content> list = new ArrayList<Content>();

	public void connectDB() {
		try {
			Class.forName(JDBC_DRIVER);
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
		} catch (ClassNotFoundException | SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	//Self
	//step에 따라서 DB에서 재료 return
	public ArrayList<Content> getIngredientByLevel(int step) {
		connectDB();
		System.out.println(step);
		String sql = "SELECT id, title, img FROM ingredients WHERE step = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, step);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				 int id  = rs.getInt("id");
		         String title = rs.getString("title");
		         String img = rs.getString("img");	
		         //Display values
		         //System.out.print("ID: " + id);
		         //System.out.print(", title: " + title);
		         //System.out.println(", img: " + img);
		         
		         list.add(new Content(id, step, title, img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}
	
	//Product
	//id에 따라서 DB에서 재료 return
	public ArrayList<Content> getIngredientById(int id) {
		String sql = "SELECT step, title, img FROM ingredients WHERE id = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 int step = rs.getInt("step");
		         String title = rs.getString("title");
		         String img = rs.getString("img");


		         list.add(new Content(id, step, title, img));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
			
	}
	
	public Product getRandomIngredientId() {
		String sql = "SELECT id FROM ingredients " +
						"WHERE step = ? ORDER BY rand() LIMIT ?";
		Product product = new Product();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			
			//1. Menu
			pstmt.setInt(1, 1);
			pstmt.setInt(2, 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product.setMenu(rs.getInt("id"));
			}
			
			
			//2. Bread
			pstmt.setInt(1, 2);
			pstmt.setInt(2, 1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				product.setBread(rs.getInt("id"));
			}
			//3. Topping
			pstmt.setInt(1, 3);
			pstmt.setInt(2, 7);
			rs = pstmt.executeQuery();
			
			int[] arrayTopping = new int[7];
			int i = 0;
			while(rs.next()) {
				arrayTopping[i] = rs.getInt("id");
				i++;
			}
			product.setTopping(arrayTopping);
		

			
			//4. Vegetable
			pstmt.setInt(1, 4);
			pstmt.setInt(2, 9);
			rs = pstmt.executeQuery();
			int[] arrayVegetable = new int[9];
			i = 0;
			while(rs.next()) {
				arrayVegetable[i] = rs.getInt("id");
				i++;
			}
			product.setTopping(arrayVegetable);
			
			//5. Sauce
			pstmt.setInt(1, 5);
			pstmt.setInt(2, 2);
			rs = pstmt.executeQuery();
			int[] arraySauce = new int[7];
			i = 0;
			while(rs.next()) {
				arraySauce[i] = rs.getInt("id");
				i++;
			}
			
			product.setTopping(arraySauce);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
			
	}
}
