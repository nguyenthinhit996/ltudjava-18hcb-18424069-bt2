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
public class SubjectDTO {
    private String idsubject;
    private String namesubject;

    public SubjectDTO() {
    }

    public SubjectDTO(String idsubject) {
        this.idsubject = idsubject;
    }

    public SubjectDTO(String idsubject, String namesubject) {
        this.idsubject = idsubject;
        this.namesubject = namesubject;
    }

    /**
     * @return the idsubject
     */
    public String getIdsubject() {
        return idsubject;
    }

    /**
     * @param idsubject the idsubject to set
     */
    public void setIdsubject(String idsubject) {
        this.idsubject = idsubject;
    }

    /**
     * @return the namesubject
     */
    public String getNamesubject() {
        return namesubject;
    }

    /**
     * @param namesubject the namesubject to set
     */
    public void setNamesubject(String namesubject) {
        this.namesubject = namesubject;
    }
    
}
