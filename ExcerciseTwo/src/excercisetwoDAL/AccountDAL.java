/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excercisetwoDAL;

import exercisetwoDTO.AccountDTO;
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
public class AccountDAL {
      
     final static Logger logger = Logger.getLogger(AccountDAL.class);
    
    public static AccountDTO getAccountByAcc(String acc,String  pass){
        List<AccountDTO>ds=null;
        Session session=null;
        try{
            logger.debug(" Start get account by "+acc);
            session=HibernateUtil.getSessionFactory().openSession();
            String hql="select acc from AccountDTO acc where acc.idacc = :idacc and acc.pass =:pass";
            Query query=session.createQuery(hql);
            query.setString("idacc",acc);
            query.setString("pass",pass);
            ds= query.list();
            logger.debug(" Get account by "+ds.toString());
            logger.debug(" End get account by "+acc);
        }
        catch(HibernateException e){
            logger.error(e);
        }finally{
            session.flush();
            session.close();
        }
        if(ds.size()>=1){
            return ds.get(0);
        }
        return null;
    }
}
