/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercisetwoDTO;

import java.sql.Timestamp;

/**
 *
 * @author peter
 */
public class ContructorPK {
    private String idcontructorpk;
    private String name;
    private Timestamp timestart;
    private Timestamp timefinish;

    public ContructorPK() {
    }

    public ContructorPK(String idcontructorpk) {
        this.idcontructorpk = idcontructorpk;
    }

    public ContructorPK(String idcontructorpk, String name, Timestamp timestart, Timestamp timefinish) {
        this.idcontructorpk = idcontructorpk;
        this.name = name;
        this.timestart = timestart;
        this.timefinish = timefinish;
    }

    /**
     * @return the idcontructorpk
     */
    public String getIdcontructorpk() {
        return idcontructorpk;
    }

    /**
     * @param idcontructorpk the idcontructorpk to set
     */
    public void setIdcontructorpk(String idcontructorpk) {
        this.idcontructorpk = idcontructorpk;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the timestart
     */
    public Timestamp getTimestart() {
        return timestart;
    }

    /**
     * @param timestart the timestart to set
     */
    public void setTimestart(Timestamp timestart) {
        this.timestart = timestart;
    }

    /**
     * @return the timefinish
     */
    public Timestamp getTimefinish() {
        return timefinish;
    }

    /**
     * @param timefinish the timefinish to set
     */
    public void setTimefinish(Timestamp timefinish) {
        this.timefinish = timefinish;
    }
    
}
 