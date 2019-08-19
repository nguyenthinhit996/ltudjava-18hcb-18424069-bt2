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
public class AccountDTO {
    private String idacc;
    private String pass;
    private String nameview;

    public AccountDTO() {
    }

    public AccountDTO(String idacc) {
        this.idacc = idacc;
    }

    public AccountDTO(String idacc, String pass, String nameview) {
        this.idacc = idacc;
        this.pass = pass;
        this.nameview = nameview;
    }

    /**
     * @return the idacc
     */
    public String getIdacc() {
        return idacc;
    }

    /**
     * @param idacc the idacc to set
     */
    public void setIdacc(String idacc) {
        this.idacc = idacc;
    }

    /**
     * @return the pass
     */
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the nameview
     */
    public String getNameview() {
        return nameview;
    }

    /**
     * @param nameview the nameview to set
     */
    public void setNameview(String nameview) {
        this.nameview = nameview;
    }
    
}
