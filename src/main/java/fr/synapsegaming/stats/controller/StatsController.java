package fr.synapsegaming.stats.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.media.service.ArticleService;
import fr.synapsegaming.raid.service.ExtensionService;
import fr.synapsegaming.raid.service.RaidService;
import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.ui.service.ResourceService;


/**
 * <b>StatsController</b> route every action made for a user
 * 
 * @author Cyril
 * test
 */
@Controller("StatsController")
@SessionAttributes(value = { "user", "userResources" })
@RequestMapping("/stats")
public class StatsController extends AbstractController{

	
	 private static final int NB_SPECIALIZATION_MOST_PLAYED = 5;

	private static final int NB_CLAZZ_MOST_PLAYED = 5;

	private static final String STATS_VIEW_NAME = "Statistiques";
	    
	 private static final String EXTENSION_HTTP_ATTRIBUTE = "extension";

	 private static final String PROMS_HTTP_ATTRIBUTE = "proms";

	 private static final String RESOURCES_HTTP_ATTRIBUTE = "resources";

	 private static final String STATSRACE_HTTP_ATTRIBUTE = "statsRace";
	 
	 private static final String STATSCLAZZ_HTTP_ATTRIBUTE = "statsClazz";
	 
	 private static final String STATSSPEC_HTTP_ATTRIBUTE = "statsSpec";
	 
	 private static final String STATSUSER_HTTP_ATTRIBUTE = "statsUser";
	 
	 private static final String STATSCLAZZBYRACE_HTTP_ATTRIBUTE = "statsClazzByRace";
	 
	 private static final int NB_RACES_MOST_PLAYED = 5;
	 
	 private static final int NB_USER_MOST_ACTIVE = 5;


	 @Autowired
	 ArticleService articleService;

	 @Autowired
	 ResourceService resourceService;

	 @Autowired
	 ExtensionService extensionService;
	 
	 @Autowired
	 StatsService statsService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView statistiques(){
    	page = new ModelAndView("Statistiques");
        page.addObject(RESOURCES_HTTP_ATTRIBUTE, resourceService.listMainMenu());
        page.addObject(PROMS_HTTP_ATTRIBUTE, articleService.getFiveLastProms());
        page.addObject(EXTENSION_HTTP_ATTRIBUTE, extensionService.getLastExtension());
        page.addObject(STATSRACE_HTTP_ATTRIBUTE, statsService.getMostPlayedRaces(NB_RACES_MOST_PLAYED));
        page.addObject(EXTENSION_HTTP_ATTRIBUTE, extensionService.getLastExtension());
        page.addObject(STATSCLAZZ_HTTP_ATTRIBUTE, statsService.getMostPlayedClazz(NB_CLAZZ_MOST_PLAYED));
        page.addObject(STATSCLAZZBYRACE_HTTP_ATTRIBUTE, statsService.getMostPlayedClazzByRace(NB_CLAZZ_MOST_PLAYED, 1));
        page.addObject(STATSSPEC_HTTP_ATTRIBUTE, statsService.getMostPlayedSpecialization(NB_SPECIALIZATION_MOST_PLAYED));
        page.addObject(STATSUSER_HTTP_ATTRIBUTE, statsService.getUserStats(NB_USER_MOST_ACTIVE));
        
    	page.setViewName(STATS_VIEW_NAME);
    	return page;
    
    }
	
	
	
}
