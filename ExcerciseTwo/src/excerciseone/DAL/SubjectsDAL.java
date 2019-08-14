/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DAL;

import excerciseone.BLL.Frm0002BLL;
import excerciseone.DTO.ClassRoomDTO;
import excerciseone.DTO.SubjectsDTO;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author peter
 */
public class SubjectsDAL {
    
    public ClassRoomDTO importScheduleClass(String path){
        Frm0002BLL.getAllClassRoom();
        LinkedList<ClassRoomDTO> colcr=Frm0002BLL.getColClassRoom();
        LinkedList<SubjectsDTO> listsub= new LinkedList<>();
        FileDAL file= new FileDAL(path);
        BufferedReader buff=file.createBufferedReader();
        if(buff!=null){
            String line;
            try {
                String nameclass=buff.readLine();
                while((line=buff.readLine())!=null){
                    String[] dss= line.split(",");
                    if(dss.length !=3 ){
                        return null;
                    }
                    SubjectsDTO sub= new SubjectsDTO(dss[0],dss[1], dss[2]);
                    listsub.add(sub);
                }
                Iterator<ClassRoomDTO> in = colcr.iterator();
                while(in.hasNext()){
                    ClassRoomDTO cr=in.next();
                    if(cr.getNameroom().equals(nameclass)){
                        cr.setCollectionSUB(listsub);
                        return cr;
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(SubjectsDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("NOt get BufferedReader ");
            return null;
        }
        return null;
    } 
    
    
     
}
