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
public class ClassDTO {
    private String idclass;
    private String nameclass;

    public ClassDTO() {
    }

    public ClassDTO(String idclass) {
        this.idclass = idclass;
    }

    public ClassDTO(String idclass, String nameclass) {
        this.idclass = idclass;
        this.nameclass = nameclass;
    }

    public String getIdclass() {
        return idclass;
    }

    public String getNameclass() {
        return nameclass;
    }

    /**
     * @param idclass the idclass to set
     */
    public void setIdclass(String idclass) {
        this.idclass = idclass;
    }

    /**
     * @param nameclass the nameclass to set
     */
    public void setNameclass(String nameclass) {
        this.nameclass = nameclass;
    }
    
}
