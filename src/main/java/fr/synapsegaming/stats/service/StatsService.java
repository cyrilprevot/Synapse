package fr.synapsegaming.stats.service;

import java.util.HashMap;
import java.util.List;

import fr.synapsegaming.stats.entity.Stats;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Role;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

public interface StatsService {

	public List<List> getAllStats();
	
	public List<Stats<Race>> getRaceStats();
	
	public List<Clazz> getClazzStats();
	
	public List<Specialization> getSpecializationStats();
	
	//public List<Role> getRoleStats();
	
	public List<User> getUserStats();
	

}
