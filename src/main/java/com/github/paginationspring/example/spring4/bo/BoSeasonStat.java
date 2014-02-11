package com.github.paginationspring.example.spring4.bo;

import com.github.paginationspring.bo.BoPaginationResultRow;

public class BoSeasonStat extends BoPaginationResultRow<Integer> {

    private int nbaSeasonId;
    private String playerName;
	private String height;
	private String weight;
    private String teamAlias;
    private String teamName;
	private String position;
	private String season;
	private int gamePlay;
	private double minutePerGame;
	private double pointPerGame;
	private double reboundPerGame;
	private double assistPerGame;
	private double stealPerGame;
	private double blockPerGame;
	private double turnoverPerGame;
	private double pfPerGame;
	private double fgPercent;
	private double ftPercent;
	private double tpPercent;
    
	public int getNbaSeasonId() {
		return nbaSeasonId;
	}


	public void setNbaSeasonId(int nbaSeasonId) {
		this.nbaSeasonId = nbaSeasonId;
	}


	public String getPlayerName() {
		return playerName;
	}


	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}


	public String getHeight() {
		return height;
	}


	public void setHeight(String height) {
		this.height = height;
	}


	public String getWeight() {
		return weight;
	}


	public void setWeight(String weight) {
		this.weight = weight;
	}


	public String getTeamAlias() {
		return teamAlias;
	}


	public void setTeamAlias(String teamAlias) {
		this.teamAlias = teamAlias;
	}


	public String getTeamName() {
		return teamName;
	}


	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getSeason() {
		return season;
	}


	public void setSeason(String season) {
		this.season = season;
	}


	public int getGamePlay() {
		return gamePlay;
	}


	public void setGamePlay(int gamePlay) {
		this.gamePlay = gamePlay;
	}


	public double getMinutePerGame() {
		return minutePerGame;
	}


	public void setMinutePerGame(double minutePerGame) {
		this.minutePerGame = minutePerGame;
	}


	public double getPointPerGame() {
		return pointPerGame;
	}


	public void setPointPerGame(double pointPerGame) {
		this.pointPerGame = pointPerGame;
	}


	public double getReboundPerGame() {
		return reboundPerGame;
	}


	public void setReboundPerGame(double reboundPerGame) {
		this.reboundPerGame = reboundPerGame;
	}


	public double getAssistPerGame() {
		return assistPerGame;
	}


	public void setAssistPerGame(double assistPerGame) {
		this.assistPerGame = assistPerGame;
	}


	public double getStealPerGame() {
		return stealPerGame;
	}


	public void setStealPerGame(double stealPerGame) {
		this.stealPerGame = stealPerGame;
	}


	public double getBlockPerGame() {
		return blockPerGame;
	}


	public void setBlockPerGame(double blockPerGame) {
		this.blockPerGame = blockPerGame;
	}


	public double getTurnoverPerGame() {
		return turnoverPerGame;
	}


	public void setTurnoverPerGame(double turnoverPerGame) {
		this.turnoverPerGame = turnoverPerGame;
	}


	public double getPfPerGame() {
		return pfPerGame;
	}


	public void setPfPerGame(double pfPerGame) {
		this.pfPerGame = pfPerGame;
	}


	public double getFgPercent() {
		return fgPercent;
	}


	public void setFgPercent(double fgPercent) {
		this.fgPercent = fgPercent;
	}


	public double getFtPercent() {
		return ftPercent;
	}


	public void setFtPercent(double ftPercent) {
		this.ftPercent = ftPercent;
	}


	public double getTpPercent() {
		return tpPercent;
	}


	public void setTpPercent(double tpPercent) {
		this.tpPercent = tpPercent;
	}


	@Override
    public Integer getPk() {
	    return nbaSeasonId;
    }

}
