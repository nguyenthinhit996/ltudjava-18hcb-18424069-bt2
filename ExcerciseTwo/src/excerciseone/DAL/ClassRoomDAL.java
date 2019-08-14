/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DAL;

import excerciseone.BLL.Common;
import excerciseone.DTO.ClassRoomDTO;
import excerciseone.DTO.StudentsDTO;
import excerciseone.DTO.SubjectsDTO;
import excerciseone.DTO.SubjectsWithClassroomDTO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
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
public class ClassRoomDAL {   
    
    public LinkedList<ClassRoomDTO> getAllClassRoom(){
        LinkedList<ClassRoomDTO> colcr= new LinkedList<>();
        ArrayList<String> colYear= FileDAL.getAllSchoolYearExists();
        for(String di:colYear){
            ArrayList<String> colClass= FileDAL.getAllClassExists(di);
            for(String fi:colClass){
                    String path="repository"+File.separator+di
                    +File.separator+Common.getNameExceptExtension(fi)+File.separator+fi+".txt";
                    System.out.print("  "+path);
                    LinkedList<StudentsDTO> rclass=getStudentsDTOClassRoomByPath(path);
                    String path2="repository"+File.separator+di
                    +File.separator+Common.getNameExceptExtension(fi)+File.separator+fi+"_TKB.txt";
                    LinkedList<SubjectsDTO> rcsub=getSubjectsDTOClassRoomByPath(path2);
                    if(rclass != null){
                        ClassRoomDTO croom= new ClassRoomDTO(Common.getNameExceptExtension(fi), rclass,rcsub);
                        colcr.add(croom);
                    }
            }
        }
        return colcr;
    }
    
    LinkedList<StudentsDTO> getStudentsDTOClassRoomByPath(String path){
       LinkedList<StudentsDTO> colstu=new LinkedList<>();
       FileDAL file= new FileDAL(path);
       BufferedReader buff=file.createBufferedReader();
        try {
            if(buff != null){
                String line;
                while((line=buff.readLine()) != null){
                    String [] content=line.split(",");
                    if(content.length >=4){
                        if(StringUtils.isNumeric(content[3])){
                         StudentsDTO student= new StudentsDTO(content[0], content[1],content[2],Long.valueOf(content[3]));   
                         colstu.add(student);
                        }
                    }else{
                        System.out.println("Warning Miss "+line); 
                    }
                }
            }else{
                return null;
            }
             
        } catch (IOException ex) {
            Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return colstu;
    }
    
    LinkedList<SubjectsDTO> getSubjectsDTOClassRoomByPath(String path){
       LinkedList<SubjectsDTO> colstu=new LinkedList<>();
       FileDAL file= new FileDAL(path);
       BufferedReader buff=file.createBufferedReader();
        try {
            if(buff != null){
                String line;
                while((line=buff.readLine()) != null){
                    String [] content=line.split(",");
                    if(content.length >=3){
                         SubjectsDTO sub= new SubjectsDTO(content[0],content[1],content[2]);
                         colstu.add(sub);
                    }else{
                        System.out.println("Warning Miss "+line); 
                    }
                }
            }else{
                return null;
            }
             
        } catch (IOException ex) {
            Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return colstu;
    }
    
    
//    public static void main(String[] args){
//        ClassRoomDAL a= new ClassRoomDAL();
//        a.getAllClassRoom();
//    }
    public ClassRoomDTO importColStudentClass(String path){
        FileDAL filedal= new FileDAL(path);
        String nameclass="";
        LinkedList<StudentsDTO> colstu=new LinkedList<>();
        BufferedReader buff= filedal.createBufferedReader();
        if(buff != null){
            try {
                String line;
                nameclass=buff.readLine();
                while((line=buff.readLine())!=null){
                    String [] content=line.split(",");
                    if(content.length >=4){
                        if(StringUtils.isNumeric(content[3])){
                         StudentsDTO student= new StudentsDTO(content[0], content[1],content[2],Long.valueOf(content[3]));   
                         colstu.add(student);
                        }
                    }
                }
                buff.close();
            } catch (IOException ex) {
                Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            System.out.println("Error get bufferedReder "+ this.getClass().toString());
            return null;
        }
        return new ClassRoomDTO(nameclass, colstu, null);
    }
    
    public boolean writeClassRoom(ClassRoomDTO classroom){
        // khong co lop thi tao ra thu muc lop
        if(!FileDAL.checkFileExistInSystem(classroom.getNameroom())){
           if(!FileDAL.createDirectory(classroom.getNameroom())){
               System.out.print("not creat folder ");
               return false;
           }
           // luu xuong 
           System.out.print(FileDAL.getPathFile(classroom.getNameroom()));
           FileDAL filedal= new FileDAL(FileDAL.getPathFile(classroom.getNameroom()));
           BufferedWriter buff= filedal.createBufferwriter();
           Iterator<StudentsDTO> in= classroom.getCollectionSTU().iterator();
           try {
           while(in.hasNext()){
                   StudentsDTO ne= in.next();
                   buff.append(ne.toStringDTO());
                   buff.newLine();
            }
            buff.close(); 
            } catch (IOException ex) {
                   Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
                   return false;
            }
           return true;
        }
        // get tat ca len , kiem tra mssv neu khong co thi them vao classroomdto xong luu xuong lai ok
        LinkedList<StudentsDTO> col=getStudentsDTOClassRoomByPath(FileDAL.getPathFile(classroom.getNameroom()));
        if(col != null){
            for(StudentsDTO i:classroom.getCollectionSTU()){
                int in=0;
                int fa=0;
                for(StudentsDTO j:col){
                    if(StudentsDTO.equalsStudentDTO(i, j)){
                        col.set(in, i);
                        fa=1;
                        break;
                    }
                    in++;
                }
                if(fa==0){
                    col.add(i);
                }
            }
        }else{
            col=classroom.getCollectionSTU();
        }
        // luu xuong 
        FileDAL filedal= new FileDAL(FileDAL.getPathFile(classroom.getNameroom()));
        BufferedWriter buff= filedal.createBufferwriter();
        Iterator<StudentsDTO> in= col.iterator();
        try {
        while(in.hasNext()){
                StudentsDTO ne= in.next();
                buff.append(ne.toStringDTO());
                buff.newLine();
        }
        buff.close();
        } catch (IOException ex) {
               Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
               return false;
        }
        // luu subject 
        if(classroom.getCollectionSUB()!= null){              
            String nameFileTKB=classroom.getNameroom()+"_TKB";
            FileDAL filedals= new FileDAL(FileDAL.getPathFile(nameFileTKB));
            BufferedWriter buffs= filedals.createBufferwriter();
            Iterator<SubjectsDTO> ins= classroom.getCollectionSUB().iterator();
            try {
            while(ins.hasNext()){

                    SubjectsDTO nes= ins.next();
                    buffs.append(nes.toStringDTO());
                    buffs.newLine();
               
                } 
                buffs.close();
                // luu mon hoc voi hoc sinh
                Iterator<SubjectsDTO> insub= classroom.getCollectionSUB().iterator();
                while(insub.hasNext()){
                    SubjectsDTO subdto=insub.next();
                    SubjectsWithClassroomDTO subwithclass=
                    new SubjectsWithClassroomDTO(classroom.getNameroom(),subdto.getCodesubject(),
                    subdto.getNamesubject(),classroom.getCollectionSTU(),null);
                    SubjectsWithClassroomDAL wri= new SubjectsWithClassroomDAL();
                    if(!wri.writeSubjectWithStudent(subwithclass)){
                        System.out.println("No write "+ classroom.getNameroom() +
                                " "+subdto.getNamesubject());
                        return false;
                    }
                }
             } catch (IOException ex) {
                    Logger.getLogger(ClassRoomDAL.class.getName()).log(Level.SEVERE, null, ex);
                    return false;
             }
        }
        return true;
    }
}
