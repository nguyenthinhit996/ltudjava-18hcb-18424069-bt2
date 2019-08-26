/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoBLL;

import excercisetwoDAL.ClassDAL;
import excercisetwoDAL.ClassSubjectDAL;
import excercisetwoDAL.StudentClassSubjectDAL;
import excercisetwoDAL.StudentDAL;
import exercisetwoDTO.ClassDTO;
import exercisetwoDTO.ClassSubjectDTO;
import exercisetwoDTO.StudentClassSubjectDTO;
import exercisetwoDTO.StudentDTO;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;

/**
 *
 * @author peter
 */
public class Frm0002BLL {
     private Logger logger= Logger.getLogger(this.getClass());
    
    public List<StudentDTO> importStudentsClass(String path){
        StudentDAL studentDAL= new StudentDAL();
        List<StudentDTO> ds=studentDAL.readFromFile(path);
        if(ds.isEmpty()||ds==null){
            logger.info("import data Null");
            return null;
        }else{
            // write data into DB
            if(studentDAL.writeStudent(ds)!=0){
                return null;
            }
            return ds;
        }
    }
    
    public List<ClassSubjectDTO> importScheduleClass(String path){
        ClassSubjectDAL classSubjectDAL= new ClassSubjectDAL();
        StudentClassSubjectDAL studentClassSubjectDAL = new StudentClassSubjectDAL();
        List<ClassSubjectDTO> ds=classSubjectDAL.readFromFile(path);
        if(ds.isEmpty()||ds==null){
            logger.info("import data Null");
            return null;
        }else{
            // write data into DB
            if(classSubjectDAL.writeShedule(ds)!=0){
                return null;
            }
            Frm0002BLL frm0002BLL= new Frm0002BLL();
            List<StudentDTO>dss = frm0002BLL.getAllStudent();
            if(studentClassSubjectDAL.writeStudentClassSubjectDAL(ds,dss)!=0){
                return null;
            }
            return ds;
        }
    }
    
    public List<StudentClassSubjectDTO> importPointClass(String path){
        StudentClassSubjectDAL studentClassSubjectDAL = new StudentClassSubjectDAL();
        List<StudentClassSubjectDTO> ds=studentClassSubjectDAL.readFromFile(path);
        if(ds.isEmpty()||ds==null){
            logger.info("import data Null");
            return null;
        }else{
            // write data into DB
            if(studentClassSubjectDAL.writePoint(ds)!=0){
                return null;
            }  
            return ds;
        }
    }
    
    public List<StudentDTO> getAllStudentByIdClass(String path){
        StudentDAL studentDAL= new StudentDAL();
        return studentDAL.getAllStudentByIdClass(path);
    }
    
    public List<StudentDTO> getAllStudent(){
        StudentDAL studentDAL= new StudentDAL();
        return studentDAL.getAllStudent();
    }
    
    public List<ClassSubjectDTO> getAllScheduleByIdClass(String idclass){
        ClassSubjectDAL ClassSubject = new ClassSubjectDAL();
        return ClassSubject.getAllScheduleByIdClass(idclass);   
     }
    
    public List<ClassSubjectDTO> getAllScheduleByIdClass2(String idclass){
        ClassSubjectDAL ClassSubject = new ClassSubjectDAL();
        return ClassSubject.getAllScheduleByIdClass2(idclass);   
     }
    
    
    
    public Map<String,String> getMapIdMaxStudentEachClass(){
        Map<String,String> map= new HashMap<String,String>();
        ClassDAL classDTO = new ClassDAL();
        List<ClassDTO> dsc =classDTO.getAllClass();
        if(dsc.size() >=1){
            StudentDAL stu= new StudentDAL();
            for(int i=0;i<dsc.size();i++){
                LinkedList<StudentDTO> dsstu = new LinkedList<>(stu.getAllStudentByIdClass(dsc.get(i).getIdclass()));
                Collections.sort(dsstu);
                long lg=0;
                if(!dsstu.isEmpty()){
                    lg=Long.valueOf(dsstu.getLast().getIdstudent()) +1;  
                }
                map.put(dsc.get(i).getIdclass(), String.valueOf(lg));
            }
            
        }
        return map;
    }
    
    public boolean writeStudent(List<StudentDTO> ds) throws HibernateException{
        StudentDAL stu= new StudentDAL();
        try{
            stu.writeStudent(ds);
            return true;
        }catch(HibernateException e){
            return false;
        }
    }
    
   
    
    public List<StudentDTO> getAllStudenbyIdClassSub(String idclasssub){
        StudentClassSubjectDAL studentClassSubjectDAL= new StudentClassSubjectDAL();
        List<StudentDTO> dsstu= new ArrayList<>();
        List<StudentClassSubjectDTO> ds=studentClassSubjectDAL.getAllClassSubjectDTOById(idclasssub);
        Iterator in= ds.iterator();
        while(in.hasNext()){
            StudentClassSubjectDTO classdto = (StudentClassSubjectDTO) in.next();
            dsstu.add(classdto.getStudent());
        }
        return dsstu;
    }
    
    public List<StudentClassSubjectDTO> getAllStudenbyIdClassSub2(String idclasssub){
        StudentClassSubjectDAL studentClassSubjectDAL= new StudentClassSubjectDAL();
        List<StudentDTO> dsstu= new ArrayList<>();
        List<StudentClassSubjectDTO> ds=studentClassSubjectDAL.getAllClassSubjectDTOById(idclasssub);
        return ds;
    }
    
    public boolean deteleStudentClassSubjectDTO(StudentClassSubjectDTO dto){
        StudentClassSubjectDAL studentClassSubjectDAL= new StudentClassSubjectDAL();
        return studentClassSubjectDAL.deleteStudentClassSubjectDTO(dto);
    }
    
    public boolean ckeckExixtsStudent(String idclasssub,String stu){
        StudentClassSubjectDAL studentClassSubjectDAL= new StudentClassSubjectDAL();
        StudentDTO a= studentClassSubjectDAL.getStudentDTOInStudentClassSubject(idclasssub, stu);
        if(a!= null){
            return true;
        }
        return false;
    }
    public StudentDTO getStudentById(String id){
       StudentDAL studentDAL = new StudentDAL();
       return studentDAL.getStudentById(id);
    }
    
     
}
