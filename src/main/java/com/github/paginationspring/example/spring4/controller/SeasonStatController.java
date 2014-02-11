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
public class SeasonStatController extends PaginationControllerAbstract<BoSeasonStatSearchParam> {
    private static Logger log = Logger.getLogger(SeasonStatController.class);
    
    private SeasonStatService seasonStatService;

    public SeasonStatController() {
        setOptionDisplayCheckbox(true);
        setOptionDisplaySerialNo(true);
        setOptionWidth(950);
        setDefaultRecordPerPage(10);
        setDefaultSortName("Season");
        setDefaultSortAscDesc("d");
        setPageLink("/org/pagination/example/spring4/bball-season-stat.do"); // url
    }

    @RequestMapping(value="/bball-season-stat.do", method = {RequestMethod.GET, RequestMethod.POST})
    public String defineJsp(@ModelAttribute(PPARAM) BoSeasonStatSearchParam pparam, @RequestParam(value=BUTTON_ACTION, required=false) String buttonAction, Model model) throws Exception {
        Map<String, Object> map = assignModel(pparam, buttonAction);
        model.addAllAttributes(map);
        model.addAttribute("teamList", seasonStatService.retrieveTeamAliass());

        if ( "deleteButton".equalsIgnoreCase(buttonAction) && !ArrayUtils.isEmpty(pparam.getSelectedIds()) ) {
            // deleteButton button is pressed
            for ( String pk : pparam.getSelectedIds() ) {
                log.info("selected id="+pk);
            }
        }
        return "/org/pagination/example/spring4/view/seasonstat";
    }
    
    @Autowired
    public void setPaginationService(SeasonStatService seasonStatService) {
        super.setPaginationService(seasonStatService);
        this.seasonStatService=seasonStatService;
    }
}
