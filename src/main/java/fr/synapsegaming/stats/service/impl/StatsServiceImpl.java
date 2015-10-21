package fr.synapsegaming.stats.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.service.UserService;


@Service("StatsService")
@Transactional
public class StatsServiceImpl implements StatsService
{

	/*
	@Autowired
    private StatsDao statsDao;
    */
	@Autowired
	 UserService userService;

	
	@Override
	public List<HashMap> getAllStats() {
			// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Race,Integer> getRaceStats() {
		HashMap<Race, Integer> statsRace = new HashMap<Race,Integer>();
		for(User u : userService.getAllUsers()){
			if(statsRace.containsKey(u.getRace())){
				statsRace.put(u.getRace(), statsRace.get(u.getRace())+1);
			}else{
				statsRace.put(u.getRace(),1);
			}
		}
		return statsRace;
	}

	@Override
	public HashMap<Clazz, Integer> getClazzStats() {
		return null;
	}

	@Override
	public HashMap<Specialization, Integer> getSpecializationStats() {
		return null;
	}

	@Override
	public List<User> getUserStats() {
		return null;
	}

	@Override
	public HashMap<Race, Integer> getFiveTopRace() {
		HashMap<Race, Integer> statsRace = this.getRaceStats();
		return null;
	}

}
