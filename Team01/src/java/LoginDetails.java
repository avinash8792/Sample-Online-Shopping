/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mohammed
 */
public class LoginDetails {
    
    private String userName;
    private String password;
    private String q1;
    private String q2;
    private String status;
    private int login_attempt;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLogin_attempt() {
        return login_attempt;
    }

    public void setLogin_attempt(int login_attempt) {
        this.login_attempt = login_attempt;
    }
    

    public String getQ1() {
        return q1;
    }

    public void setQ1(String q1) {
        this.q1 = q1;
    }

    public String getQ2() {
        return q2;
    }

    public void setQ2(String q2) {
        this.q2 = q2;
    }
    
    private String accountType;
    
     public LoginDetails(String u,String q1,String q2){
        this.userName = u;
        
        this.q1 = q1;
        this.q2 = q2;
        //this.accountType = at;
    }
    public LoginDetails(String u,String p){
        this.userName = u;
        this.password = p;
        //this.accountType = at;
    }
    public LoginDetails(String st,int la){
        this.status = st;
        this.login_attempt = la;
        //this.accountType = at;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }
    
    
}
