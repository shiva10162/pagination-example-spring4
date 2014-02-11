package com.github.paginationspring.example.spring4.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.github.paginationspring.dao.PaginationDaoDbEntityManagerAbstract;
import com.github.paginationspring.example.spring4.bo.BoSeasonStatSearchParam;
import com.github.paginationspring.example.spring4.entity.PgNbaSeason;
import com.github.paginationspring.example.spring4.entity.PgNbaTeam;

@Repository
public class SeasonStatDao extends PaginationDaoDbEntityManagerAbstract<PgNbaSeason, BoSeasonStatSearchParam> {
    private static Logger log = Logger.getLogger(SeasonStatDao.class);

    private static final String EJBQL = "select distinct a, b, c " +
    		"from PgNbaSeason a " +
    		"join a.pgNbaPlayer b " +
    		"join a.pgNbaTeam c " +
    		"where a.gamePlay > 0 ";
    
    private static final String[] RESTRICTIONS = {
    	"a.season = :season",
        "lower(concat(concat(b.firstName,' '),b.lastName)) like :playerNameCustomized",
        "c.teamAlias=:teamName"
    };
    
    private EntityManager entityManager;

    public SeasonStatDao() {
        this.ejbql = EJBQL;
        this.restrictions = Arrays.asList(RESTRICTIONS);
    }
    
    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
        this.entityManager = entityManager;
    }

	@Override
    public void customizeRestrictions(Map<String, Object> queryParameters,
            BoSeasonStatSearchParam pparam) throws Exception {
        if ( StringUtils.isEmpty(pparam.getPlayerName()) ) {
            queryParameters.put("playerNameCustomized", null);
        } else {
            queryParameters.put("playerNameCustomized", "%"+StringUtils.trim(pparam.getPlayerName().toLowerCase())+"%");
        }
    }
	
    @SuppressWarnings("unchecked")
	public List<PgNbaTeam> retrieveTeamAliass() {
        StringBuilder query = new StringBuilder("select distinct a from PgNbaTeam a " +
        		"where exists(select b from PgNbaSeason b where b.pgNbaTeam=a) " +
        		"order by a.teamAlias, a.location, a.teamName"); 
        try {
            List<PgNbaTeam> list = entityManager
                    .createQuery(query.toString())
                    .getResultList();
            return list;
        } catch (EntityNotFoundException ex) {
            log.error("Cannot find entity", ex);
        } catch (NoResultException ex) {
            log.error("No result can be find", ex);
        }
        return new ArrayList<PgNbaTeam>();

	}
}
