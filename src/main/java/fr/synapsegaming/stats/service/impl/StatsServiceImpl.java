package fr.synapsegaming.stats.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.ui.dao.ResourceDao;
import fr.synapsegaming.user.dao.ClazzDao;
import fr.synapsegaming.user.dao.RaceDao;
import fr.synapsegaming.user.dao.SpecializationDao;
import fr.synapsegaming.user.dao.UserDao;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Race;
import fr.synapsegaming.user.entity.Role;
import fr.synapsegaming.user.entity.Specialization;
import fr.synapsegaming.user.entity.User;


@Service("StatsService")
@Transactional
public class StatsServiceImpl implements StatsService
{

	/*
	@Autowired
    private StatsDao statsDao;
    */
	@Autowired
    private RaceDao raceDao;
	@Autowired
    private ClazzDao clazzDao;
	@Autowired
    private SpecializationDao specializationDao;
	@Autowired
    private UserDao userDao;
	
	@Override
	public List<HashMap> getAllStats() {
			// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<Race,Integer> getRaceStats() {
		
		return null;
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
