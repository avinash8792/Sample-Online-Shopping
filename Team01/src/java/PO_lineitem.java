/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nidhi
 */
public class PO_lineitem {

    private String PO_id;
    private String Prod_Serv_id;
    private int P_Quantity;
    private double P_Price;
    private double P_total;
    private String PO_createdby;
    
    public PO_lineitem(String PO_id, String Prod_Serv_id, int P_Quantity, double P_Price, double P_total, String PO_createdby) {
        this.PO_id = PO_id;
        this.Prod_Serv_id = Prod_Serv_id;
        this.P_Quantity = P_Quantity;
        this.P_Price = P_Price;
        this.P_total = P_total;
        this.PO_createdby = PO_createdby;
    } 

    public String getPO_id() {
        return PO_id;
    }

    public void setPO_id(String PO_id) {
        this.PO_id = PO_id;
    }

    public String getProd_Serv_id() {
        return Prod_Serv_id;
    }

    public void setProd_Serv_id(String Prod_Serv_id) {
        this.Prod_Serv_id = Prod_Serv_id;
    }

    public int getP_Quantity() {
        return P_Quantity;
    }

    public void setP_Quantity(int P_Quantity) {
        this.P_Quantity = P_Quantity;
    }

    public double getP_Price() {
        return P_Price;
    }

    public void setP_Price(double P_Price) {
        this.P_Price = P_Price;
    }

    public double getP_total() {
        return P_total;
    }

    public void setP_total(double P_total) {
        this.P_total = P_total;
    }

    public String getPO_createdby() {
        return PO_createdby;
    }

    public void setPO_createdby(String PO_createdby) {
        this.PO_createdby = PO_createdby;
    }

}
