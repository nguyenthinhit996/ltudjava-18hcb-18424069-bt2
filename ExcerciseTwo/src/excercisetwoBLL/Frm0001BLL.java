/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoBLL;

import excercisetwoDAL.AccountDAL;
import exercisetwoDTO.AccountDTO;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author peter
 */
public class Frm0001BLL {
    private static String name;
    private static String pass;

    public Frm0001BLL() {
    }
 
    
    public static AccountDTO checkLogin(){
        if(StringUtils.isNotBlank(name) && StringUtils.isNotBlank(pass)){
            return AccountDAL.getAccountByAcc(name,pass);
        }
        return  null;
    }

    /**
     * @return the name
     */
    public static String getName() {
        return name;
    }

    /**
     * @param aName the name to set
     */
    public static void setName(String aName) {
        name = aName;
    }

    /**
     * @return the pass
     */
    public static String getPass() {
        return pass;
    }

    /**
     * @param aPass the pass to set
     */
    public static void setPass(String aPass) {
        pass = aPass;
    }
}
