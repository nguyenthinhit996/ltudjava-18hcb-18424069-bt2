/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoBLL;

//import excerciseone.DAL.AccountSchoolDAL;
//import excerciseone.DAL.FileDAL;
//import excerciseone.DTO.AccountSchoolDTO;
import excercisetwoDAL.AccountDAL;
import exercisetwoDTO.AccountDTO;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author peter
 */
public class Common {
     public String getTimeCurrent(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss");
	Date date = new Date();
	return dateFormat.format(date);
    }
    
     
      public boolean changePassword(AccountDTO acc,String passold,String passnew){
        if(StringUtils.isNotBlank(passold) && StringUtils.isNotBlank(passnew)){
            if(acc.getPass().equals(passold)){
                acc.setPass(passnew);
                int in=AccountDAL.updateOrsave(acc);
                if(in==0){
                    return true;
                }
                return false;
            }
        }
        return false;
    }
    
    public static boolean isSubjectClass(String str){
        String regex="^.*_.*$";
        return str.matches(regex);
    }
    
    public static String getNameExceptExtension(String str){
       return str.replace(".txt","");
    }
    public static String getNameExceptHyphen(String str){
       return str.replaceAll("_.*$", "");
    }
    
    public static String getNameClass(String str){
        String ne=getNameExceptExtension(str);
        return getNameExceptHyphen(ne);
    }
    
    
    
     
    
}