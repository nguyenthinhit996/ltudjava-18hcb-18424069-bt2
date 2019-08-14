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
public class StudentsDTO implements Comparable<StudentsDTO>{
    private String mssv;
    private String name;
    private String sex;
    private Long identity;
    
    public StudentsDTO(String mssv,String n,String se,Long id){
        this.mssv=mssv;
        this.name=n;
        this.sex=se;
        this.identity=id;
    }
    
    public StudentsDTO(String []ds){
        if(ds.length == 4){
         this.mssv=ds[0];
         this.name=ds[1];
         this.sex=ds[2];
         this.identity=Long.valueOf(ds[3]);   
        }
    }
    
    public StudentsDTO(StudentsDTO t){
         this.mssv=t.mssv;
         this.name=t.name;
         this.sex=t.sex;
         this.identity=t.identity;   
    }

    /**
     * @return the mssv
     */
    public String getMssv() {
        return mssv;
    }

    /**
     * @param mssv the mssv to set
     */
    public void setMssv(String mssv) {
        this.mssv = mssv;
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
    public Long getIdentity() {
        return identity;
    }

    /**
     * @param identity the identity to set
     */
    public void setIdentity(Long identity) {
        this.identity = identity;
    }
   
    public static boolean equalsStudentDTO(StudentsDTO a, StudentsDTO b){
        if(a.identity.equals(b.identity)){
            return true;
        }
        return false;
    }
    
    public String toStringDTO(){
        StringBuilder string = new StringBuilder();
        string.append(this.getMssv());
        string.append(",");
        string.append(this.getName());
        string.append(",");
        string.append(this.getSex());
        string.append(",");
        string.append(this.getIdentity());
        return string.toString();
    }

    @Override
    public int compareTo(StudentsDTO o) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return this.mssv.compareTo(o.mssv);
    }
    
}
