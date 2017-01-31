
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Nidhi
 */
public class Purchase_Order {

    private String PO_id;
    private String PO_sender;
    private String PO_receiver;
    private String PO_gen_date;
    private String PO_app_date;
    private String PO_status;
    private String PO_status_Description;
    

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

    public Purchase_Order(String PO_id, String PO_sender, String PO_receiver, String PO_status) {
        this.PO_id = PO_id;
        this.PO_sender = PO_sender;
        this.PO_receiver = PO_receiver;
        this.PO_status = PO_status;
    }
     public Purchase_Order(String PO_id, String PO_sender, String PO_receiver, String PO_gen_date, String PO_app_date, String PO_status, String PO_status_Description) {
        this.PO_id = PO_id;
        this.PO_sender = PO_sender;
        this.PO_receiver = PO_receiver;
        this.PO_gen_date = PO_gen_date;
        this.PO_app_date = PO_app_date;
        this.PO_status = PO_status;
        this.PO_status_Description = PO_status_Description;
    }
    
    
}
