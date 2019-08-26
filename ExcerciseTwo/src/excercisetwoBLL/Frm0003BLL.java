/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoBLL;

import excercisetwoDAL.StudentClassSubjectDAL;
import exercisetwoDTO.StudentClassSubjectDTO;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author peter
 */
public class Frm0003BLL {
    
    static private Map<String,StudentClassSubjectDTO> pointstudent;

    static{
         Frm0003BLL.pointstudent= new HashMap<>();
    }
    
    /**
     * @return the pointstudent
     */
    public Map<String,StudentClassSubjectDTO> getPointstudent() {
        return pointstudent;
    }

    /**
     * @param pointstudent the pointstudent to set
     */
    public void setPointstudent(Map<String,StudentClassSubjectDTO> pointstudent) {
        this.pointstudent = pointstudent;
    }
    
    
    public void getAllPointOfStudent(String mssv){
        StudentClassSubjectDAL studentClassSubjectDAL= new StudentClassSubjectDAL();
        List<StudentClassSubjectDTO> ds=studentClassSubjectDAL.getAllClassSubjectDTOByIdStu(mssv);
        for(StudentClassSubjectDTO i:ds){
            pointstudent.put(i.getClassSubjectDTO().getId_class_sub(), i);
        }
    }
}
