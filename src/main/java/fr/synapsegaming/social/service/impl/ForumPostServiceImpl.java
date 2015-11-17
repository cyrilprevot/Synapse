package fr.synapsegaming.social.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.social.dao.ForumPostDao;
import fr.synapsegaming.social.service.ForumPostService;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.enums.GroupEnum;

@Service("ForumPostService")
@Transactional
public class ForumPostServiceImpl implements ForumPostService {
	
	
	   @Autowired
	    ForumPostDao forumPostDao;
	   
	   
	@Override
	public long nbPostByUser(User user) {
		
		if (user != null && user.getId() > 0) {
            return forumPostDao.nbPostByUser(user.getId());
        } else {
            return forumPostDao.nbPostByUser(GroupEnum.GUEST.getCode());
        }
		
	}

}
