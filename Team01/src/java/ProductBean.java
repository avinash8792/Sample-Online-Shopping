
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

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
public class ProductBean {
    
    private String P_id;
    private String P_Name;
    private String P_Description;
    private double P_Price;
    private int P_Quantity;
    private String P_searchCriteria;
    private String criteria1;
    private String P_supplier;
    private String Category;
    private String P_image;
    private String P_image2;
    private String P_image3;
    private String orderType;
    private ArrayList<Product> pv = new ArrayList<Product>();
    private ArrayList<String> cat = new ArrayList<String>();
    ArrayList<selectedProduct> selectedProdList;

    public ArrayList<selectedProduct> getSelectedProdList() {
        return selectedProdList;
    }

    public void setSelectedProdList(ArrayList<selectedProduct> selectedProdList) {
        this.selectedProdList = selectedProdList;
    }   
    
    
    String DB_Url = "jdbc:mysql://mis-sql.uhcl.edu/sankaa7561";
    String username = "sankaa7561";
    String password = "1457744";
    
    
    final String emailid = "team01.isam5338.java123@gmail.com";
    final String emailpwd = "team01.isam5338";

    public void LoadMySqlDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver is ok.");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public ProductBean() {

        SearchAll();
        loadCategories();
    }

    public ArrayList<Product> getPv() {
        return pv;
    }

    public void setPv(ArrayList<Product> pv) {
        this.pv = pv;
    }

    ArrayList<Product> p = new ArrayList<Product>();
    Product pr = new Product(P_id, P_Name, P_Description, P_Price, P_Quantity, P_supplier, Category, P_image, P_image2, P_image3, orderType);

    public Product getPr() {
        return pr;
    }

    public void setPr(Product pr) {
        this.pr = pr;
    }

    public String getP_image2() {
        return P_image2;
    }

    public void setP_image2(String P_image2) {
        this.P_image2 = P_image2;
    }

    public String getP_image3() {
        return P_image3;
    }

    public void setP_image3(String P_image3) {
        this.P_image3 = P_image3;
    }

    public ArrayList<Product> getP() {
        return p;
    }

    public void setP(ArrayList<Product> p) {
        this.p = p;
    }

    public String getP_id() {
        return P_id;
    }

    public void setP_id(String P_id) {
        this.P_id = P_id;
    }

    public String getP_Name() {
        return P_Name;
    }

    public void setP_Name(String P_Name) {
        this.P_Name = P_Name;
    }

    public String getP_Description() {
        return P_Description;
    }

    public void setP_Description(String P_Description) {
        this.P_Description = P_Description;
    }

    public double getP_Price() {
        return P_Price;
    }

    public void setP_Price(double P_Price) {
        this.P_Price = P_Price;
    }

    public int getP_Quantity() {
        return P_Quantity;
    }

    public void setP_Quantity(int P_Quantity) {
        this.P_Quantity = P_Quantity;
    }

    public String getP_searchCriteria() {
        return P_searchCriteria;
    }

    public void setP_searchCriteria(String P_searchCriteria) {
        this.P_searchCriteria = P_searchCriteria;
    }

    public String getCriteria1() {
        return criteria1;
    }

    public void setCriteria1(String criteria1) {
        this.criteria1 = criteria1;
    }

    public String getP_supplier() {
        return P_supplier;
    }

    public void setP_supplier(String P_supplier) {
        this.P_supplier = P_supplier;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getP_image() {
        return P_image;
    }

    public void setP_image(String P_image) {
        this.P_image = P_image;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public ArrayList<String> getCat() {
        return cat;
    }

    public void setCat(ArrayList<String> cat) {
        this.cat = cat;
    }

    

    public String search() {
        //SearchAll();
        if (Category != null && Category.length() > 0 && P_supplier != null && P_supplier.length() > 0) {
            p = SearchByCatnSup(Category, P_supplier);
        } else if (Category != null && Category.length() > 0) {
            p = SearchByCategory(Category);
        } else if (P_supplier != null && P_supplier.length() > 0) {
            p = SearchBySupplier(P_supplier);
        } 
        else if (criteria1.equals("Select...") && (orderType.equals("Material"))) {
            return SearchAllMaterials();
        }
        else if (criteria1.equals("Select...") && (orderType.equals("Service"))) {
            return SearchAllServices();
        }        
        else if (!criteria1.equals("Select...") && (!orderType.equals("Select..."))) {
            if (criteria1.equals("Name")) {
                p = SearchByName(P_searchCriteria, orderType);
            } else if (criteria1.equals("Description")) {
                p = SearchByDesc(P_searchCriteria, orderType);
            } else if (criteria1.equals("Supplier")) {
                p = SearchBySupplier2(P_searchCriteria, orderType);
            }
        } 
        
        else {
            return SearchAll();
        }

        for (int i = 0; i < p.size(); i++) {
            pr = new Product(p.get(i).getP_id(), p.get(i).getP_Name(), p.get(i).getP_Description(), p.get(i).getP_Price(), p.get(i).getP_Quantity(), p.get(i).getP_supplier(), p.get(i).getCategory(), p.get(i).getP_image(), p.get(i).getP_image2(), p.get(i).getP_image3(), p.get(i).getOrderType());
        }
        return "Prod_List";
    }

    public ArrayList<Product> SearchByCatnSup(String cat, String sup) {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        ArrayList<Product> plist = jdbc1.SearchByCatnSup(prod, cat, sup);
        return plist;
    }

    public ArrayList<Product> SearchByCategory(String cat) {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        ArrayList<Product> plist = jdbc1.SearchByCategory(prod, cat);
        return plist;
    }

    public ArrayList<Product> SearchByName(String c, String o) {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        ArrayList<Product> plist = jdbc1.SearchByName(prod, c, o);
        return plist;
    }

    public ArrayList<Product> SearchByDesc(String c, String o) {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        ArrayList<Product> plist2 = jdbc1.SearchByDesc(prod, c, o);
        return plist2;
    }

    public ArrayList<Product> SearchBySupplier(String c) {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        ArrayList<Product> plist3 = jdbc1.SearchBySupplier(prod, c);
        return plist3;
    }
    
    public ArrayList<Product> SearchBySupplier2(String c, String o) {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        ArrayList<Product> plist3 = jdbc1.SearchBySupplier2(prod, c, o);
        return plist3;
    }

    public String SearchAll() {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        //private ArrayList<Product> pv = new ArrayList<Product>();
        p = jdbc1.SearchAll();
        return "Prod_List";
    }
    
    public String SearchAllServices() {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        //private ArrayList<Product> pv = new ArrayList<Product>();
        p = jdbc1.SearchAllServices();
        return "Prod_List";
    }
    
    public String SearchAllMaterials() {
        Product prod = new Product(this.P_id, this.P_Name, this.P_Description, this.P_Price, this.P_Quantity, this.P_supplier, this.Category, this.P_image, this.P_image2, this.P_image3, this.orderType);
        myJdbcLayer jdbc1 = new myJdbcLayer();
        //private ArrayList<Product> pv = new ArrayList<Product>();
        p = jdbc1.SearchAllMaterials();
        return "Prod_List";
    }

    public void loadCategories() {
        String errorMsg = "";
        this.LoadMySqlDriver();

        try {
            Connection c = DriverManager.getConnection(DB_Url, username, password);
            Statement s = c.createStatement();
            String Query1 = "Select category_name from category";
            //System.out.println("1-----------");
            ResultSet rset = s.executeQuery(Query1);
            while (rset.next()) {
                cat.add(rset.getString(1));
            }
        } catch (SQLException e) {
            errorMsg = e.getMessage();
        }
        //return arr_prod;
    }

    public String getProdDet(Product s) {
        System.out.println("Checking: " + s.getP_Name());
        P_Name = s.getP_Name();
        P_Description = s.getP_Description();
        P_Price = s.getP_Price();
        P_image = s.getP_image();
        P_image2 = s.getP_image2();
        P_image3 = s.getP_image3();
        P_supplier = s.getP_supplier();
        orderType = s.getOrderType();
        pv.add(s);
        return "ProdDet";
    }

    public void clear() {
        //System.out.println("favCoffee3:" + favCoffee3);
        SearchAll();
        criteria1 = null;
        P_searchCriteria = null;
        Category = null;
        P_supplier = null;
        orderType = null;
    }
    
//   public String selectedProductsList(ArrayList<Product> platest){
//        // Get selected items.
//        
//        selectedProdList = new ArrayList<selectedProduct>();
//        p = new ArrayList<Product>();
//        
//        System.out.println("Checking--------");
//        
//        for (int i=0; i<platest.size(); i++) {
//            if (platest.get(i).isCheck()) {
//                System.out.println("Checking boolean for " + i + ":" +platest.get(i).isCheck());
//                System.out.println("Checking 2 --- " + platest.get(i).getP_Name());                
//                selectedProduct sp = new selectedProduct();
//                Product psp = new Product(platest.get(i).getP_id(),platest.get(i).getP_Name(),platest.get(i).getP_Description(),platest.get(i).getP_Price(),platest.get(i).getP_Quantity(),platest.get(i).getP_supplier(),platest.get(i).getCategory(),platest.get(i).getP_image(),platest.get(i).getP_image2(),platest.get(i).getP_image3(),platest.get(i).getOrderType());
//                //String P_id, String P_Name, String P_Description, double P_Price, int P_Quantity, String P_supplier, String Category, String P_image, String P_image2, String P_image3, String orderType
//                sp.setProd(psp);
//                sp.setProducttotal(platest.get(i).getP_Quantity()*platest.get(i).getP_Price());
//                sp.setQuantity(platest.get(i).getP_Quantity());
//                selectedProdList.add(sp);
//                //platest.get(i).setCheck(false); // Reset.
//            }
//        }
//        
//        
//        return "shopping_cart";
//    }
    
    public String sendSuggestions(){
        
        Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");
                props.put("mail.smtp.ssl.trust", "smtp.gmail.com");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailid, emailpwd);
			}
		  });
                
                try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailid));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("team01.isam5338.java@gmail.com"));
			message.setSubject("Email to Subscribe");
			message.setText("Dear Team,"
				+ "\n\n I would like to subscribe to your new products email notification service for twelve months!");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
        
        return "Prod_List";
    }
    
}
