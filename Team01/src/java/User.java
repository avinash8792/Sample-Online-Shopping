/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author agarwaln8497
 */
public class User {
    private String newpwd;
    private String retypenewpwd;

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

    public User(String newpwd, String retypenewpwd) {
        this.newpwd = newpwd;
        this.retypenewpwd = retypenewpwd;
    }
}
