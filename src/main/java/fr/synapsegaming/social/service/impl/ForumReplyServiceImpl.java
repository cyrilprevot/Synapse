package fr.synapsegaming.social.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.synapsegaming.social.dao.ForumReplyDao;
import fr.synapsegaming.social.entity.ForumReply;
import fr.synapsegaming.social.service.ForumReplyService;
import fr.synapsegaming.user.entity.User;
import fr.synapsegaming.user.enums.GroupEnum;

@Service("ForumReplyService")
@Transactional
public class ForumReplyServiceImpl implements ForumReplyService{
	  @Autowired
	    ForumReplyDao forumReplyDao;
	  
	  
	@Override
	public long nbReplyByUser(User user) {
		
		if (user != null && user.getId() > 0) {
            return forumReplyDao.nbReplyByUser(user.getId());
        } else {
            return forumReplyDao.nbReplyByUser(GroupEnum.GUEST.getCode());
        }
	}

	
	
}
