package fr.synapsegaming.stats.dao;

import java.util.List;

import fr.synapsegaming.commons.dao.Dao;
import fr.synapsegaming.stats.entity.Stats;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Role;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

public interface StatsDao extends Dao<List, Long>{

	public List<Race> statsRace();

	public List<Clazz> statsClazz();

	public List<Specialization> statsSpecialization();

	public List<Role> statsRole();

	public List<User> statsUser();

}
