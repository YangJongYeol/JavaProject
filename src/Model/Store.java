package Model;

import java.sql.*;
import java.util.ArrayList;

/*
    매장 주문 현황을 볼 때 사용하는 DB Model
 */

public class Store {
    static final String JDBC_DRIVER = "org.mariadb.jdbc.Driver";
    static final String DB_URL = "jdbc:mariadb://whichsandwich.c25onscqmkzg.ap-northeast-2.rds.amazonaws.com:3306/whichSandwich";

    //Database credentials
    static final String USER = "zwaninkt";
    static final String PASS = "whichSandwhich";

    Connection conn = null;
    PreparedStatement pstmt = null;
    //Statement stmt = null;
    ResultSet rs = null;



    public void connectDB() {
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (ClassNotFoundException | SQLException e1) {
            e1.printStackTrace();
        }
    }

    public int getOrderNumberByMarket(String market) {
        int num = 0;
        connectDB();
        String sql = "SELECT order_num FROM store WHERE market = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, market);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                num  = rs.getInt("order_num");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }

    public void updateOrderNumberByMarket(String market) {
        connectDB();
        //System.out.println(market);
        String sql = "UPDATE store SET order_num = order_num + 1 WHERE market = ?";

        try {
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, market);
            
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
