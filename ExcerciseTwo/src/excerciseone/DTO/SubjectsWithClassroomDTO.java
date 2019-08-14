/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DTO;

import java.util.LinkedList;

/**
 *
 * @author peter
 */
public class SubjectsWithClassroomDTO {
    private String nameclass;
    private String codesubject;
    private String namesubject;
    private LinkedList<StudentsWithPointDTO> collectionpoint;
    private LinkedList<StudentsDTO> collectionstudent;
    
    public SubjectsWithClassroomDTO(String name,String codesub,
            String namesub, LinkedList<StudentsDTO> colstuden,
            LinkedList<StudentsWithPointDTO> colpoint ){
        this.nameclass=name;
        this.codesubject=codesub;
        this.collectionstudent=colstuden;
        this.collectionpoint=colpoint;
        this.namesubject=namesub;
    }
    
    public SubjectsWithClassroomDTO(SubjectsWithClassroomDTO b){
       this.nameclass=b.nameclass;
        this.codesubject=b.codesubject;
        this.collectionstudent=b.collectionstudent;
        this.collectionpoint=b.collectionpoint;
        this.namesubject=b.namesubject;
    }

    /**
     * @return the nameroom
     */
    public String getNameroom() {
        return nameclass;
    }

    /**
     * @param nameroom the nameroom to set
     */
    public void setNameroom(String nameroom) {
        this.nameclass = nameroom;
    }

    /**
     * @return the codesubject
     */
    public String getCodesubject() {
        return codesubject;
    }

    /**
     * @param codesubject the codesubject to set
     */
    public void setCodesubject(String codesubject) {
        this.codesubject = codesubject;
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

    /**
     * @return the collectionpoint
     */
    public LinkedList<StudentsWithPointDTO> getCollectionpoint() {
        return collectionpoint;
    }

    /**
     * @param collectionpoint the collectionpoint to set
     */
    public void setCollectionpoint(LinkedList<StudentsWithPointDTO> collectionpoint) {
        this.collectionpoint = collectionpoint;
    }

    /**
     * @return the collectionstudent
     */
    public LinkedList<StudentsDTO> getCollectionstudent() {
        return collectionstudent;
    }

    /**
     * @param collectionstudent the collectionstudent to set
     */
    public void setCollectionstudent(LinkedList<StudentsDTO> collectionstudent) {
        this.collectionstudent = collectionstudent;
    }

    
}
