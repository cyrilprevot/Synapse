package fr.synapsegaming.stats.controller;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import fr.synapsegaming.commons.controller.AbstractController;
import fr.synapsegaming.media.service.ArticleService;
import fr.synapsegaming.raid.service.ExtensionService;
import fr.synapsegaming.stats.service.StatsService;
import fr.synapsegaming.ui.service.ResourceService;
import fr.synapsegaming.user.entity.Clazz;
import fr.synapsegaming.user.entity.Specialization;


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
	 
	 private static final String STATUSERSWITHOUTAVATAR_HTTP_ATTRIBUTE = "statsUsersWithoutAvatar";	
	 
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
    public ModelAndView statistiques(HttpServletRequest request){
    	page = new ModelAndView();

    	
        page.setViewName(STATS_VIEW_NAME);

        page.addObject(RESOURCES_HTTP_ATTRIBUTE, resourceService.listMainMenu());
        page.addObject(PROMS_HTTP_ATTRIBUTE, articleService.getFiveLastProms());
        page.addObject(EXTENSION_HTTP_ATTRIBUTE, extensionService.getLastExtension());
        page.addObject(STATSRACE_HTTP_ATTRIBUTE, statsService.getMostPlayedRaces(NB_RACES_MOST_PLAYED));
        page.addObject(EXTENSION_HTTP_ATTRIBUTE, extensionService.getLastExtension());
        page.addObject(STATSCLAZZ_HTTP_ATTRIBUTE, statsService.getMostPlayedClazz(NB_CLAZZ_MOST_PLAYED));
        page.addObject(STATSSPEC_HTTP_ATTRIBUTE, statsService.getMostPlayedSpecialization(NB_SPECIALIZATION_MOST_PLAYED));
        page.addObject(STATSUSER_HTTP_ATTRIBUTE, statsService.getUserStats(NB_USER_MOST_ACTIVE));
        page.addObject(STATUSERSWITHOUTAVATAR_HTTP_ATTRIBUTE, statsService.getUsersWithoutAvatar());

    	return page;
    	
    	    	
    }
	
	@RequestMapping(value = "/json/{stattype}/{idtype}", method = RequestMethod.GET)
    @ResponseBody
    public String getSubTopJSON(@PathVariable String stattype, @PathVariable int idtype) {
        
        String json = "[";
        if(stattype.equals("race")){
        	Map<Clazz, Integer> topClazz = statsService.getMostPlayedClazzByRace(5, idtype);
        	for(Map.Entry<Clazz, Integer> entry : topClazz.entrySet()){
        		json = json + "{\"id\":\"" + entry.getKey().getId() + "\"," 
        				+ "\"name\":\"" + entry.getKey().getName() + "\"," 
        				+ "\"nb\":\"" + entry.getValue() 
        				+ "\"},";
        	}
        }else if(stattype.equals("clazz")){
        	Map<Specialization, Integer> topSpec = statsService.getMostPlayedSpecializationByClazz(idtype);
        	for(Map.Entry<Specialization, Integer> entry : topSpec.entrySet()){
        		json = json + "{\"id\":\"" + entry.getKey().getId() + "\"," 
        				+ "\"name\":\"" + entry.getKey().getName() + "\"," 
        				+ "\"nb\":\"" + entry.getValue() 
        				+ "\"},";
        	}
        }
    	json = json.substring(0, json.length() - 1);
        json = json + "]";
        return json;
    }
	
}
