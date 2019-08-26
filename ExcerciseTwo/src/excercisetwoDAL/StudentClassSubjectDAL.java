/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoDAL;

import excercisetwoBLL.FileDAL;
import excercisetwoBLL.Frm0002BLL;
import static excercisetwoDAL.ClassDAL.logger;
import static excercisetwoDAL.ClassSubjectDAL.logger;
import exercisetwoDTO.ClassDTO;
import exercisetwoDTO.ClassSubjectDTO;
import exercisetwoDTO.StudentClassSubjectDTO;
import exercisetwoDTO.StudentDTO;
import exercisetwoDTO.SubjectDTO;
import hibernateinfo.HibernateUtil;
import java.io.BufferedReader;
import java.io.IOException;
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
public class StudentClassSubjectDAL {
    
    private Logger logger= Logger.getLogger(this.getClass());
    
    public int writeStudentClassSubjectDAL(List<ClassSubjectDTO> dscs,List<StudentDTO>dss ){
        // get all class that get all student  
        Iterator in= dscs.iterator();
        while(in.hasNext()){
            ClassSubjectDTO classSubjectDTO= (ClassSubjectDTO) in.next();
            logger.debug("start write class "+classSubjectDTO.getId_class_sub());
            Iterator istudent= dss.iterator();
            while(istudent.hasNext()){
                StudentDTO s=(StudentDTO) istudent.next();
                String id_student_classsubject=s.getIdstudent()+"_"+classSubjectDTO.getId_class_sub();
                StudentClassSubjectDTO student= new StudentClassSubjectDTO(id_student_classsubject, s, classSubjectDTO);
                System.out.println(classSubjectDTO.getClassdto());
                if(writeStuClassSubPoi(student)!=0){
                    return 1;
                }
            }
            logger.debug("end write class "+classSubjectDTO.getId_class_sub());
        }
        return 0; 
    }
    
    
    
    public int writeStuClassSubPoi(StudentClassSubjectDTO dto){
        Session session=null;
        int status=0;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tran=session.beginTransaction();
            session.saveOrUpdate(dto);
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
    
    public int writeStuClassSubPoi2(StudentClassSubjectDTO dto){
        Session session=null;
        int status=0;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            Transaction tran=session.beginTransaction();
            session.saveOrUpdate(dto);
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
   
    public List<StudentClassSubjectDTO> getAllClassSubjectDTOById(String id){
        Session session=null;
        List<StudentClassSubjectDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from StudentClassSubjectDTO d where d.classSubjectDTO.id_class_sub = :id_class_sub";
            Query query =session.createQuery(hql);
            query.setString("id_class_sub",id);
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
    
    public List<StudentClassSubjectDTO> getAllClassSubjectDTOByIdStu(String id){
        Session session=null;
        List<StudentClassSubjectDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from StudentClassSubjectDTO d where d.student.idstudent = :id_class_sub";
            Query query =session.createQuery(hql);
            query.setString("id_class_sub",id);
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
    
    public boolean deleteStudentClassSubjectDTO(StudentClassSubjectDTO dto){
       Session session=HibernateUtil.getSessionFactory().openSession();
       Transaction transaction=null;
       try{
           logger.info("start save: "+dto.getId_student_classsubject());
           transaction= session.beginTransaction();
           session.delete(dto);
           transaction.commit();
           logger.info("end save: "+dto.getId_student_classsubject());
       }catch(HibernateException e){
           logger.error(e.getMessage(), e);
           return false;
       }finally{
           session.clear();
           session.flush();
           session.close();
       }
       logger.info("Ok udpate or save : ");
       return true;
    }
    
    public StudentDTO getStudentDTOInStudentClassSubject(String idcsub,String idstu){
        Session session=null;
        List<StudentClassSubjectDTO> ds=null;
        try{
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select d from StudentClassSubjectDTO d where d.classSubjectDTO.id_class_sub = :id_class_sub and d.student.idstudent =:idstu ";
            Query query =session.createQuery(hql);
            query.setString("id_class_sub",idcsub);
            query.setString("idstu",idstu);
            ds=query.list();
        }catch(HibernateException e){
            logger.error("Error hibernate "+e.getLocalizedMessage());
        }finally{
            session.clear();
            session.flush();
            session.close();
        }
        if(ds.size()>0){
            return ds.get(0).getStudent();
        }
        return null;
    }
    
    public List<StudentClassSubjectDTO> readFromFile(String path){
        FileDAL filedal= new FileDAL(path);
        List<StudentClassSubjectDTO> colstu=new LinkedList<>();
        BufferedReader buff= filedal.createBufferedReader();
        if(buff != null){
            try {
                String line;
                final String nameclass=buff.readLine();
                String id_stu_class_sub="";
                ClassSubjectDAL classSubjectDAL= new ClassSubjectDAL();
                ClassSubjectDTO classSubjectDTO=classSubjectDAL.getClassSubjectDTOById(nameclass);
                while((line=buff.readLine())!=null){   
                    String [] content=line.split(",");
                    if(content.length ==6){
                        id_stu_class_sub=content[0]+"_"+classSubjectDTO.getId_class_sub();
                        StudentDAL studentDAL = new StudentDAL();
                        StudentDTO student= studentDAL.getStudentById(content[0]);
                        logger.info("start read point "+ line);
                        StudentClassSubjectDTO po = new StudentClassSubjectDTO(id_stu_class_sub, student, 
                                classSubjectDTO,Integer.valueOf(content[2]),Integer.valueOf(content[3]),
                                Integer.valueOf(content[4]), Float.valueOf(content[5]));
                        colstu.add(po);
                        logger.info("end read point "+ line);
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
    
    public int writePoint(List<StudentClassSubjectDTO> ds){
        Iterator in= ds.iterator();
        while(in.hasNext()){
            StudentClassSubjectDTO dto=(StudentClassSubjectDTO) in.next();
            if(writeStuClassSubPoi(dto)!=0){
                return 1;
            }
        }
        return 0;
    }
    
}