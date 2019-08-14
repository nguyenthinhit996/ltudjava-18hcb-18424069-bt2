/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DTO;

/**
 *
 * @author peter
 */
public class AccountSchoolDTO {
    private String nameshow;
    private String namelogin;
    private String password;
    private int status;

    public AccountSchoolDTO(String nshow,String namelogin,String pass, int Sta){
        this.nameshow=nshow;
        this.namelogin=namelogin;
        this.password=pass;
        this.status=Sta;
    }
    
    public AccountSchoolDTO(String [] ds){
        if(ds.length == 4){
            this.nameshow=ds[0];
            this.namelogin=ds[1];
            this.password=ds[2];
            this.status=Integer.valueOf(ds[3]);
        }
    }
    
    
    /**
     * @return the nameshow
     */
    public String getNameshow() {
        return nameshow;
    }

    /**
     * @param nameshow the nameshow to set
     */
    public void setNameshow(String nameshow) {
        this.nameshow = nameshow;
    }

    /**
     * @return the namelogin
     */
    public String getNamelogin() {
        return namelogin;
    }

    /**
     * @param namelogin the namelogin to set
     */
    public void setNamelogin(String namelogin) {
        this.namelogin = namelogin;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }
    
    public String tostring(){
        StringBuilder str= new StringBuilder();
        str.append(this.nameshow);
        str.append(",");
        str.append(this.namelogin);
        str.append(",");
        str.append(this.password);
        str.append(",");
        str.append(String.valueOf(this.status));
        return str.toString();
    }
}
