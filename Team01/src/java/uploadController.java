/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.Part;

/**
 *
 * @author avikiran
 */
@Named(value = "uploadController")
@SessionScoped
public class uploadController implements Serializable {

    /**
     * Creates a new instance of uploadController
     */
    public uploadController() {
    }

    private Part file;
    private Part file2;
    private Part file3;

    private String p_id;
    private String p_name;
    private double p_price;
    private String p_category;
    private String p_supplier;
    private String p_desc;
private String p_ordertype;
    public Part getFile2() {
        return file2;
    }

    public String getP_ordertype() {
        return p_ordertype;
    }

    public void setP_ordertype(String p_ordertype) {
        this.p_ordertype = p_ordertype;
    }

    public void setFile2(Part file2) {
        this.file2 = file2;
    }

    public Part getFile3() {
        return file3;
    }

    public void setFile3(Part file3) {
        this.file3 = file3;
    }

    public String getP_desc() {
        return p_desc;
    }

    public void setP_desc(String p_desc) {
        this.p_desc = p_desc;
    }

    public String getP_supplier() {
        return p_supplier;
    }

    public void setP_supplier(String p_supplier) {
        this.p_supplier = p_supplier;
    }

    public String getP_category() {
        return p_category;
    }

    public void setP_category(String p_category) {
        this.p_category = p_category;
    }

    public int getP_qty() {
        return p_qty;
    }

    public void setP_qty(int p_qty) {
        this.p_qty = p_qty;
    }
    private int p_qty;

    public Part getFile() {
        return file;
    }

    public void setFile(Part file) {
        this.file = file;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public double getP_price() {
        return p_price;
    }

    public void setP_price(double p_price) {
        this.p_price = p_price;
    }
    final private String DB_Url = "jdbc:mysql://mis-sql.uhcl.edu:3306/sankaa7561";
    final private String userName = "sankaa7561";
    final private String password = "1457744";
    Connection con = null;
    PreparedStatement ps = null;
    Statement st = null;
    String query = "";
    ResultSet rs = null;
    ArrayList<Purchase_Order> polist_1 = new ArrayList<Purchase_Order>();

    public void loadMySQLDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is okay.");
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public String upload() {

        //  try {
        ServletContext path = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String realPath = path.getRealPath("/");
        System.out.println("Real path" + realPath);
//        System.out.println("initial path "+path);
        realPath = realPath.substring(0, realPath.indexOf("\\build"));
//        System.out.println("substring path "+path);
//        path=path+"\\web\\Resources\\images\\";
//        System.out.println("final path "+path);
        //realPath = realPath + "Resources\\images\\";
        realPath = realPath + "\\web\\resources\\product_images\\";
        System.out.println("new real path " + realPath);
        try {
            InputStream in = file.getInputStream();
            InputStream in2 = file2.getInputStream();
            InputStream in3 = file3.getInputStream();
//Files.copy(in, new File())
            byte[] data = new byte[in.available()];
            byte[] data2 = new byte[in2.available()];
            byte[] data3 = new byte[in3.available()];
            in.read(data);
            in2.read(data2);
            in3.read(data3);
            System.out.println(getFilename(file));
            FileOutputStream out = new FileOutputStream(new File(realPath + getFilename(file)));
            FileOutputStream out2 = new FileOutputStream(new File(realPath + getFilename(file2)));
            FileOutputStream out3 = new FileOutputStream(new File(realPath + getFilename(file3)));
            out.write(data);
            out2.write(data2);
            out3.write(data3);

            loadMySQLDriver();
            con = DriverManager.getConnection(DB_Url, userName, password);
            String query = "insert into product(P_id, P_Name, P_desc,P_price,P_qty,P_img,P_img2,P_img3,P_supplier,Category,ordertype) values (?,?,?,?,?,?,?,?,?,?,?);";
            ps = con.prepareStatement(query);
            ps.setString(1, p_id);
            ps.setString(2, p_name);
            ps.setString(3, p_desc);

            ps.setDouble(4, p_price);
            ps.setInt(5, p_qty);
            ps.setString(6, getFilename(file));
            ps.setString(7, getFilename(file2));
            ps.setString(8, getFilename(file3));
            ps.setString(9, p_supplier);
            ps.setString(10, p_category);
            ps.setString(11, p_ordertype);
                    
            ps.executeUpdate();
            ps.close();
            con.close();

            in.close();
            out.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
            finally{
            p_id=null;
            p_name=null;
            p_desc=null;
            p_price=0.0;
            p_qty=0;
            p_category=null;
            p_supplier=null;
            p_ordertype=null;
            
            
        }
        //----- Entering values to database -------
        return "addProduct.xhtml";

    }

    private static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                String filename = cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
                return filename.substring(filename.lastIndexOf('/') + 1).substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
            }
        }
        return null;
    }

    public String approvePO(String po_id) {
        loadMySQLDriver();
        try {
            con = DriverManager.getConnection(DB_Url, userName, password);
            query = "update purchase_order set PO_status=\"approved\" where PO_id=\"" + po_id + "\";";
            st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return "BuyerAdmin";
    }

    public String rejectPO(String po_id) {
        loadMySQLDriver();
        try {
            con = DriverManager.getConnection(DB_Url, userName, password);
            query = "update purchase_order set PO_status=\"rejected\" where PO_id=\"" + po_id + "\";";
            st = con.createStatement();
            st.executeUpdate(query);
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());

        }
        return "BuyerAdmin";
    }

    public ArrayList<Purchase_Order> retrievePO(String status) {
        loadMySQLDriver();
        try {
            con = DriverManager.getConnection(DB_Url, userName, password);
             if(status.equals("all")){
                  query = "select * from purchase_order;";
             }
             else{
                query = "select * from purchase_order where PO_status=\""+status+"\";"; 
             }
            // query = "select * from purchase_order where PO_status=\""+status+"\";";
           

            st = con.createStatement();
            rs = st.executeQuery(query);
            while (rs.next()) {
                Purchase_Order po = new Purchase_Order(rs.getString("PO_id"), rs.getString("PO_sender"), rs.getString("PO_receiver"), rs.getString("PO_gen_date"), rs.getString("PO_app_date"), rs.getString("PO_status"), rs.getString("PO_description"));
                polist_1.add(po);

            }
            st.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return polist_1;
    }
}
