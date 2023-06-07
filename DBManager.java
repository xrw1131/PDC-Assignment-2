/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package workforceplanner;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author xrw1131
 */
public class DBManager {
    private static final String USER_NAME = "xrw1131"; 
    private static final String PASSWORD = "pdc"; 
    private static final String URL = "jdbc:derby:WorkforcePlanner_Ebd; create=true";  

    private Connection conn;    

    public DBManager() {
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);                                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Connection getConnection() {
        return this.conn;
    }
    
    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void createTable(){
        try {           
            Statement statement;
            statement = conn.createStatement();
            statement.addBatch("CREATE  TABLE BOOK  (BOOKID  INT,   TITLE   VARCHAR(50),   CATEGORY   VARCHAR(20),   PRICE   FLOAT)");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }    
    
    public void insertRecord(){
        try {            
            Statement statement;
            statement = conn.createStatement();
            statement.addBatch("INSERT INTO BOOK VALUES (1, 'Slum Dog Millionaire', 'Fiction', 19.90)");
            statement.executeBatch();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }
    
    public void updateDB(String sql) {
        try {
            Statement statement;
            statement = conn.createStatement();            
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public ResultSet queryDB(String sql) {
        ResultSet resultSet = null;

        try {
            Statement statement;
            statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    private boolean checkTable(String tableName) {
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, tableName.toUpperCase(), new String[] {"TABLE"});
            return (resultSet.next());                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;
    }  
    
    public static void main(String[] args) {
        DBManager dbManager = new DBManager();
        
        //dbManager.drop();
        dbManager.closeConnections();
    }

}
