package fr.synapsegaming.social.dao;

import org.springframework.beans.factory.annotation.Autowired;

import fr.synapsegaming.commons.dao.AbstractDaoTest;

public class ForumPostDaoTest extends AbstractDaoTest {
	private static final int NB_FORUMS_FOR_ADMIN = 3;
	private static final int NB_FORUMS_FOR_GUEST = 1;
	
	
	@Autowired
	ForumPostDao forumPostDao;
	
	
}
