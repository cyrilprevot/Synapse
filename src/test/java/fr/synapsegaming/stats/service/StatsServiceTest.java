package fr.synapsegaming.stats.service;

import static org.junit.Assert.assertTrue;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class StatsServiceTest {
	
	@Autowired
	StatsService  statsService;
	
	private static final int NB_RESULT = 5;
	private static final long NUM_RACE = 1;
	private static final long NUM_CLASS = 1;



	@Test
	public void testListUsersWithoutAvatar() {
		assertTrue(CollectionUtils.isNotEmpty(statsService.getUsersWithoutAvatar()));
	}
	@Test
	public void testMostPlayedClazz() {
		assertTrue(MapUtils.isNotEmpty(statsService.getMostPlayedClazz(NB_RESULT)));
	}	
	@Test
	public void testMostPlayedClazzByRace() {
		assertTrue(MapUtils.isNotEmpty(statsService.getMostPlayedClazzByRace(NB_RESULT, NUM_RACE)));
	}	
	@Test
	public void testMostPlayedSpecialization() {
		assertTrue(MapUtils.isNotEmpty(statsService.getMostPlayedSpecialization(NB_RESULT)));
	}
	@Test
	public void testMostPlayedSpecializationByRace() {
		assertTrue(MapUtils.isNotEmpty(statsService.getMostPlayedSpecializationByClazz(NUM_CLASS)));
	}
	@Test
	public void testMostPlayedRaces() {
		assertTrue(MapUtils.isNotEmpty(statsService.getMostPlayedRaces(NB_RESULT)));
	}
	
	

}
