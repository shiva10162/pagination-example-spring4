package com.github.paginationspring.example.spring4.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.paginationspring.bo.BoPaginationColumn;
import com.github.paginationspring.example.spring4.bo.BoSeasonStat;
import com.github.paginationspring.example.spring4.bo.BoSeasonStatSearchParam;
import com.github.paginationspring.example.spring4.dao.SeasonStatDao;
import com.github.paginationspring.example.spring4.entity.PgNbaSeason;
import com.github.paginationspring.example.spring4.entity.PgNbaTeam;
import com.github.paginationspring.service.PaginationServiceAbstract;

@Service
public class SeasonStatService extends PaginationServiceAbstract<BoSeasonStatSearchParam, BoSeasonStat, PgNbaSeason> {
    private static Logger log = Logger.getLogger(SeasonStatService.class);
    
    private SeasonStatDao seasonStatDao;
    
    @Autowired 
    public void setPaginationDao(SeasonStatDao seasonStatDao) {
        super.setPaginationDao(seasonStatDao);
        this.seasonStatDao = seasonStatDao;
    }

	@Override
    public void assignColumnsDefinition(List<BoPaginationColumn> columns)
            throws Exception {
        log.debug("setting columns def.");

        BoPaginationColumn col = null;
        
        col = new BoPaginationColumn();
        col.setColumnName("Season");
        col.setOrderColumns("a.season, c.teamAlias, b.lastName, b.firstName");
        col.setOrderDirections("desc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Player Name");
        col.setOrderColumns("b.lastName, b.firstName, a.season");
        col.setOrderDirections("asc, asc, asc");
        col.setWidth(150);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Team");
        col.setOrderColumns("c.teamAlias, a.season, b.lastName, b.firstName");
        col.setOrderDirections("asc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Pos.");
        col.setOrderColumns("b.position, a.season, c.teamAlias, b.lastName, b.firstName");
        col.setOrderDirections("asc, asc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("G");
        col.setOrderColumns("a.gamePlay, a.season, c.teamAlias, b.lastName, b.firstName");
        col.setOrderDirections("asc, asc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Min");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("FG%");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("3PT%");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("FT%");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Reb");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Ast");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("TO");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Stl");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("Blk");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("PF");
        col.setWidth(30);
        columns.add(col);

        col = new BoPaginationColumn();
        col.setColumnName("PPG");
        col.setOrderColumns("(a.point/a.gamePlay), a.season, c.teamAlias, b.lastName, b.firstName");
        col.setOrderDirections("desc, asc, asc, asc, asc");
        col.setWidth(30);
        columns.add(col);
    }

	@Override
    protected BoSeasonStat assignDataToBo(PgNbaSeason entity) throws Exception {
		BoSeasonStat bo = new BoSeasonStat();
		bo.setNbaSeasonId(entity.getNbaSeasonId());
		bo.setPlayerName (entity.getPgNbaPlayer().getFirstName()+" "+entity.getPgNbaPlayer().getLastName());
		bo.setHeight     (entity.getPgNbaPlayer().getHeightFeet()+"-"+entity.getPgNbaPlayer().getHeightInches());
		bo.setWeight     (String.valueOf(entity.getPgNbaPlayer().getWeight()));
		bo.setTeamName   (entity.getPgNbaTeam().getLocation()+" "+entity.getPgNbaTeam().getTeamName());
		bo.setTeamAlias  (entity.getPgNbaTeam().getTeamAlias());
		bo.setPosition   (entity.getPgNbaPlayer().getPosition());
		bo.setSeason     (entity.getSeason     ());
		bo.setGamePlay   (entity.getGamePlay   ());
		if ( entity.getGamePlay() != 0 ) {
			bo.setMinutePerGame 	((double) entity.getMinute	  ()/(double) entity.getGamePlay());
			bo.setPointPerGame		((double) entity.getPoint      ()/(double) entity.getGamePlay());
			bo.setReboundPerGame	((double) entity.getRebound    ()/(double) entity.getGamePlay());
			bo.setAssistPerGame		((double) entity.getAssist     ()/(double) entity.getGamePlay());
			bo.setStealPerGame  	((double) entity.getSteal      ()/(double) entity.getGamePlay());
			bo.setBlockPerGame  	((double) entity.getBlock      ()/(double) entity.getGamePlay());
			bo.setTurnoverPerGame	((double) entity.getTurnover   ()/(double) entity.getGamePlay());
			bo.setPfPerGame			((double) entity.getPf         ()/(double) entity.getGamePlay());
		}
		if ( entity.getFgAttempt() != 0 ) {
			bo.setFgPercent  (((double) entity.getFgMade() / (double) entity.getFgAttempt())*(double) 100);
		}
		if ( entity.getTpAttempt() != 0 ) {
			bo.setTpPercent(((double) entity.getTpMade() / (double) entity.getTpAttempt())*(double) 100);
		}
		if ( entity.getFtAttempt() != 0 ) {
			bo.setFtPercent(((double) entity.getFtMade() / (double) entity.getFtAttempt())*(double) 100);
		}
	    return bo;
    }
	public Map<String, String> retrieveTeamAliass() {
		Map<String, String> map = new LinkedHashMap<String, String>();
		List<PgNbaTeam> teams = seasonStatDao.retrieveTeamAliass();
		for ( PgNbaTeam team : teams ) {
			map.put(team.getTeamAlias(), team.getTeamAlias()+"-"+team.getLocation()+" "+team.getTeamName());
		}
		return map;
	}
}
