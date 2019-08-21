/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoDTO;

import java.io.Serializable;

/**
 *
 * @author peter
 */
public class StudentDTO implements Serializable,Comparable<StudentDTO>{
    private String idstudent;
    private String namestudent;
    private String sex;
    private int identity;
    private ClassDTO classdto;
    
    public StudentDTO() {
    }

    public StudentDTO(String idstudent) {
        this.idstudent = idstudent;
    }

    public StudentDTO(String idstudent, String namestudent, String sex, int identity, ClassDTO classdto) {
        this.idstudent = idstudent;
        this.namestudent = namestudent;
        this.sex = sex;
        this.identity = identity;
        this.classdto = classdto;
    }
    
   

    /**
     * @return the idstudent
     */
    public String getIdstudent() {
        return idstudent;
    }

    /**
     * @param idstudent the idstudent to set
     */
    public void setIdstudent(String idstudent) {
        this.idstudent = idstudent;
    }

    /**
     * @return the namestudent
     */
    public String getNamestudent() {
        return namestudent;
    }

    /**
     * @param namestudent the namestudent to set
     */
    public void setNamestudent(String namestudent) {
        this.namestudent = namestudent;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex the sex to set
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the identity
     */
    public int getIdentity() {
        return identity;
    }

    /**
     * @param identity the identity to set
     */
    public void setIdentity(int identity) {
        this.identity = identity;
    }

    /**
     * @return the classdto
     */
    public ClassDTO getClassdto() {
        return classdto;
    }

    /**
     * @param classdto the classdto to set
     */
    public void setClassdto(ClassDTO classdto) {
        this.classdto = classdto;
    }

    @Override
    public int compareTo(StudentDTO o) {
         return this.idstudent.compareTo(o.idstudent);
    }
    
    
}
