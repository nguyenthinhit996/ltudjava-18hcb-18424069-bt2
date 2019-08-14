/*
 * ?o change this license header, choose License Headers in Project Properties.
 * ?o change this template file, choose ?ools | ?emplates
 * and open the template in the editor.
 */
package excerciseone.DAL;

import excerciseone.BLL.Common;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author peter
 *  
 */
public class FileDAL{
    private String path;
    
    public FileDAL(String p)
    {
        this.path=p;
    }
    public BufferedReader createBufferedReader(){
        File file= new File(getPath());
        if(file.exists()){
            BufferedReader br= null;
            try {
                
                br = new BufferedReader(new FileReader(file));
                 
                return br;
            } catch (FileNotFoundException ex) {
                Logger.getLogger(FileDAL.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }else{
            Logger.getLogger("File not found ");
            return null;
        }
    }  
    
    public BufferedWriter createBufferwriter(){
        BufferedWriter bufferedWriter= null;
        try {
            File file= new File(getPath());
            file.createNewFile();
            bufferedWriter = new BufferedWriter(new FileWriter(file));
        } catch (IOException ex) {
            Logger.getLogger(FileDAL.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
             
            return bufferedWriter;
            
        }
        
    }
    
     public static ArrayList<String> getAllSchoolYearExists(){
          ArrayList<String> sy= new ArrayList<>();
          File folder = new File("repository");
          File[] file= folder.listFiles();
          for(File fi:file){
              if(fi.isDirectory()){
               sy.add(fi.getName());   
              }
          }
          Collections.sort(sy);
          return sy;
      }
     
      public static ArrayList<String> getAllClassExists(String year){
          String path="repository"+ File.separator+year;
          ArrayList<String> sy= new ArrayList<>();
          File folder = new File(path);
          File[] file= folder.listFiles();
          for(File fi:file){
              if(fi.isDirectory()){
               sy.add(fi.getName());   
              }
          }
          Collections.sort(sy);
          return sy;
      }
     
      static boolean checkFileExistInSystem(String namefile){
        String namefi=Common.getNameClass(namefile);
        ArrayList<String> colYear= FileDAL.getAllSchoolYearExists();
        for(String di:colYear){
            ArrayList<String> colClass= FileDAL.getAllClassExists(di);
            if(colClass.contains(namefi)){
                return true;
            }
        }
        return false;
    }

    static boolean  createDirectory(String namedir){
        boolean status=true;
        String namesclass=namedir;
        String getyear=namedir.replaceAll("[a-zA-Z].*$", "");
        ArrayList<String> colYear= FileDAL.getAllSchoolYearExists();
        for(String di:colYear){
            if(di.indexOf(getyear)>=0){
             String path="repository"+File.separator+di+File.separator+namesclass;
              return new File(path).mkdir();
            }
        }
        getyear ="20"+getyear;
        String path="repository"+File.separator+getyear;
        status=new File(path).mkdir();
        path = path +File.separator+namesclass;
        status=new File(path).mkdir();
        return status;
    }
    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }
    
    public static String getPathFile(final String namefile){
        String names=namefile;
        String name2s=namefile;
        String getyear=names.replaceAll("[a-zA-Z].*$", "");
        getyear = "20"+getyear;  
        return "repository"+File.separator+getyear
        +File.separator+Common.getNameClass(name2s)+File.separator+namefile+".txt";
    }
    
    public static FileNameExtensionFilter myFileFilter(){
        
        return new FileNameExtensionFilter("File csv","csv"); 
    }
}
