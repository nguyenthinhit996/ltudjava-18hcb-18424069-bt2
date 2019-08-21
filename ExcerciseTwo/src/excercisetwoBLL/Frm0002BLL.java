/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoBLL;

import excercisetwoDAL.ClassDAL;
import excercisetwoDAL.ClassSubjectDAL;
import excercisetwoDAL.StudentDAL;
import exercisetwoDTO.ClassDTO;
import exercisetwoDTO.ClassSubjectDTO;
import exercisetwoDTO.StudentDTO;
import java.util.Collections;
import java.util.HashMap;
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
        if(ds==null){
            logger.info("import data Null");
        }else{
            // write data into DB
            studentDAL.writeStudent(ds);
        }
        return ds;
    }
    
    public List<StudentDTO> getAllStudentByIdClass(String path){
        StudentDAL studentDAL= new StudentDAL();
        return studentDAL.getAllStudentByIdClass(path);
    }
    
    public List<ClassSubjectDTO> getAllScheduleByIdClass(String idclass){
        ClassSubjectDAL ClassSubject = new ClassSubjectDAL();
        return ClassSubject.getAllScheduleByIdClass(idclass);   
     }
    
    public Map<String,String> getMapIdMaxStudentEachClass(){
        Map<String,String> map= new HashMap<String,String>();
        ClassDAL classDTO = new ClassDAL();
        List<ClassDTO> dsc =classDTO.getAllClass();
        if(dsc.size() >=1){
            StudentDAL stu= new StudentDAL();
            for(int i=0;i<dsc.size();i++){
                LinkedList<StudentDTO> dsstu= (LinkedList<StudentDTO>) stu.getAllStudentByIdClass(dsc.get(i).getIdclass());
                Collections.sort(dsstu);
                long l=Long.valueOf(dsstu.getLast().getIdstudent()) +1;
                map.put(dsc.get(i).getIdclass(), String.valueOf(l));
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
    
    public List<StudentDTO> getAllStudent(){
        StudentDAL stu= new StudentDAL();
        return stu.getAllStudent();
    }
}
