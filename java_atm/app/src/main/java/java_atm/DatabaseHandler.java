package java_atm;

import java.sql.*;

public class DatabaseHandler {
    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/atm";

    static final String USER = "root";
    static final String PASS = "password";
    
    public static void createAccount(String accountNo, String balance, String pin) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "INSERT INTO `Account`(AccountNo, Balance, Pin)\nVALUES(";
            sql += "'" + accountNo + "', " + balance;
            sql += ", '" + pin + "');";
            
            System.out.println(sql);
            
            int rs = stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    public static boolean isAccountValid(String accountNumber) {
        Connection conn = null;
        Statement stmt = null;
        int valid = 0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `Account`\n WHERE AccountNo=";
            sql += "'" + accountNumber + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                valid++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        if(valid > 0) {
            return true;
        }
        return false;
    }
    
    public static boolean validatePin(String accountNumber, String pin) {
        Connection conn = null;
        Statement stmt = null;
        int valid = 0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `Account`\n WHERE AccountNo=";
            sql += "'" + accountNumber + "'AND Pin='" + pin + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                valid++;
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        if(valid > 0) {
            return true;
        }
        return false;
    }
    
    public static void depositMoney(String accountNo, int amount) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "UPDATE `Account` SET Balance = Balance + " 
                    + Integer.toString(amount);
            sql += " WHERE accountNo='" + accountNo + "';";
            
            int rs = stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
    }
    
    public static boolean withdrawMoney(String accountNo, int amount) {
        Connection conn = null;
        Statement stmt = null;
        
        int balance = getBalance(accountNo);
        
        if(balance < amount) {
            return false;
        }
        
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "UPDATE `Account` SET Balance = Balance - " 
                    + Integer.toString(amount);
            sql += " WHERE accountNo='" + accountNo + "';";
            
            int rs = stmt.executeUpdate(sql);
            
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return true;
    }
        
    public static int getBalance(String accountNo) {
        Connection conn = null;
        Statement stmt = null;
        int balance = 0;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM `Account`\n WHERE AccountNo=";
            sql += "'" + accountNo + "';";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                balance = rs.getInt("Balance");
            }
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return balance;
    }
    
    public static boolean getMoney(int accountNo, int amount) {
        Connection conn = null;
        Statement stmt = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT * FROM ATM";
            ResultSet rs = stmt.executeQuery(sql);
            
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        }
        return false;
    }
    
    
}
