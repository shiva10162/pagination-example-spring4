package com.github.paginationspring.example.spring4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PG_NBA_TEAM")
public class PgNbaTeam {
	private int nbaTeamId;
	private String teamAlias;
	private String location;
	private String teamName;
	private String league;

    @Id
    @Column(name = "NBA_TEAM_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public int getNbaTeamId() {
		return nbaTeamId;
	}
	public void setNbaTeamId(int nbaTeamId) {
		this.nbaTeamId = nbaTeamId;
	}
    @Column(name = "TEAM_ALIAS", length = 50)
	public String getTeamAlias() {
		return teamAlias;
	}
	public void setTeamAlias(String teamAlias) {
		this.teamAlias = teamAlias;
	}
    @Column(name = "LOCATION", length = 100)
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
    @Column(name = "TEAM_NAME", length = 100)
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
    @Column(name = "LEAGUE", length = 1)
	public String getLeague() {
		return league;
	}
	public void setLeague(String league) {
		this.league = league;
	}
}
