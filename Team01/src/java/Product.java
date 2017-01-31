/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nidhi
 */
public class Product {
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
  
private boolean selected;

   

    public Product(String P_id, String P_Name, String P_Description, double P_Price, int P_Quantity, String P_supplier, String Category, String P_image, String P_image2, String P_image3, String orderType) {
        this.P_id = P_id;
        this.P_Name = P_Name;
        this.P_Description = P_Description;
        this.P_Price = P_Price;
        this.P_Quantity = P_Quantity;
        this.P_supplier = P_supplier;
        this.Category = Category;
        this.P_image= P_image;
        this.P_image2=P_image2;
        this.P_image3=P_image3;
        this.orderType=orderType;
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
    
     public String getP_image() {
        return P_image;
    }

    public void setP_image(String P_image) {
        this.P_image = P_image;
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

    public void Product(String P_searchCriteria) {
        this.P_searchCriteria = P_searchCriteria;
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

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }    
}
