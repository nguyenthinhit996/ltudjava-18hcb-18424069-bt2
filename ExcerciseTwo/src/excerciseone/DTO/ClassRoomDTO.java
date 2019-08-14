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
public class ClassRoomDTO {
    private String nameroom;
    private LinkedList<StudentsDTO> collectionSTU;
    private LinkedList<SubjectsDTO> collectionSUB;
    
    public ClassRoomDTO(String na,LinkedList<StudentsDTO> costu, LinkedList<SubjectsDTO> cosub){
        this.nameroom=na;
        this.collectionSTU=costu;
        this.collectionSUB=cosub;
    }

    /**
     * @return the nameroom
     */
    public String getNameroom() {
        return nameroom;
    }

    /**
     * @param nameroom the nameroom to set
     */
    public void setNameroom(String nameroom) {
        this.nameroom = nameroom;
    }

    /**
     * @return the collectionSTU
     */
    public LinkedList<StudentsDTO> getCollectionSTU() {
        return collectionSTU;
    }

    /**
     * @param collectionSTU the collectionSTU to set
     */
    public void setCollectionSTU(LinkedList<StudentsDTO> collectionSTU) {
        this.collectionSTU = collectionSTU;
    }

    /**
     * @return the collectionSUB
     */
    public LinkedList<SubjectsDTO> getCollectionSUB() {
        return collectionSUB;
    }

    /**
     * @param collectionSUB the collectionSUB to set
     */
    public void setCollectionSUB(LinkedList<SubjectsDTO> collectionSUB) {
        this.collectionSUB = collectionSUB;
    }
    
}
