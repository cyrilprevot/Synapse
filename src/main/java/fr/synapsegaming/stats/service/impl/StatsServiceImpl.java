package fr.synapsegaming.stats.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.social.entity.ForumPost;
import fr.synapsegaming.social.service.ForumPostService;
import fr.synapsegaming.social.service.ForumReplyService;
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

	/*
	@Autowired
    private StatsDao statsDao;
    */
	@Autowired
	 UserService userService;
	@Autowired
	 ForumPostService forumPostService;
	@Autowired
	 ForumReplyService forumReplyService;
	


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
		
		return bvc.sortAndResize(nbMostPlayedRaces);
	}

	@Override
	public Map getMostPlayedClazz(int nbMostPlayedClazz) {
		HashMap<Clazz, Integer> ClazzStats = new HashMap <Clazz, Integer>();
		for(User u : userService.getAllUsers()){
			if(ClazzStats.containsKey(u.getClazz())){
				ClazzStats.put(u.getClazz(), ClazzStats.get(u.getClazz())+1);
			} else{
				ClazzStats.put(u.getClazz(), 1);
			}
		}
        Comparateur bvc = new Comparateur(ClazzStats);
		
		return bvc.sortAndResize(nbMostPlayedClazz);
	}

	@Override
	public Map getMostPlayedSpecialization(int nbMostPlayedSpecialization) {
		HashMap<Specialization, Integer> SpecializationStats = new HashMap <Specialization, Integer>();
		for(User u : userService.getAllUsers()){
			if(SpecializationStats.containsKey(u.getSpec())){
				SpecializationStats.put(u.getSpec(), SpecializationStats.get(u.getSpec())+1);
			} else{
				SpecializationStats.put(u.getSpec(), 1);
			}
		}
        Comparateur bvc = new Comparateur(SpecializationStats);
		
		return bvc.sortAndResize(nbMostPlayedSpecialization);
	}

	@Override
	public Map getUserStats(int nbMostActifUser) {
		
		
		HashMap<User, Integer> UserStats = new HashMap <User, Integer>();
		
		for(User u : userService.getAllUsers()){ 
			
			UserStats.put(u ,  (int)(forumPostService.nbPostByUser(u) + forumReplyService.nbReplyByUser(u)) );
		
		}
		

        Comparateur bvc = new Comparateur(UserStats);
		
		return bvc.sortAndResize(nbMostActifUser);		
		
	}

	@Override
	public Map getMostPlayedClazzByRace(int nbMostPlayedClazz, long idRace) {
		HashMap<Clazz, Integer> clazzStats = new HashMap <Clazz, Integer>();
		for(User u : userService.getAllUsers()){
			if(clazzStats.containsKey(u.getClazz()) && u.getRace().getId()==idRace){
				clazzStats.put(u.getClazz(), clazzStats.get(u.getClazz())+1);
			} else if(u.getRace().getId()==idRace){
				clazzStats.put(u.getClazz(), 1);
			}
		}
        Comparateur bvc = new Comparateur(clazzStats);
		
		return clazzStats;
	}
	
	@Override
	public Map getMostPlayedSpecializationByRace(long idClazz) {
		HashMap<Specialization, Integer> specStats = new HashMap <Specialization, Integer>();
		for(User u : userService.getAllUsers()){
			if(specStats.containsKey(u.getSpec()) && u.getClazz().getId()==idClazz){
				specStats.put(u.getSpec(), specStats.get(u.getSpec())+1);
			} else if(u.getClazz().getId()==idClazz){
				specStats.put(u.getSpec(), 1);
			}
		}
        Comparateur bvc = new Comparateur(specStats);
		
		return specStats;
	}
		
		
	


}
