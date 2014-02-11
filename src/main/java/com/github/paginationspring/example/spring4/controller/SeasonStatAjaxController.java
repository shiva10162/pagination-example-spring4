package com.github.paginationspring.example.spring4.controller;

import java.util.Map;

import org.apache.commons.lang.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.paginationspring.controller.PaginationControllerAbstract;
import com.github.paginationspring.example.spring4.bo.BoSeasonStatSearchParam;
import com.github.paginationspring.example.spring4.service.SeasonStatService;

@Controller
public class SeasonStatAjaxController extends PaginationControllerAbstract<BoSeasonStatSearchParam> {
    private static Logger log = Logger.getLogger(SeasonStatAjaxController.class);

    private SeasonStatService seasonStatService;

    public SeasonStatAjaxController() {
        setOptionDisplayCheckbox(true);
        setOptionDisplaySerialNo(true);
        setOptionWidth(950);
        setDefaultRecordPerPage(10);
        setDefaultSortName("Season");
        setDefaultSortAscDesc("d");
        setPageLink("/org/pagination/example/spring4/bball-season-stat2_ajax.do");
        setAjax(true);
    }

    @RequestMapping(value="/bball-season-stat2.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String defineJsp(@ModelAttribute(PPARAM) BoSeasonStatSearchParam pparam, Model model) throws Exception {
    	log.debug("pparam.resultIndex="+pparam.getResultIndex());
        Map<String, Object> map = assignModel(pparam, null, false);
        model.addAllAttributes(map);
        model.addAttribute("teamList", seasonStatService.retrieveTeamAliass());
    	return "/org/pagination/example/spring4/view/seasonstat2";
    }

    @RequestMapping(value="/bball-season-stat2_ajax.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String defineAjaxJsp(@ModelAttribute(PPARAM) BoSeasonStatSearchParam pparam, @RequestParam(value=BUTTON_ACTION, required=false) String buttonAction, Model model) throws Exception {
    	log.debug("pparam.resultIndex="+pparam.getResultIndex());
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        if ( "deleteButton".equalsIgnoreCase(buttonAction) && !ArrayUtils.isEmpty(pparam.getSelectedIds()) ) {
            // Delete button is pressed
            log.debug("Delete button is pressed");
            if ( pparam.getSelectedIds() != null ) {
	            for ( String pk : pparam.getSelectedIds() ) {
	                log.debug("delete selected id="+pk);
	            }
            }
        }
        return "/org/pagination/example/spring4/view/seasonstat2_ajax"; // jsp
    }
    
    @Autowired
    public void setPaginationService(SeasonStatService seasonStatService) {
        super.setPaginationService(seasonStatService);
        this.seasonStatService=seasonStatService;
    }
}
