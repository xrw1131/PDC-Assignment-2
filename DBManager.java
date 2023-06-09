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
import java.util.ArrayList;

/**
 *
 * @author xrw1131
 */
public class DBManager {      

    private Connection conn;    

    public DBManager(String URL, String userName, String password) {//constructor
        if (this.conn == null) {
            try {
                conn = DriverManager.getConnection(URL, userName, password);                                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Connection getConnection() {//get method
        return this.conn;
    }
    
    public void closeConnections() {//close method
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    
    public void createTable(String tableName, String fields){//create tables method
        if (!checkTable(tableName))
        {
            try {
                Statement statement;
                statement = conn.createStatement();
                statement.executeUpdate("CREATE TABLE " + tableName + " (" + fields + ")");
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }        
    }    
    
    public void insertRecord(String tableName, String values){//create new record method
        try {            
            Statement statement;
            statement = conn.createStatement();
            statement.executeUpdate("INSERT INTO " + tableName + " VALUES (" + values + ")");            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());            
        }
    }    
    
    public ResultSet queryDB(String sql) {//create queries and return result set
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
    
    
    public void updateDB(String sql) {//generic sql method
        try {
            Statement statement;
            statement = conn.createStatement();            
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void getAllReccords(String tableName, ArrayList arrayList) {//copies all records from database 
        try {
            ResultSet resultSet = queryDB("SELECT * FROM " + tableName);
            while (resultSet.next()) {
                String id = resultSet.getString(1);
                String lastName = resultSet.getString(2);
                String firstName = resultSet.getString(3);
                int salary = resultSet.getInt(4);
                
                switch (tableName) {
                    case WorkforcePlanner.TABLE_BON:
                        int bonus = resultSet.getInt(5);
                        Bonus newBonus = new Bonus(id, lastName, firstName, salary, bonus);
                        arrayList.add(newBonus);
                        break;
                    case WorkforcePlanner.TABLE_EMP:
                        Employee newEmployee = new Employee(id, lastName, firstName, salary);
                        arrayList.add(newEmployee);
                        break;
                    case WorkforcePlanner.TABLE_INT:
                        Intern newIntern = new Intern(id, lastName, firstName, salary);
                        arrayList.add(newIntern);
                        break;
                    default:
                        break;
                }
            }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }                
    }

    private boolean checkTable(String tableName) {//checks whether table already exists
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet resultSet = meta.getTables(null, null, tableName.toUpperCase(), new String[] {"TABLE"});
            return (resultSet.next());                
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }      
        return false;
    }     
        
}
