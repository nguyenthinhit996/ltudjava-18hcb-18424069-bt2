/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.BLL;

import excerciseone.DAL.SubjectsWithClassroomDAL;
import excerciseone.DTO.StudentsWithPointDTO;
import excerciseone.DTO.SubjectsWithClassroomDTO;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

/**
 *
 * @author peter
 */
public class Frm0003BLL {
    static private Map<String,StudentsWithPointDTO> pointstudent;

    static{
         Frm0003BLL.pointstudent= new HashMap<>();
    }
    
    /**
     * @return the pointstudent
     */
    public Map<String,StudentsWithPointDTO> getPointstudent() {
        return pointstudent;
    }

    /**
     * @param pointstudent the pointstudent to set
     */
    public void setPointstudent(Map<String,StudentsWithPointDTO> pointstudent) {
        this.pointstudent = pointstudent;
    }
    
    
    public void getAllPointOfStudent(String mssv){
        SubjectsWithClassroomDAL subjectsWithClassroomDAL= new SubjectsWithClassroomDAL();
        LinkedList<SubjectsWithClassroomDTO> allds=subjectsWithClassroomDAL.getAllSubjectOfStudentsPoint();
        if(allds !=null){
            Iterator<SubjectsWithClassroomDTO> in= allds.iterator();
            while(in.hasNext()){
                SubjectsWithClassroomDTO res= in.next();
                String nameclass=res.getNameroom()+"_"+res.getCodesubject();
                LinkedList<StudentsWithPointDTO> listdiem=res.getCollectionpoint();
                for(StudentsWithPointDTO index:listdiem){
                    if(index.getMssv().equals(mssv)){
                        this.pointstudent.put(nameclass, index);
                        break;
                    }
                }
                
            }
        }
    }
    
}
