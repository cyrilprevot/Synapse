package fr.synapsegaming.stats.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.stats.entity.Stats;
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
	public List<List> getAllStats() {
			// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Stats<Race>> getRaceStats() {
		return raceDao.statsRace();
	}

	@Override
	public List<Clazz> getClazzStats() {
		return clazzDao.statsClazz();
	}

	@Override
	public List<Specialization> getSpecializationStats() {
		return specializationDao.statsSpecialization();
	}

	@Override
	public List<User> getUserStats() {
		return userDao.statsUser();
	}

}
