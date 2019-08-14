/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DAL;

import excerciseone.DTO.ClassRoomDTO;
import excerciseone.DTO.StudentsDTO;
import excerciseone.DTO.StudentsWithPointDTO;
import excerciseone.DTO.SubjectsDTO;
import excerciseone.DTO.SubjectsWithClassroomDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author peter
 */
public class SubjectsWithClassroomDAL {
    
     
    
    LinkedList<StudentsDTO> getSubjectsWithClassroomByPath(String path){
       LinkedList<StudentsDTO> colstu=new LinkedList<>();
       FileDAL file= new FileDAL(path);
       BufferedReader buff=file.createBufferedReader();
        try {
            if(buff.ready()){
                String line;
                while((line=buff.readLine()) != null){
                    String [] content=line.split(",");
                    if(content.length >=4){
                        if(StringUtils.isNumeric(content[3])){
                         StudentsDTO student= new StudentsDTO(content[0], content[1],content[2],Long.valueOf(content[3]));   
                         colstu.add(student);
                        }
                    }else{
                        System.out.print("Warning Miss "+line); 
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return colstu;
    }
    
    public LinkedList<StudentsWithPointDTO> getPointSubjectsWithClassroomByPath(String path){
       LinkedList<StudentsWithPointDTO> colstu=new LinkedList<>();
       FileDAL file= new FileDAL(path);
       BufferedReader buff=file.createBufferedReader();
        try {
            if(buff!=null){
                String line;
                while((line=buff.readLine()) != null){
                    String [] con=line.split(",");
                    if(con.length >=6){
                        StudentsWithPointDTO a=
                        new StudentsWithPointDTO(
                        con[0],con[1],Integer.valueOf(con[2]),Integer.valueOf(con[3]),Integer.valueOf(con[4]),Float.valueOf(con[5]));
                         colstu.add(a);
                    }else{
                        System.out.print("Warning Miss "+line); 
                    }
                }
            }
        } catch (IOException ex) {
            Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return colstu;
    }
    
    public boolean writeSubjectWithStudent(final SubjectsWithClassroomDTO ob){
        String filename=ob.getNameroom()+"_"+ob.getCodesubject();
        String path=FileDAL.getPathFile(filename);
        System.out.println("luu mon hoc vs sinh vien: "+path);
        if(ob.getCollectionstudent()!=null){
            FileDAL filedal=new FileDAL(path);
            BufferedWriter buff= filedal.createBufferwriter();
            if(buff != null){
                try {

                    Iterator<StudentsDTO> colSub=ob.getCollectionstudent().iterator();

                    while(colSub.hasNext()){
                            StudentsDTO su=colSub.next();
                            buff.append(su.toStringDTO());
                            buff.newLine();
                        }
                buff.close();
                } catch (IOException ex) { 
                    Logger.getLogger(SubjectsWithClassroomDAL.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else{
                return false;
            }
        }
        // luu diem
        if(ob.getCollectionpoint()!=null){
            String filenames=ob.getNameroom()+"_"+ob.getCodesubject()+"_P";
            String paths=FileDAL.getPathFile(filenames);
            System.out.println("luu Diem mon hoc vs sinh vien: "+paths);
            FileDAL filedals=new FileDAL(paths);
            BufferedWriter buffs= filedals.createBufferwriter();
            if(buffs != null){
                try {

                        Iterator<StudentsWithPointDTO> colSubs=ob.getCollectionpoint().iterator();
                        while(colSubs.hasNext()){
                            StudentsWithPointDTO sus=colSubs.next();
                            buffs.append(sus.toStringDTO());
                            buffs.newLine();
                        }
                buffs.close();
                } catch (IOException ex) { 
                    Logger.getLogger(SubjectsWithClassroomDAL.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
                }
            }else{
                return false;
            }
        }
        
        return true;
    }
    
//     private String nameclass;
//    private String codesubject;
//    private String namesubject;
//    private LinkedList<StudentsWithPointDTO> collectionpoint;
//    private LinkedList<StudentsDTO> collectionstudent;
    
     ArrayList<String> getAllSubjectClass(){
        ArrayList<String> colstr=new ArrayList<>();
        ClassRoomDAL cr= new ClassRoomDAL();
        LinkedList<ClassRoomDTO> colcr=cr.getAllClassRoom();
        Iterator<ClassRoomDTO> in = colcr.iterator();
        while(in.hasNext()){
            ClassRoomDTO ne= in.next();
            if(ne.getCollectionSUB()!= null){
                for(SubjectsDTO i:ne.getCollectionSUB()){
                    String s=ne.getNameroom()+"_"+i.getCodesubject()+"_"+i.getNamesubject();
                    colstr.add(s);
                }   
            }
        }
        return colstr;
    }
    
    public LinkedList<SubjectsWithClassroomDTO> getAllSubjectOfStudentsPoint(){
        LinkedList<SubjectsWithClassroomDTO> ds= new LinkedList<>();
        ArrayList<String> listSub=getAllSubjectClass();
        ClassRoomDAL cdal= new ClassRoomDAL();
        for(String i :listSub){
            final String [] con= i.split("_");
            String nameSub=con[0]+"_"+con[1];
            String pathstu=FileDAL.getPathFile(nameSub);
            LinkedList<StudentsDTO> stus=cdal.getStudentsDTOClassRoomByPath(pathstu);
            // get diem nua
            String nameSubs=con[0]+"_"+con[1]+"_P";
            String pathstus=FileDAL.getPathFile(nameSubs);
            LinkedList<StudentsWithPointDTO>dspoint=getPointSubjectsWithClassroomByPath(pathstus);
            SubjectsWithClassroomDTO a= 
            new SubjectsWithClassroomDTO(con[0],con[1],con[2], stus, dspoint);
            ds.add(a);
        }
        return ds;
    }
    
    
}
