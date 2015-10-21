package fr.synapsegaming.stats.dao.impl;

import java.util.Collections;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import fr.synapsegaming.commons.dao.AbstractDao;
import fr.synapsegaming.stats.dao.StatsDao;
import fr.synapsegaming.stats.entity.Stats;
import fr.synapsegaming.ui.dao.impl.ResourceDaoImpl;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Role;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

@Repository("StatsDao")
public class StatsDaoImpl extends AbstractDao<List, Long> implements
StatsDao {

	/**
     * The logger
     */
    private static final Logger LOGGER = Logger
            .getLogger(ResourceDaoImpl.class);

	
    @SuppressWarnings("unchecked")
	@Override
	public List<Race> statsRace() {
    	Session session = this.getSession();
        try {	
            Query query = session
                    .createQuery("count(*) as nb1 , id_race FROM `users` group by id_race order by nb1 desc limit 5");
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
	public List<Clazz> statsClazz() {
		// TODO Auto-generated method stub
		return null;
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<Specialization> statsSpecialization() {
		// TODO Auto-generated method stub
		return null;
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<Role> statsRole() {
		// TODO Auto-generated method stub
		return null;
	}

    @SuppressWarnings("unchecked")
	@Override
	public List<User> statsUser() {
		// TODO Auto-generated method stub
		return null;
	}

}
