/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.BLL;

import excerciseone.DAL.AccountSchoolDAL;
import excerciseone.DTO.AccountSchoolDTO;
import java.util.Iterator;
import org.apache.commons.lang3.StringUtils;
 
 

/**
 *
 * @author peter
 */
public class Frm0001BLL {
    private String name;
    private String pass;
    
    public Frm0001BLL(String name,String p){
        this.name=name;
        this.pass=p;
    }
    
    public AccountSchoolDTO checkLogin(){
        if(StringUtils.isNotBlank(this.name) && StringUtils.isNotBlank(this.pass)){
            AccountSchoolDAL abc= new AccountSchoolDAL();
            Iterator<AccountSchoolDTO> in=abc.getAllAccount().iterator();
            while(in.hasNext()){
                AccountSchoolDTO accountSchool=in.next();
                if(accountSchool.getNamelogin().equals(this.name) && 
                    accountSchool.getPassword().equals(this.pass)){
                    return accountSchool;
                }
            }
        }
        return null;
    }
    
    public static void main(String[] args) {
       AccountSchoolDAL abc= new AccountSchoolDAL();
       Iterator<AccountSchoolDTO> in=abc.getAllAccount().iterator();
       while(in.hasNext()){
           System.out.print(in.next().getNamelogin()+ " ");
       }
       
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }
}
