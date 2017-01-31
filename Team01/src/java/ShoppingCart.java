/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static com.sun.xml.bind.util.CalendarConv.formatter;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author avikiran
 */
@Named(value = "shoppingCart")
@SessionScoped
public class ShoppingCart implements Serializable {

    /**
     * Creates a new instance of ShoppingCart
     */
    
     //private static ArrayList<selectedProduct> cart = new ArrayList<selectedProduct>();
     private  ArrayList<selectedProduct> cart = new ArrayList<>();
     
     private int po = 0;        
     private double total; 

     
     Date today = new Date();
     DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
     String dt1 = df.format(today);
     //DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
    //Date date = formatter.parse(dt1);		


    public int getPo() {
        return po;
    }

    public void setPo(int po) {
        this.po = po;
    }
    
    public ShoppingCart() {
    }
    
    public String addToCart(ArrayList<Product> pr){
      
       for(int i=0;i<pr.size();i++){
            boolean flag = false;
           if(pr.get(i).isSelected()){
               for(selectedProduct sp: getCart()){
                 if(sp.getProd().getP_id().equals(pr.get(i).getP_id()))  {
                     sp.setQuantity(String.valueOf(sp.getQuantity()+1));
                      //return "shopping_cart";
                      flag = true;
                      break;
                 }
               }
               if(flag == false){
               selectedProduct sp = new selectedProduct();
               sp.setQuantity(String.valueOf(1));
               sp.setProd(pr.get(i));
               cart.add(sp);
               }
           }
       }
       
       
       return "shopping_cart";
   }    
    
    public String addCart(Product p){
        boolean flag = false;
        for(selectedProduct sp: getCart()){
            if(sp.getProd().getP_id()==p.getP_id()){
                sp.setQuantity(String.valueOf(sp.getQuantity()+1));
                flag = true;
                break;
            }
           
        }
         if(flag == false){
               selectedProduct sp = new selectedProduct();
        sp.setQuantity(String.valueOf(1));
        sp.setProd(p);
        cart.add(sp);
               } 
        
        return "shopping_cart";
    }
    
    public void deleteItem(selectedProduct sp){
        
        for(selectedProduct s : cart){
            if(s.equals(sp)){
                cart.remove(s);
                break;
            }
        }        
    }
    
    public double getTotal() {
        total =0;
        
        for(selectedProduct s : cart){
           // total = total+ (s.getProd().getP_Quantity()*s.getProd().getP_Price());
            total = total + (s.getProducttotal());
        }
        
        return total;
    }
    
     public  ArrayList<selectedProduct> getCart() {
        return cart;
    }

    public  void setCart(ArrayList<selectedProduct> cart) {
      this.cart = cart;
    }
    

    public void setTotal(double total) {
        this.total = total;
    }
    
    
    public String createOrder(String userName) {
        //load the driver
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            return ("internalError");
        }

        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/sankaa7561";

        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet resultSet = null;   //set of results

        try {
            //connect to the database
            connection = DriverManager.getConnection(DATABASE_URL, "sankaa7561", "1457744");

            //create a statement
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select max(PO_id) from purchase_order");

            if (resultSet.next()) {
                po = resultSet.getInt(1) + 1;
                //statement.executeUpdate("insert into purchase_order(PO_id, PO_sender, PO_receiver, PO_gen_date, PO_status, PO_description)" + "values ('" + (po) + "','" + userName + "','"+ cart.get(0).getProd().getP_supplier() +"','"+ (today) +"','Pending','"+po+" + "+_+userName+_+" + "+cart.get(0).getProd().getP_supplier()+"')");
                
                System.out.println("1:" + dt1);
			System.out.println("2:" + cart.get(0).getProd().getP_supplier());
                
                    statement.executeUpdate("insert into purchase_order(PO_id, PO_sender, PO_receiver, PO_gen_date, PO_status) values ('" + (po) + "','" + userName + "','"+ cart.get(0).getProd().getP_supplier() +"','"+dt1+"','pending')");
                   
                    for (int i = 0; i < cart.size(); i++) {
                    statement.executeUpdate("insert into po_lineitem(po_id, PO_sender, Prod_Serv_id, P_Quantity, P_Price, P_total, PO_createdby) values ('" + po + "','" + userName + "','" + cart.get(i).getProd().getP_id() + "','" + cart.get(i).getProd().getP_Quantity() + "','" + cart.get(i).getProd().getP_Price() + "','" + (cart.get(i).getProd().getP_Price() * cart.get(i).getProd().getP_Quantity()) + "','" + userName + "')");
                }
            } else {
                statement.executeUpdate("insert into purchase_order(PO_id, PO_sender, PO_receiver, PO_gen_date, PO_status) values('1','" + userName + "','"+ cart.get(0).getProd().getP_supplier() +"','"+dt1+"','pending')");

                for (int i = 0; i < cart.size(); i++) {
                    statement.executeUpdate("insert into po_lineitem(po_id, PO_sender, Prod_Serv_id, P_Quantity, P_Price, P_total, PO_createdby) values ('1','" + userName + "','" + cart.get(i).getProd().getP_id() + "','" + cart.get(i).getProd().getP_Quantity() + "','" + cart.get(i).getProd().getP_Price() + "','" + (cart.get(i).getProd().getP_Price() * cart.get(i).getProd().getP_Quantity()) + "','" + userName + "')");
                }
            }
            return "purchaseorder";

        } catch (SQLException e) {

            e.printStackTrace();
            return ("Internal Error. Please Try Again Later");
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
    
    
    
}
