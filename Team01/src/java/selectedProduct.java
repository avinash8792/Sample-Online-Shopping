/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author avikiran
 */
public class selectedProduct {
     private Product _prod;
    private int quantity;
    private double producttotal;

    public double getProducttotal() {
       
        this.producttotal = (getProd().getP_Price())*(getQuantity());
        
        
        return producttotal;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setProducttotal(double producttotal) {
        this.producttotal = producttotal;
    }

    public Product getProd() {
        return _prod;
    }

    public void setProd(Product _prod) {
        this._prod = _prod;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity =Integer.parseInt(quantity);
    }
    
    
}
