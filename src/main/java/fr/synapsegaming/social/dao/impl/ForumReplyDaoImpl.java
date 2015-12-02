package fr.synapsegaming.social.dao.impl;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.social.entity.ForumReply;

@Repository("ForumReplyDao")
public class ForumReplyDaoImpl extends AbstractDao<ForumReply, Long> implements
        ForumReplyDao {

	private static final Logger LOGGER = Logger.getLogger(ForumReplyDaoImpl.class);

	 public long nbReplyByUser(long idUser){
		 
	Session session = this.getSession();
	try {
       Query query = session
    		   
               .createQuery("select count(*) from ForumReply f where author.id = :idUser");
       	query.setParameter("idUser", idUser);
       return (long)query.uniqueResult();
   } catch (Exception e) {
       //LOGGER.warn(e);
       LOGGER.warn("Il n'y a pas d'utilisateur enregistré");
       return 50;
   } finally {
       session.close();
   }
}
}
