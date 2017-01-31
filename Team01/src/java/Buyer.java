
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author agarwaln8497
 */
@ManagedBean
@SessionScoped
public class Buyer {

    private String supplierName;
    private String orderType;
    private String productName;
    public ProductDetails pDetails;

    public Buyer() {
    }
    
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

public Buyer(String supplierName, String orderType, String productName) {
        this.supplierName = supplierName;
        this.orderType = orderType;
        this.productName = productName;
    }

    public String search() {
        ProductDetails p = new ProductDetails();
        Buyer b = new Buyer(p.getSupplierName(), p.getOrderType(), p.getProductName());
        return "Buyer";
    }
}
