/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoDAL;

import exercisetwoDTO.ClassSubjectDTO;
import hibernateinfo.HibernateUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

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
            session=HibernateUtil.getSessionFactory().getCurrentSession();
            String hql="select d from ClassSubjectDTO d where d.id_class_sub = :idclass";
            Query query =session.createQuery(hql);
            query.setString("idclass",idclass);
            ds=query.list();
            logger.info("end get schedule by "+idclass);
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.flush();
            session.close();
        }
        return ds;
    }
}
