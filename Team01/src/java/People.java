/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author krish
 */
public class People {
    
    private String FirstName;
    private String LastName;
    private String UserId;
    private String Password;
    private String UserRole;
    private String Phone;
    private String SecurityQuestion;
    private String SecAnw1;
    private String SecurityQuestion2;
    private String SecAnw2;
    private String status;
    private String ad1;
    private String ad2;
    private String city;
    private String state;
    private String zip;
    private int loginattempt;

    public String getAd1() {
        return ad1;
    }

    public void setAd1(String ad1) {
        this.ad1 = ad1;
    }

    public String getAd2() {
        return ad2;
    }

    public void setAd2(String ad2) {
        this.ad2 = ad2;
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
    
    

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getLoginattempt() {
        return loginattempt;
    }

    public void setLoginattempt(int loginattempt) {
        this.loginattempt = loginattempt;
    }
    
    

    public People(String FirstName, String LastName, String UserId, String Password, String UserRole, String Phone, String SecurityQuestion, String SecAnw1, String SecurityQuestion2, String SecAnw2,String status,int loginattempt,String ad1,String ad2,String city,String state,String zip) {
        this.FirstName = FirstName;
        this.LastName = LastName;
        this.UserId = UserId;
        this.Password = Password;
        this.UserRole = UserRole;
        this.Phone = Phone;
        this.SecurityQuestion = SecurityQuestion;
        this.SecAnw1 = SecAnw1;
        this.SecurityQuestion2 = SecurityQuestion2;
        this.SecAnw2 = SecAnw2;
        this.status = status;
        this.loginattempt = loginattempt;
        this.ad1 = ad1;
        this.ad2 = ad2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public String getUserId() {
        return UserId;
    }

    public void setUserId(String UserId) {
        this.UserId = UserId;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public String getUserRole() {
        return UserRole;
    }

    public void setUserRole(String UserRole) {
        this.UserRole = UserRole;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getSecurityQuestion() {
        return SecurityQuestion;
    }

    public void setSecurityQuestion(String SecurityQuestion) {
        this.SecurityQuestion = SecurityQuestion;
    }

    public String getSecAnw1() {
        return SecAnw1;
    }

    public void setSecAnw1(String SecAnw1) {
        this.SecAnw1 = SecAnw1;
    }

    public String getSecurityQuestion2() {
        return SecurityQuestion2;
    }

    public void setSecurityQuestion2(String SecurityQuestion2) {
        this.SecurityQuestion2 = SecurityQuestion2;
    }

    public String getSecAnw2() {
        return SecAnw2;
    }

    public void setSecAnw2(String SecAnw2) {
        this.SecAnw2 = SecAnw2;
    }

    
    
    
}
