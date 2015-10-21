package fr.synapsegaming.user.dao.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.stats.entity.Stats;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.User;

@Repository("RaceDao")
public class RaceDaoImpl extends AbstractDao<Race, Long> implements RaceDao {

	/**
     * The logger
     */
    private static final Logger LOGGER = Logger.getLogger(RaceDaoImpl.class);

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Stats<Race>> statsRace() {
    	Session session = this.getSession();
        try {	
            Query query = session
            		.createQuery("SELECT race, count(*) as nb FROM User group by race order by nb desc limit 5");
            return query.list();
        } catch (Exception e) {
            LOGGER.warn(e);
            return Collections.emptyList();
        } finally {
            session.close();
        }
	}


	@SuppressWarnings("unchecked")	
    @Override
    public Race findById(int id) {
        return (Race) DataAccessUtils.uniqueResult(getHibernateTemplate().find("from Race r where r.id_race = ?", id));
    }

}
