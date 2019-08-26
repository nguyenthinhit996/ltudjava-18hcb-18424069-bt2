/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoDAL;

import excercisetwoBLL.FileDAL;
import exercisetwoDTO.ClassSubjectDTO;
import exercisetwoDTO.SubjectDTO;
import hibernateinfo.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author peter
 */
public class ClassSubjectDAL {
    
  final static Logger logger = Logger.getLogger(ClassDAL.class);
  
  public List<ClassSubjectDTO> getAllScheduleByIdClass(String idclass){
        Session session=null;
        List<ClassSubjectDTO> ds=null;
        try{
            logger.info("start get schedule by "+idclass);
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from ClassSubjectDTO d";
            Query query =session.createQuery(hql);
            //query.setString("idclass",idclass);
            ds=query.list();
            logger.info("end get schedule by "+idclass);
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
        if(!ds.isEmpty()|| ds.size()>0){
            List<ClassSubjectDTO> dss= new ArrayList<>();
            for(ClassSubjectDTO i: ds){
                {
                    String a=i.getClassdto();
                    System.out.println("Test "+a);
                    if(a.contains(idclass)){
                        dss.add(i);
                    }
                }
            }
            return dss;
        }
        return ds;
        
    }
  
  public List<ClassSubjectDTO> getAllScheduleByIdClass2(String idclass){
        Session session=null;
        List<ClassSubjectDTO> ds=null;
        try{
            logger.info("start get schedule by "+idclass);
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from ClassSubjectDTO d where d.id_class_sub =:idclass";
            Query query =session.createQuery(hql);
            query.setString("idclass",idclass);
            ds=query.list();
            logger.info("end get schedule by "+idclass);
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
//        if(!ds.isEmpty()|| ds.size()>0){
//            List<ClassSubjectDTO> dss= new ArrayList<>();
//            for(ClassSubjectDTO i: ds){
//                {
//                    String a=i.getClassdto();
//                    System.out.println("Test "+a);
//                    if(a.contains(idclass)){
//                        dss.add(i);
//                    }
//                }
//            }
//            return dss;
//        }
        return ds;
        
    }
  
  public List<ClassSubjectDTO> getAllSchedule(){
        Session session=null;
        List<ClassSubjectDTO> ds=null;
        try{
            logger.info("start get schedule by ");
            session=HibernateUtil.getSessionFactory().openSession();
            session.clear();
            session.flush();
            String hql="select d from ClassSubjectDTO d";
            Query query =session.createQuery(hql);
            ds=query.list();
            logger.info("end get schedule by ");
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
           session.flush();
           session.close();
        }
        return ds;
    }
    
  
    public List<ClassSubjectDTO> readFromFile(String path){
        FileDAL filedal= new FileDAL(path);
        List<ClassSubjectDTO> colstu=new LinkedList<>();
        BufferedReader buff= filedal.createBufferedReader();
        if(buff != null){
            try {
                String line;
                final String nameclass=buff.readLine();
                String id_class_sub="";
                while((line=buff.readLine())!=null){   
                    String [] content=line.split(",");
                    if(content.length ==3){
                        id_class_sub=nameclass+"_"+content[0];
                        SubjectDTO sub=new SubjectDTO(content[0], content[1]);
                        logger.info("start read shecdule "+ line);
                        ClassSubjectDTO classSubjectDTOs=new ClassSubjectDTO(id_class_sub, nameclass, sub, content[2]);
                        colstu.add(classSubjectDTOs);
                        logger.info("end read shecdule "+ line);
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
    
    public int  writeShedule(List<ClassSubjectDTO> lsd){
        Session session=null;
        int status=0;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tran=session.beginTransaction();
            Iterator in=lsd.iterator();
            while(in.hasNext()){
                ClassSubjectDTO tem=(ClassSubjectDTO) in.next();
                session.saveOrUpdate(tem);
            }
            tran.commit();
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
            status=1;
        }finally{
            session.clear();
           session.flush();
            session.close();
        }
        return status;
    }
    
    public ClassSubjectDTO getClassSubjectDTOById(String id){
        Session session=null;
        List<ClassSubjectDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from ClassSubjectDTO d";
            Query query =session.createQuery(hql);
            //query.setString("id", id);
            ds=query.list();
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
       if(!ds.isEmpty()|| ds.size()>0){
            List<ClassSubjectDTO> dss= new ArrayList<>();
            for(ClassSubjectDTO i: ds){
                {
                    String a=i.getId_class_sub();
                    System.out.println("Test "+a);
                    if(a.contains(id)){
                        dss.add(i);
                    }
                }
            }
            return dss.get(0);
        }
       return null;
    }
}
