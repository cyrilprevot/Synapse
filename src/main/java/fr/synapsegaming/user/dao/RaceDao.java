package fr.synapsegaming.user.dao;

import java.util.HashMap;
import java.util.List;

import fr.synapsegaming.commons.dao.Dao;
import fr.synapsegaming.stats.entity.Stats;
import fr.synapsegaming.user.entity.Race;

/**
 * <b>RaceDao</b> is the public interface who describe the Race DAO
 * 
 * @author Meidi
 * 
 */
public interface RaceDao extends Dao<Race, Long> {

	List<Stats<Race>> statsRace();
	
	Race findById(int id);

}
