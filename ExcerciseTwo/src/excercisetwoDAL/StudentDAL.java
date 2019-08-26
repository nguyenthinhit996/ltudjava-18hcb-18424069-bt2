/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoDAL;

import excercisetwoBLL.FileDAL;
import exercisetwoDTO.ClassDTO;
import exercisetwoDTO.StudentDTO;
import hibernateinfo.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author peter
 */
public class StudentDAL {
    private Logger logger= Logger.getLogger(this.getClass());
    
    public int writeStudent(List<StudentDTO> lsd){
        int status=0;
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tran=session.beginTransaction();
            Iterator in=lsd.iterator();
            while(in.hasNext()){
                StudentDTO tem=(StudentDTO) in.next();
                session.saveOrUpdate(tem);
            }
            tran.commit();
        }catch(HibernateException e){
             status=1;
            logger.error("Error hibernate "+e.getLocalizedMessage());
           
        }finally{
            session.clear();
           session.flush();
            session.close();
        }
        return status;
    }
    
    public List<StudentDTO> getAllStudentByIdClass(String idclass){
        Session session=null;
        List<StudentDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            session.flush();
            String hql="select d from StudentDTO d where d.classdto.idclass = :idclass";
            Query query =session.createQuery(hql);
            query.setString("idclass",idclass);
            ds=query.list();
           
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
        return ds;
    }
    
    public List<StudentDTO> getAllStudent(){
        Session session=null;
        List<StudentDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from StudentDTO d inner join fetch d.classdto";
            Query query =session.createQuery(hql);
            ds=query.list();
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
        return ds;
    }
    
    public StudentDTO getStudentById(String id){
        Session session=null;
        List<StudentDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from StudentDTO d where d.idstudent=:id";
            Query query =session.createQuery(hql);
            query.setString("id", id);
            ds=query.list();
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
       if(ds.size()>0){
            return ds.get(0);
        }
        return null;
    }
    
    public List<StudentDTO> readFromFile(String path){
        FileDAL filedal= new FileDAL(path);
        String nameclass="";
        List<StudentDTO> colstu=new LinkedList<>();
        BufferedReader buff= filedal.createBufferedReader();
        if(buff != null){
            try {
                String line;
                nameclass=buff.readLine();
                ClassDTO cla= new ClassDTO(nameclass);
                while((line=buff.readLine())!=null){
                    
                    String [] content=line.split(",");
                    if(content.length ==4){
                        logger.info("start read student "+ line);
                        if(StringUtils.isNumeric(content[3])){
                         StudentDTO stu= new StudentDTO(content[0],content[1],content[2]
                                 ,Long.valueOf(content[3]), cla);
                         colstu.add(stu);
                        }
                        logger.info("end read student "+ line);
                    }
                }
                buff.close();
            } catch (IOException ex) {
                logger.error(ex);
            }
        }else{
            logger.info("Error get bufferedReder "+ this.getClass().toString());
            return null;
        }
        return colstu;
    }
    
    public int writeStudent2(StudentDTO tem){
        int status=0;
        Session session=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tran=session.beginTransaction();
            session.saveOrUpdate(tem);
            tran.commit();
        }catch(HibernateException e){
            status=1;
            logger.error("Error hibernate "+e.getLocalizedMessage());
            throw new HibernateException(e);
            
        }finally{
            session.clear();
           session.flush();
            session.close();
        }
        return status;
    }
    
    public static void main(String [] args){
        StudentDAL studentDAL = new StudentDAL();
        List<StudentDTO>ds=studentDAL.getAllStudentByIdClass("18HCB");
        for(StudentDTO i:ds){
            System.out.println(i.getIdstudent());
        }
        
    }
}
