
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nidhi
 */
@ManagedBean
@SessionScoped
public class PurchaseOrderBean {
    private String PO_id;
    private String PO_sender;
    private String PO_receiver;
    private String PO_gen_date;
    private String PO_app_date;
    private String PO_status;
    private String PO_status_Description;
    ArrayList<Purchase_Order> po = new ArrayList<Purchase_Order>();
    ArrayList<PO_lineitem> po_line = new ArrayList<PO_lineitem>();
    
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

    public PurchaseOrderBean() {
    }       

    public ArrayList<Purchase_Order> getPo() {
        return po;
    }

    public void setPo(ArrayList<Purchase_Order> po) {
        this.po = po;
    }

    public ArrayList<PO_lineitem> getPo_line() {
        return po_line;
    }

    public void setPo_line(ArrayList<PO_lineitem> po_line) {
        this.po_line = po_line;
    }
        
    

    public PurchaseOrderBean(String PO_id, String PO_sender, String PO_receiver, String PO_gen_date, String PO_app_date, String PO_status, String PO_status_Description) {
        this.PO_id = PO_id;
        this.PO_sender = PO_sender;
        this.PO_receiver = PO_receiver;
        this.PO_gen_date = PO_gen_date;
        this.PO_app_date = PO_app_date;
        this.PO_status = PO_status;
        this.PO_status_Description = PO_status_Description;
    }

    public String getPO_id() {
        return PO_id;
    }

    public void setPO_id(String PO_id) {
        this.PO_id = PO_id;
    }

    public String getPO_sender() {
        return PO_sender;
    }

    public void setPO_sender(String PO_sender) {
        this.PO_sender = PO_sender;
    }

    public String getPO_receiver() {
        return PO_receiver;
    }

    public void setPO_receiver(String PO_receiver) {
        this.PO_receiver = PO_receiver;
    }

    public String getPO_gen_date() {
        return PO_gen_date;
    }

    public void setPO_gen_date(String PO_gen_date) {
        this.PO_gen_date = PO_gen_date;
    }

    public String getPO_app_date() {
        return PO_app_date;
    }

    public void setPO_app_date(String PO_app_date) {
        this.PO_app_date = PO_app_date;
    }

    public String getPO_status() {
        return PO_status;
    }

    public void setPO_status(String PO_status) {
        this.PO_status = PO_status;
    }

    public String getPO_status_Description() {
        return PO_status_Description;
    }

    public void setPO_status_Description(String PO_status_Description) {
        this.PO_status_Description = PO_status_Description;
    }
    
       
    public void loadPurchaseOrders(String userName) {        
        String errorMsg = "";        
        this.LoadMySqlDriver();        
        po = new ArrayList<Purchase_Order>();
        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from purchase_order where PO_sender='" + userName + "'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                Purchase_Order p1 = new Purchase_Order(rset.getString(1), rset.getString(2), rset.getString(3), rset.getString(6));
                po.add(p1);
                
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        //return arr_prod;
    }
    
    public String getPOitems(Purchase_Order po) {
    String errorMsg = "";        
        this.LoadMySqlDriver();        

        try {            
            Connection c = DriverManager.getConnection(DB_Url, username, password);            
            Statement s = c.createStatement();            
            String Query1 = "Select * from po_lineitem where PO_id='" + po.getPO_id() + "'";            
            ResultSet rset = s.executeQuery(Query1);            
            while (rset.next()) {
                ////String PO_id, String Prod_Serv_id, int P_Quantity, double P_Price, double P_total, String PO_createdby
                PO_lineitem pline = new PO_lineitem(rset.getString(1), rset.getString(3), rset.getInt(4), rset.getDouble(5),rset.getDouble(6), rset.getString(2));
                po_line.add(pline);
                
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        return "my_purchase_order_line_item";
}
    
    
}
