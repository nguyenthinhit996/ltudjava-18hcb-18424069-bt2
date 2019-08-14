/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DAL;

import excerciseone.DTO.AccountSchoolDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter
 */
public class AccountSchoolDAL {
   
    
     public LinkedList<AccountSchoolDTO>getAllAccount(){
        LinkedList<AccountSchoolDTO> col = new LinkedList<>();
        try {
             String path ="account"+File.separator+"accountschool.txt";
            //FileDAL fileDAL= new FileDAL();
            FileDAL fileDAL= new FileDAL(path);
            System.out.println(path);
            BufferedReader br=fileDAL.createBufferedReader();
            String strcurrent;
            while((strcurrent=br.readLine()) != null){
                String[] arrstr=strcurrent.split(",");
                if(arrstr.length == 4){
                    AccountSchoolDTO news= new AccountSchoolDTO(arrstr[0],arrstr[1],arrstr[2],Integer.valueOf(arrstr[3]));
                    col.add(news);
                }else{
                    return null;
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(FileDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return col;
    }
   
    public void writeAllAccount(LinkedList<AccountSchoolDTO> col){
         try {
             FileDAL fileDal= new FileDAL("account"+File.separator+"accountschool.txt");
             BufferedWriter bufferedWriter=fileDal.createBufferwriter();
             // detele content file
             bufferedWriter.write("");
             Iterator<AccountSchoolDTO> in=col.iterator();
             while(in.hasNext()){
                 AccountSchoolDTO a=in.next();
                 bufferedWriter.append(a.tostring());
                 bufferedWriter.newLine();
             }
             bufferedWriter.flush();
             bufferedWriter.close();
         } catch (IOException ex) {
             Logger.getLogger(AccountSchoolDAL.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
}
