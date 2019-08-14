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
public class StudentsWithPointDTO {
    private String namestudent;
    private String mssv;
    private int pointmid;
    private int pointfinal;
    private int pointdifference;
    private float pointsummary;
    
    public StudentsWithPointDTO(String name, String ms){
        this.namestudent=name;
        this.mssv=ms;
        this.pointdifference=0;
        this.pointfinal=0;
        this.pointmid=0;
        this.pointsummary=0;
    }
    
    public StudentsWithPointDTO(String ms, String name,int gk,int ck,int khac,float tong){
        this.namestudent=name;
        this.mssv=ms;
        this.pointdifference=khac;
        this.pointfinal=ck;
        this.pointmid=gk;
        this.pointsummary=tong;
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
     * @return the pointmid
     */
    public int getPointmid() {
        return pointmid;
    }

    /**
     * @param pointmid the pointmid to set
     */
    public void setPointmid(int pointmid) {
        this.pointmid = pointmid;
    }

    /**
     * @return the pointfinal
     */
    public int getPointfinal() {
        return pointfinal;
    }

    /**
     * @param pointfinal the pointfinal to set
     */
    public void setPointfinal(int pointfinal) {
        this.pointfinal = pointfinal;
    }

    /**
     * @return the pointdifference
     */
    public int getPointdifference() {
        return pointdifference;
    }

    /**
     * @param pointdifference the pointdifference to set
     */
    public void setPointdifference(int pointdifference) {
        this.pointdifference = pointdifference;
    }

    /**
     * @return the pointsummary
     */
    public float getPointsummary() {
        return pointsummary;
    }

    /**
     * @param pointsummary the pointsummary to set
     */
    public void setPointsummary(float pointsummary) {
        this.pointsummary = pointsummary;
    }
    public String toStringDTO(){
        StringBuilder bul= new StringBuilder();
        bul.append(this.mssv);
        bul.append(",");
        bul.append(this.namestudent);
        bul.append(",");
        bul.append(this.pointmid);
        bul.append(",");
        bul.append(this.pointfinal);
        bul.append(",");
        bul.append(this.pointdifference);
        bul.append(",");
        bul.append(this.pointsummary);
        return bul.toString();
    }
    
}
