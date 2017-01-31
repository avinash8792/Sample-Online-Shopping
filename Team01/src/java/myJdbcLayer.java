/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nidhi
 */
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class myJdbcLayer {

    String DB_Url = "jdbc:mysql://mis-sql.uhcl.edu/sankaa7561";
    String username = "sankaa7561";
    String password = "1457744";

    public void LoadMySqlDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is ok.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public ArrayList<Product> SearchByCatnSup(Product p, String cat, String sup) {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from product where Category='" + cat  + "' and P_supplier='" + sup  + "'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    
    public ArrayList<Product> SearchByCategory(Product p, String sc) {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from product where Category='" + sc + "'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }

    public ArrayList<Product> SearchByName(Product p, String sc, String ot) {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();
            String Query1="";
            if(ot.equals("Material"))
            {
            Query1 = "Select * from product where P_Name='" + sc + "' and ordertype='Material'"; 
            }
            else if(ot.equals("Service"))
            {
            Query1 = "Select * from product where P_Name='" + sc + "' and ordertype='Service'";
            }
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    public ArrayList<Product> SearchByDesc(Product p, String sc, String ot) {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1="";
            if(ot.equals("Material"))
            {
            Query1 = "Select * from product where P_desc='" + sc + "' and ordertype='Material'"; 
            }
            else if(ot.equals("Service"))
            {
            Query1 = "Select * from product where P_desc='" + sc + "' and ordertype='Service'";
            }
            ResultSet rset = s.executeQuery(Query1);  
            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    public ArrayList<Product> SearchBySupplier(Product p, String sc) {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from product where P_Supplier='" + sc + "'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    public ArrayList<Product> SearchBySupplier2(Product p, String sc, String ot) {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1="";
            if(ot.equals("Material"))
            {
            Query1 = "Select * from product where P_Supplier='" + sc + "' and ordertype='Material'"; 
            }
            else if(ot.equals("Service"))
            {
            Query1 = "Select * from product where P_Supplier='" + sc + "' and ordertype='Service'";
            }
            ResultSet rset = s.executeQuery(Query1);
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    public ArrayList<Product> SearchAll() {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from product";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    public ArrayList<Product> SearchAllMaterials() {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from product where ordertype='Material'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }
    
    public ArrayList<Product> SearchAllServices() {        
        String errorMsg = "";
        ArrayList<Product> arr_prod = new ArrayList<Product>();
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from product where ordertype='Service'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Product p1 = new Product(rset.getString(1), rset.getString(2), rset.getString(3), rset.getDouble(4), rset.getInt(5),rset.getString(9),rset.getString(10),rset.getString(6),rset.getString(7),rset.getString(8),rset.getString(11));
                arr_prod.add(p1);
                System.out.println(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return arr_prod;
    }

}
