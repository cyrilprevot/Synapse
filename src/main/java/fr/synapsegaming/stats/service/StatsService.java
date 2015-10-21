package fr.synapsegaming.stats.service;

import java.util.HashMap;
import java.util.List;

import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Role;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;

public interface StatsService {

	public List<HashMap> getAllStats();
	
	public HashMap<Race,Integer> getRaceStats();
	
	public HashMap<Clazz,Integer> getClazzStats();
	
	public HashMap<Specialization, Integer> getSpecializationStats();
	
	//public List<Role> getRoleStats();
	
	public List<User> getUserStats();
	

}
