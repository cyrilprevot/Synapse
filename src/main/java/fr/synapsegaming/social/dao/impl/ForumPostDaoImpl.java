package fr.synapsegaming.social.dao.impl;

import java.util.Collections;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.social.dao.ForumPostDao;
import fr.synapsegaming.social.entity.ForumPost;



@Repository("ForumPostDao")
public class ForumPostDaoImpl extends AbstractDao<ForumPost, Long> implements
        ForumPostDao {
	
	private static final Logger LOGGER = Logger.getLogger(ForumPostDaoImpl.class);

	 public long nbPostByUser(long idUser){
		 
	Session session = this.getSession();
	try {
        Query query = session
                .createQuery("select count(*) from ForumPost f where author.id = :idUser");
        	query.setParameter("idUser", idUser);

        return (long)query.uniqueResult();
    } catch (Exception e) {
        LOGGER.warn(e);
        LOGGER.warn("Il n'y a pas d'utilisateur enregistré");
        return 0;
    } finally {
        session.close();
    }
}
	 }



