package fr.synapsegaming.stats.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.service.UserService;
import fr.synapsegaming.utils.Comparateur;


@Service("StatsService")
@Transactional
public class StatsServiceImpl implements StatsService
{

	private static final int NB_RACES_MOST_PLAYED = 5;
	/*
	@Autowired
    private StatsDao statsDao;
    */
	@Autowired
	 UserService userService;


	@Override
	public Map getMostPlayedRaces(int nbMostPlayedRaces) {
		HashMap<Race, Integer> statsRace = new HashMap<Race,Integer>();
		for(User u : userService.getAllUsers()){
			if(statsRace.containsKey(u.getRace())){
				statsRace.put(u.getRace(), statsRace.get(u.getRace())+1);
			}else{
				statsRace.put(u.getRace(),1);
			}
		}
        Comparateur bvc = new Comparateur(statsRace);
		
		return bvc.sortAndResize(NB_RACES_MOST_PLAYED);
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



}
