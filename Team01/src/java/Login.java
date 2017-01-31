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
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Mohammed
 */
@ManagedBean
@SessionScoped
public class Login {

    private String userId;
    private String password;
    private String userRole;
    private String firstName;
    private String lastName;
    private String q1;
    private String a1;
    private String q2;
    private String a2;
    private String phoneNumber;
    private String confirmation;
    private String blockpage;
    private String newPassword;
    private String confirmPassword;
    private String result = "";
	private String address1;
    private String address2;
    private String city;
    private String state;
    private String zip;
    private String loginResult = "";
    private String userNameError="";
    private String userPasswordError="";
    private String securityQuestionError="";

    public String getUserPasswordError() {
        return userPasswordError;
    }

    public void setUserPasswordError(String userPasswordError) {
        this.userPasswordError = userPasswordError;
    }

    public String getSecurityQuestionError() {
        return securityQuestionError;
    }

    public void setSecurityQuestionError(String securityQuestionError) {
        this.securityQuestionError = securityQuestionError;
    }
    
    

    public String getUserNameError() {
        return userNameError;
    }

    public void setUserNameError(String userNameError) {
        this.userNameError = userNameError;
    }
    
    

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }
    
    

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
    
    
    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    
    public String getBlockpage() {
        return blockpage;
    }

    public void setBlockpage(String blockpage) {
        this.blockpage = blockpage;
    }
    
    

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getA1() {
        return a1;
    }

    public void setA1(String a1) {
        this.a1 = a1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }

    public String getA2() {
        return a2;
    }

    public void setA2(String a2) {
        this.a2 = a2;
    }

    public String getConfirmation() {
        return confirmation;
    }

    public void setConfirmation(String confirmation) {
        this.confirmation = confirmation;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public LoginDetails loginDetails;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LoginDetails getLoginDetails() {
        return loginDetails;
    }

    public void setLoginDetails(LoginDetails loginDetails) {
        this.loginDetails = loginDetails;
    }
	
	public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }
    
    

    public String login() {
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
        ResultSet resultSet = null;   //set of results
        ResultSet resultSet1 = null;
        try {

            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();

            resultSet = statement.executeQuery("select * from user_account "
                    + "where userId = '" + userId + "'");
            String userRole1 = "buyer_user";
            String userRole2 = "buyer_admin";
            String userRole3 = "supplier_user";
            String userRole4 = "supplier_admin";
            String userRole5 = "bUser_bAdmin";
            String status = "";
            int loginattempt = 0;
            int loginattempt_updated = 0;
            if (resultSet.next()) {
				this.phoneNumber = resultSet.getString(6);
                status = resultSet.getString(11);
                loginattempt = resultSet.getInt(12);
                if (password.equals(resultSet.getString(4))) {
                    if ((status.equals("active")) && (loginattempt < 5)) {
                        loginattempt = 0;
                        //int r = statement.executeUpdate("UPDATE user_account SET loginattempt = '" + loginattempt + "' WHERE userId = '" + userId + "'");
                    
                        loginDetails = new LoginDetails(this.userId, this.password);
                        firstName = resultSet.getString(1);
                        lastName = resultSet.getString(2);

                        if (resultSet.getString(5).equals(userRole1)) {

                            confirmation = "Prod_List";
                        }
                        if (resultSet.getString(5).equals(userRole2)) {
                            confirmation = "BuyerAdmin";
                        }
                        if (resultSet.getString(5).equals(userRole5)) {
                            confirmation = "Buyer_User_Admin";
                        }
                        if (resultSet.getString(5).equals(userRole3)) {
                            confirmation = "SupplierUser";
                        }
                        if (resultSet.getString(5).equals(userRole4)) {
                            confirmation = "SupplierAdmin";
                        }
                          int p = statement.executeUpdate("UPDATE user_account SET loginattempt = '" + loginattempt + "' WHERE userId = '" + userId + "'");
                    
                    }
                    else
                    {
                        loginDetails = new LoginDetails(status,loginattempt);
                        confirmation="StatusBlocked";
                    }
                    return confirmation;
                }
                else {
                    if(loginattempt >= 4)
                    {
                        
                        loginattempt = loginattempt + 1;
                        status = "blocked";
                        loginDetails = new LoginDetails(status,loginattempt);
                    int q = statement.executeUpdate("UPDATE user_account SET status ='blocked', loginattempt='"+loginattempt+"' WHERE userId = '"+ userId+"'");
                    blockpage="StatusBlocked";
                    }
                    
                    
                    
                    else
                    {   loginattempt = loginattempt + 1;
                        int r = statement.executeUpdate("UPDATE user_account SET loginattempt = '" + loginattempt + "' WHERE userId = '" + userId + "'");
                    blockpage= "index.xhtml";
                    
                    }
                    //display loginNotOK.xhtml
                    loginResult = "Invalid Password!!!";
                    return blockpage;
                }
            } else {
                userId = "";
                password = "";
                loginResult = "Invalid userid !!! ";
                //display loginNotOK.xhtml
                return "index.xhtml";
            }
//        loginDetails = new LoginDetails(this.userId,this.password);
//        if(userId!=null &&  !userId.isEmpty() && password!=null && !password.isEmpty())
//        {
//        
//           return "HomePage";
//        }
//        else
//        {
//           return "Registration failed!!!";
//        }
        } catch (SQLException e) {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
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
	
	public String updateProfilePassword(){
       
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
        ResultSet resultSet = null;   //set of results
       // ResultSet resultSet1 = null;
        try {

            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();
            
            resultSet = statement.executeQuery("select * from user_account where userId = '"+userId+"'");
            
            if(resultSet.next())
            {
                if(resultSet.getString(4).equals(password))
                {
                      int z = statement.executeUpdate("UPDATE user_account SET firstName = '"+firstName+"',"
                              + "lastName='"+lastName+"',phoneNumber='"+phoneNumber+"',userId='"+userId+"',"
                              + "address1='"+address1+"',address2='"+address2+"',city='"+city+"',state='"+state+"',zip='"+zip+"',"
                              + "password = '"+newPassword+"' WHERE userId = '"+ userId+"'");    
                }
                else
                {
                  return "ProfileUpdatedFailed";
                    
                 //   JOptionPane.showInternalMessageDialog(null, "Your current password is invalid","Wrong Password",JOptionPane.ERROR_MESSAGE);
                }
            }
            
            //int q = statement.executeUpdate("UPDATE user_account SET password='"+password+"' WHERE userId = '"+ userId+"'");
            }
        
        
        catch (SQLException e) {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        } finally {
            try {
                resultSet.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return "ProfileUpdatedSuccessfully";
    }

    public String forgotpassword() {
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
        ResultSet rs = null;   //set of results

        try {

            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();

            rs = statement.executeQuery("select * from user_account "
                    + "where userId = '" + userId + "'");

            if (rs.next()) {
                q1 = rs.getString(7);
                q2 = rs.getString(9);
                loginDetails = new LoginDetails(this.userId, this.q1, this.q2);
                return "SecurityQuestions";
            } else {
                userId = "";
                password = "";
                //display loginNotOK.xhtml
                userPasswordError = "Invalid UserId!!!";
                return "ForgotPassword";
            }

        } catch (SQLException e) {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String validateSecurityQuestion() {
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
        ResultSet rs = null;   //set of results

        try {

            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();

            rs = statement.executeQuery("select * from user_account "
                    + "where userId = '" + userId + "'");

            if (rs.next()) {
                if ((a1.equals(rs.getString(8))) && (a2.equals(rs.getString(10)))) {
                    password = rs.getString(4);
                    loginDetails = new LoginDetails(this.userId, this.password);
                    int q = statement.executeUpdate("UPDATE user_account SET status ='active', loginattempt='0' WHERE userId = '"+ userId+"'");
                    
                    return "Password";
                } else {
                    userId = "";
                    // password = "";
                    //display loginNotOK.xhtml
                    //result = "Your annswer's is not correct";
                    securityQuestionError ="Please provide correct answer(s).";
                    return "SecurityQuestions";
                }
            } else {
                userId = "";
                //  password = "";
                //display loginNotOK.xhtml
                securityQuestionError ="Please provide correct answer(s).";
                return "SecurityQuestions";
            }
        } catch (SQLException e) {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public String forgotUserName() {
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
        ResultSet rs = null;   //set of results

        try {

            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();

            rs = statement.executeQuery("select * from user_account "
                    + "where firstName = '" + firstName + "' and lastName = '" + lastName + "' and phoneNumber = '" + phoneNumber + "'");

            if (rs.next()) {
                
                userId = rs.getString(3);

                loginDetails = new LoginDetails(this.userId, this.password);
                return "UserName";
            } else {
                userNameError = " The details you provided are wrong. Please provide correct details.";
                return "ForgotUserName";
            }

        } catch (SQLException e) {
            //go to internalError.xhtml
            e.printStackTrace();
            return ("internalError");
        } finally {
            try {
                rs.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    
    public void reset(String u) {
        try {
            Class.forName("com.mysql.jdbc.Driver");

        } catch (Exception e) {
            e.printStackTrace();
            //return to internalError.xhtml
           // return ("internalError");
        }
        final String DATABASE_URL = "jdbc:mysql://mis-sql.uhcl.edu/sankaa7561";
        Connection connection = null;  //a connection to the database
        Statement statement = null;    //execution of a statement
        ResultSet rs1 = null;   //set of results
       // String result = "";
        try {
            connection = DriverManager.getConnection(DATABASE_URL,
                    "sankaa7561", "1457744");
            statement = connection.createStatement();

            rs1 = statement.executeQuery("select * from user_account where userId = '"+u+"'");
            
            if(rs1.next())
            {
                if(rs1.getString(4).equals(password))
                {
                    if(newPassword.equals(confirmPassword))
                    {
                      int z = statement.executeUpdate("UPDATE user_account SET password = '"+newPassword+"' WHERE userId = '"+ userId+"'");
                      result =  "Password is updated succesfully";
                    }
                    else
                    {
                        result = "Password and Confirm Password Should match";
                    }
                }
                else
                {
                    result = "Please enter valid current password!!!";
                }
            }
           // return result;
             } catch (SQLException e) {
            //go to internalError.xhtml
            e.printStackTrace();
           // return ("internalError");
        } finally {
            try {
                rs1.close();
                statement.close();
                connection.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        }
    public String signOut() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "index.xhtml";
    }
}
