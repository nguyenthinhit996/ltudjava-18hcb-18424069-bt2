/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoDAL;

import exercisetwoDTO.ClassDTO;
import hibernateinfo.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
 

/**
 *
 * @author peter
 */
public class ClassDAL {
    
   final static Logger logger = Logger.getLogger(ClassDAL.class);
    
   public List<ClassDTO> getAllClass(){
       Session session=HibernateUtil.getSessionFactory().openSession();
       List<ClassDTO> ds=null;
       
       try{
           String hql="select cla from ClassDTO cla";
           Query query=session.createQuery(hql);
           ds=query.list();
       }catch(HibernateError e){
           logger.error(e.getMessage(), e);
       }finally{
           session.clear();
           session.flush();
           session.close();
       }
       logger.info("Ok get all ds class : "+ds.toString());
       return ds;
   }
   
   public ClassDTO getAllClassById(String s){
       Session session=HibernateUtil.getSessionFactory().openSession();
       List<ClassDTO> ds=null;
       
       try{
           String hql="select cla from ClassDTO cla where cla.idclass = :id";
           Query query=session.createQuery(hql);
           query.setString("id", s);
           ds=query.list();
       }catch(HibernateError e){
           logger.error(e.getMessage(), e);
       }finally{
           session.clear();
           session.flush();
           session.close();
       }
       logger.info("Ok get all ds class : "+ds.toString());
       if(!ds.isEmpty()){
           return ds.get(0);
       }
       return null;
   }
   
   public static int updateOrsave(ClassDTO cla){
       Session session=HibernateUtil.getSessionFactory().openSession();
       int status=0;
       Transaction transaction=null;
       try{
           logger.info("start save: "+cla.getIdclass());
           transaction= session.beginTransaction();
           session.saveOrUpdate(cla);
           transaction.commit();
           logger.info("end save: "+cla.getIdclass());
       }catch(HibernateException e){
           logger.error(e.getMessage(), e);
           status= 1;
       }finally{
           session.clear();
           session.flush();
           session.close();
       }
       logger.info("Ok udpate or save : ");
       return status;
   }
   
   public static void main(String[] args){
       logger.info("start test class DAl ");
       ClassDTO cdto= new ClassDTO("19HB","lớp chất lượng cao đó nhal");
       int s=ClassDAL.updateOrsave(cdto);
       logger.debug("end test class DAl "+s);
       ClassDAL ClassDAL= new ClassDAL();
       List<ClassDTO> ds=ClassDAL.getAllClass();
       for(int i=0;i<ds.size();i++){
           System.out.println(ds.get(i).getNameclass());
       }
        logger.debug("end test class DAl "+ds.size());
   }
   
}
