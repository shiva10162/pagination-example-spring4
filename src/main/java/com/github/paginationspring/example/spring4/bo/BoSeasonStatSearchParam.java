package com.github.paginationspring.example.spring4.bo;

import com.github.paginationspring.bo.BoPaginationParam;

public class BoSeasonStatSearchParam extends BoPaginationParam {
    private String season;
    private String playerName;
    private String teamName;

    public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
	public String getPlayerName() {
		return playerName;
	}
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
}
