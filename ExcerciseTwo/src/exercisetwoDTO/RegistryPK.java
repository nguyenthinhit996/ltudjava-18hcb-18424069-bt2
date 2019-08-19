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
public class RegistryPK {
    private String idregistrypk;
    private StudentDTO student;
    private SubjectDTO subject;
    private String namepoint;
    private int hopepoint;
    private String becauses;

    public RegistryPK() {
    }

    public RegistryPK(String idregistrypk) {
        this.idregistrypk = idregistrypk;
    }

    public RegistryPK(String idregistrypk, StudentDTO student, SubjectDTO subject, String namepoint, int hopepoint, String becauses) {
        this.idregistrypk = idregistrypk;
        this.student = student;
        this.subject = subject;
        this.namepoint = namepoint;
        this.hopepoint = hopepoint;
        this.becauses = becauses;
    }

    /**
     * @return the idregistrypk
     */
    public String getIdregistrypk() {
        return idregistrypk;
    }

    /**
     * @param idregistrypk the idregistrypk to set
     */
    public void setIdregistrypk(String idregistrypk) {
        this.idregistrypk = idregistrypk;
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
     * @return the subject
     */
    public SubjectDTO getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    /**
     * @return the namepoint
     */
    public String getNamepoint() {
        return namepoint;
    }

    /**
     * @param namepoint the namepoint to set
     */
    public void setNamepoint(String namepoint) {
        this.namepoint = namepoint;
    }

    /**
     * @return the hopepoint
     */
    public int getHopepoint() {
        return hopepoint;
    }

    /**
     * @param hopepoint the hopepoint to set
     */
    public void setHopepoint(int hopepoint) {
        this.hopepoint = hopepoint;
    }

    /**
     * @return the becauses
     */
    public String getBecauses() {
        return becauses;
    }

    /**
     * @param becauses the becauses to set
     */
    public void setBecauses(String becauses) {
        this.becauses = becauses;
    }
    
}
