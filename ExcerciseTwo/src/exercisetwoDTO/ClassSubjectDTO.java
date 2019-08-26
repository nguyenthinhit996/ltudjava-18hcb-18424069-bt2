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
public class ClassSubjectDTO {
    private String id_class_sub;
    private String classdto;
    private SubjectDTO subjectdto;
    private String room;

    public ClassSubjectDTO() {
    }

    public ClassSubjectDTO(String id_class_sub) {
        this.id_class_sub = id_class_sub;
    }

    public ClassSubjectDTO(String id_class_sub, String classdto, SubjectDTO subjectdto, String room) {
        this.id_class_sub = id_class_sub;
        this.classdto = classdto;
        this.subjectdto = subjectdto;
        this.room = room;
    }

    /**
     * @return the id_class_sub
     */
    public String getId_class_sub() {
        return id_class_sub;
    }

    /**
     * @param id_class_sub the id_class_sub to set
     */
    public void setId_class_sub(String id_class_sub) {
        this.id_class_sub = id_class_sub;
    }

    /**
     * @return the classdto
     */
    public String getClassdto() {
        return classdto;
    }

    /**
     * @param classdto the classdto to set
     */
    public void setClassdto(String classdto) {
        this.classdto = classdto;
    }

    /**
     * @return the subjectdto
     */
    public SubjectDTO getSubjectdto() {
        return subjectdto;
    }

    /**
     * @param subjectdto the subjectdto to set
     */
    public void setSubjectdto(SubjectDTO subjectdto) {
        this.subjectdto = subjectdto;
    }

    /**
     * @return the room
     */
    public String getRoom() {
        return room;
    }

    /**
     * @param room the room to set
     */
    public void setRoom(String room) {
        this.room = room;
    }
    
}