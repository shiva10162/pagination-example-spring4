package com.github.paginationspring.example.spring4.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PG_NBA_SEASON")
public class PgNbaSeason {
	private int nbaSeasonId;
	private PgNbaPlayer pgNbaPlayer;
	private PgNbaTeam pgNbaTeam;
	private String season;
	private int gamePlay;
	private int minute;
	private int point;
	private int offRebound;
	private int defRebound;
	private int rebound;
	private int assist;
	private int steal;
	private int block;
	private int turnover;
	private int pf;
	private int fgAttempt;
	private int fgMade;
	private int ftAttempt;
	private int ftMade;
	private int tpAttempt;
	private int tpMade;

    @Id
    @Column(name = "NBA_SEASON_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public int getNbaSeasonId() {
		return nbaSeasonId;
	}
	public void setNbaSeasonId(int nbaSeasonId) {
		this.nbaSeasonId = nbaSeasonId;
	}
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NBA_PLAYER_ID", nullable = false)
	public PgNbaPlayer getPgNbaPlayer() {
		return pgNbaPlayer;
	}
	public void setPgNbaPlayer(PgNbaPlayer pgNbaPlayer) {
		this.pgNbaPlayer = pgNbaPlayer;
	}
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "NBA_TEAM_ID", nullable = false)
	public PgNbaTeam getPgNbaTeam() {
		return pgNbaTeam;
	}
	public void setPgNbaTeam(PgNbaTeam pgNbaTeam) {
		this.pgNbaTeam = pgNbaTeam;
	}
    @Column(name = "SEASON", length = 4)
	public String getSeason() {
		return season;
	}
	public void setSeason(String season) {
		this.season = season;
	}
    @Column(name = "GAME_PLAY", nullable = false, precision = 9, scale = 0)
	public int getGamePlay() {
		return gamePlay;
	}
	public void setGamePlay(int gamePlay) {
		this.gamePlay = gamePlay;
	}
    @Column(name = "MINUTE", nullable = false, precision = 9, scale = 0)
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
    @Column(name = "POINT", nullable = false, precision = 9, scale = 0)
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
    @Column(name = "OFF_REBOUND", nullable = false, precision = 9, scale = 0)
    public int getOffRebound() {
		return offRebound;
	}
	public void setOffRebound(int offRebound) {
		this.offRebound = offRebound;
	}
    @Column(name = "DEF_REBOUND", nullable = false, precision = 9, scale = 0)
	public int getDefRebound() {
		return defRebound;
	}
	public void setDefRebound(int defRebound) {
		this.defRebound = defRebound;
	}
	@Column(name = "REBOUND", nullable = false, precision = 9, scale = 0)
	public int getRebound() {
		return rebound;
	}
	public void setRebound(int rebound) {
		this.rebound = rebound;
	}
	@Column(name = "ASSIST", nullable = false, precision = 9, scale = 0)
	public int getAssist() {
		return assist;
	}
	public void setAssist(int assist) {
		this.assist = assist;
	}
	@Column(name = "STEAL", nullable = false, precision = 9, scale = 0)
	public int getSteal() {
		return steal;
	}
	public void setSteal(int steal) {
		this.steal = steal;
	}
	@Column(name = "BLOCK", nullable = false, precision = 9, scale = 0)
	public int getBlock() {
		return block;
	}
	public void setBlock(int block) {
		this.block = block;
	}
	@Column(name = "TURNOVER", nullable = false, precision = 9, scale = 0)
	public int getTurnover() {
		return turnover;
	}
	public void setTurnover(int turnover) {
		this.turnover = turnover;
	}
	@Column(name = "PF", nullable = false, precision = 9, scale = 0)
	public int getPf() {
		return pf;
	}
	public void setPf(int pf) {
		this.pf = pf;
	}
	@Column(name = "FG_ATTEMPT", nullable = false, precision = 9, scale = 0)
	public int getFgAttempt() {
		return fgAttempt;
	}
	public void setFgAttempt(int fgAttempt) {
		this.fgAttempt = fgAttempt;
	}
	@Column(name = "FG_MADE", nullable = false, precision = 9, scale = 0)
	public int getFgMade() {
		return fgMade;
	}
	public void setFgMade(int fgMade) {
		this.fgMade = fgMade;
	}
	@Column(name = "FT_ATTEMPT", nullable = false, precision = 9, scale = 0)
	public int getFtAttempt() {
		return ftAttempt;
	}
	public void setFtAttempt(int ftAttempt) {
		this.ftAttempt = ftAttempt;
	}
	@Column(name = "FT_MADE", nullable = false, precision = 9, scale = 0)
	public int getFtMade() {
		return ftMade;
	}
	public void setFtMade(int ftMade) {
		this.ftMade = ftMade;
	}
	@Column(name = "TP_ATTEMPT", nullable = false, precision = 9, scale = 0)
	public int getTpAttempt() {
		return tpAttempt;
	}
	public void setTpAttempt(int tpAttempt) {
		this.tpAttempt = tpAttempt;
	}
	@Column(name = "TP_MADE", nullable = false, precision = 9, scale = 0)
	public int getTpMade() {
		return tpMade;
	}
	public void setTpMade(int tpMade) {
		this.tpMade = tpMade;
	}
}
