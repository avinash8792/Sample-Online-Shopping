/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author agarwaln8497
 */
@ManagedBean
@SessionScoped
public class Reset {

    private String newpwd;
    private String retypenewpwd;

    public User User;

    public String getNewpwd() {
        return newpwd;
    }

    public void setNewpwd(String newpwd) {
        this.newpwd = newpwd;
    }

    public String getRetypenewpwd() {
        return retypenewpwd;
    }

    public void setRetypenewpwd(String retypenewpwd) {
        this.retypenewpwd = retypenewpwd;
    }

    public User getUser() {
        return User;
    }

    public void setUser(User User) {
        this.User = User;
    }

    public String reset(String user_Id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return to internalError.xhtml
            return ("internalError");
        }
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/sankaa7561";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet rs1 = null;   //set of results
        String result = "";
        try {
            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();

            rs1 = statement.executeQuery("select * from user_account where password = '"+user_Id+"'");
            
            User = new User(this.newpwd, this.retypenewpwd);
            if (newpwd != null && !newpwd.isEmpty() && retypenewpwd != null && !retypenewpwd.isEmpty()) {

                System.out.println("Reset password successful");

                result = "index";
            } else {
                result = "Password cannot be reset";
            }
            return result;
        } catch (SQLException e) {
            e.printStackTrace();
            return ("internalError");
        }
        finally {
            try {
                rs1.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void validatePassword(FacesContext context, UIComponent toValidate, Object value) {
        String confirm = (String) value;
        UIInput passComp = (UIInput) toValidate.getAttributes().get("passwordComponent");
        String password = (String) passComp.getValue();
        if (password != null && !password.isEmpty() && confirm != null && !confirm.isEmpty() && !password.equals(confirm)) {
            FacesMessage message = new FacesMessage("Password and Confirm Password Should match");
            throw new ValidatorException(message);
        }
    }

}
