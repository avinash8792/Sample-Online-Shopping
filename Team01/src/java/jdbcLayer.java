/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.*;
/**
 *
 * @author krish
 */
public class jdbcLayer {
    
    String url = "jdbc:mysql://mis-sql.uhcl.edu:3306/sankaa7561";
    String user = "sankaa7561";
    String pass = "1457744";
    
    public void loadMySqlDriver()
    {
        try{
        Class.forName("com.mysql.jdbc.Driver");
        }
        catch(Exception e)
        {
            
        }
    }
    
    public boolean saveUser(People p)
    {
        String Query ="INSERT INTO user_account(firstName,lastName,userId,password,userRole,phoneNumber,question1,answer1,question2,answer2,status,loginattempt,address1,address2,city,state,zip) values ("
                + "\""+p.getFirstName()+"\","+"\""+p.getLastName()+"\","
                +"\""+p.getUserId()+"\","+"\""+p.getPassword()+"\","+"\""+p.getUserRole()+"\","
                +"\""+p.getPhone()+"\","+"\""+p.getSecurityQuestion()+"\","+"\""+p.getSecAnw1()+"\","+"\""+p.getSecurityQuestion2()+"\","+"\""+p.getSecAnw2()+"\","+"\""+p.getStatus()+"\","+"\""+p.getLoginattempt()+"\","+"\""+p.getAd1()+"\","+"\""+p.getAd2()+"\","+"\""+p.getCity()+"\","+"\""+p.getState()+"\","+"\""+p.getZip()+"\""
                +")";
        boolean found = false;
        try{
            
            loadMySqlDriver();
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user_account where userId = '"+p.getUserId()+"'");
            if(rs.next()){
                found = true;
            }
            else
            {
                
            st.executeUpdate(Query);
            //int x=0;
            System.out.println("Value Inserted");
            found = false;
            }
            
           // con.close();
        }
        catch(Exception e)
        {
            e.getMessage();
        }
        return found;
    }
}
