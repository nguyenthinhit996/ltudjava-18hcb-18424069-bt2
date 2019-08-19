/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoDTO;

/**
 *
 * @author peter
 */
public class StudentClassSubjectDTO {
    private String id_student_classsubject;
    private ClassSubjectDTO classsubject;
    private StudentDTO student;
    private int pointmid;
    private int pointfinal;
    private int pointdifferent;
    private int pointsum;

    public StudentClassSubjectDTO() {
    }

    public StudentClassSubjectDTO(String id_student_classsubject) {
        this.id_student_classsubject = id_student_classsubject;
    }

    public StudentClassSubjectDTO(String id_student_classsubject, ClassSubjectDTO classsubject, StudentDTO student, int pointmid, int pointfinal, int pointdifferent, int pointsum) {
        this.id_student_classsubject = id_student_classsubject;
        this.classsubject = classsubject;
        this.student = student;
        this.pointmid = pointmid;
        this.pointfinal = pointfinal;
        this.pointdifferent = pointdifferent;
        this.pointsum = pointsum;
    }

    /**
     * @return the id_student_classsubject
     */
    public String getId_student_classsubject() {
        return id_student_classsubject;
    }

    /**
     * @param id_student_classsubject the id_student_classsubject to set
     */
    public void setId_student_classsubject(String id_student_classsubject) {
        this.id_student_classsubject = id_student_classsubject;
    }

    /**
     * @return the classsubject
     */
    public ClassSubjectDTO getClasssubject() {
        return classsubject;
    }

    /**
     * @param classsubject the classsubject to set
     */
    public void setClasssubject(ClassSubjectDTO classsubject) {
        this.classsubject = classsubject;
    }

    /**
     * @return the student
     */
    public StudentDTO getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    /**
     * @return the pointmid
     */
    public int getPointmid() {
        return pointmid;
    }

    /**
     * @param pointmid the pointmid to set
     */
    public void setPointmid(int pointmid) {
        this.pointmid = pointmid;
    }

    /**
     * @return the pointfinal
     */
    public int getPointfinal() {
        return pointfinal;
    }

    /**
     * @param pointfinal the pointfinal to set
     */
    public void setPointfinal(int pointfinal) {
        this.pointfinal = pointfinal;
    }

    /**
     * @return the pointdifferent
     */
    public int getPointdifferent() {
        return pointdifferent;
    }

    /**
     * @param pointdifferent the pointdifferent to set
     */
    public void setPointdifferent(int pointdifferent) {
        this.pointdifferent = pointdifferent;
    }

    /**
     * @return the pointsum
     */
    public int getPointsum() {
        return pointsum;
    }

    /**
     * @param pointsum the pointsum to set
     */
    public void setPointsum(int pointsum) {
        this.pointsum = pointsum;
    }
    
}
