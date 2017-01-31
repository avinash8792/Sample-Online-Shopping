/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author avikiran
 */
@ManagedBean
@SessionScoped
public class buyerAdminJDBC {

    /**
     * Creates a new instance of buyerAdminJDBC
     */
    public buyerAdminJDBC() {
        
    }
    
    private String status_type;
    private boolean disable;

    public boolean isDisable() {
        return disable;
    }

    public void setDisable(boolean disable) {
        this.disable = disable;
    }
   
    

    public String getStatus_type() {
        return status_type;
    }

    public void setStatus_type(String status_type) {
        this.status_type = status_type;
    }

    public ArrayList<Purchase_Order> getPolist() {
        return polist;
    }

    public void setPolist(ArrayList<Purchase_Order> polist) {
        this.polist = polist;
    }
    private ArrayList<Purchase_Order> polist = new ArrayList<Purchase_Order>();

    public String search() {

        if (status_type.equals("all")) {
            polist = getPOonStatus("all");
        } else if (status_type.equals("pending")) {
            polist = getPOonStatus("pending");
        } else if (status_type.equals("approved")) {
            polist = getPOonStatus("approved");
        } else if (status_type.equals("rejected")) {
            polist = getPOonStatus("rejected");
        }

        return "BuyerAdmin";
    }

    public ArrayList<Purchase_Order> getPOonStatus(String status) {
        uploadController uc = new uploadController();
        polist = uc.retrievePO(status);
        return polist;
    }

    public boolean disableButton(String status){
        System.out.println(status);
        if(status.equals("pending")){
            disable=false;
        }
        else if(status.equals("approved") || status.equals("rejected")){
            disable=true;
        }
        return disable;
    }
}
