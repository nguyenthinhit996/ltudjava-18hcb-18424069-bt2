/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excerciseone.DTO;

/**
 *
 * @author peter
 */
public class SubjectsDTO  {
    private String namesubject;
    private String codesubject;
    private String roomstudy;
    
    public SubjectsDTO(String ma,String name,String ph){
         this.codesubject=ma;
         this.namesubject=name;
         this.roomstudy=ph;
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
     * @return the roomstudy
     */
    public String getRoomstudy() {
        return roomstudy;
    }

    /**
     * @param roomstudy the roomstudy to set
     */
    public void setRoomstudy(String roomstudy) {
        this.roomstudy = roomstudy;
    }
     
     public String toStringDTO(){
        StringBuilder string = new StringBuilder();
        string.append(this.codesubject);
        string.append(",");
        string.append(this.namesubject);
        string.append(",");
        string.append(this.roomstudy);
        return string.toString();
    }
  
}
