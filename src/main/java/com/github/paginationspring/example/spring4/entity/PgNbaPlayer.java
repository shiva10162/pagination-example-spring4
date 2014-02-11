package com.github.paginationspring.example.spring4.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PG_NBA_PLAYER")
public class PgNbaPlayer {
	private int nbaPlayerId;
	private String playerAlias;
	private String firstName;
	private String lastName;
	private String position;
	private String firstSeason;
	private String lastSeason;
	private BigDecimal heightFeet;
	private BigDecimal heightInches;
	private BigDecimal weight;
	private String college;

    @Id
    @Column(name = "NBA_PLAYER_ID", unique = true, nullable = false, precision = 9, scale = 0)
	public int getNbaPlayerId() {
		return nbaPlayerId;
	}
	public void setNbaPlayerId(int nbaPlayerId) {
		this.nbaPlayerId = nbaPlayerId;
	}
    @Column(name = "PLAYER_ALIAS", length = 50)
	public String getPlayerAlias() {
		return playerAlias;
	}
	public void setPlayerAlias(String playerAlias) {
		this.playerAlias = playerAlias;
	}
    @Column(name = "FIRST_NAME", length = 50)
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
    @Column(name = "LAST_NAME", length = 50)
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
    @Column(name = "POSITION", length = 1)
	public String getPosition() {
		return position;
	}
	public void setPosition(String position) {
		this.position = position;
	}
    @Column(name = "FIRST_SEASON", length = 4)
	public String getFirstSeason() {
		return firstSeason;
	}
	public void setFirstSeason(String firstSeason) {
		this.firstSeason = firstSeason;
	}
    @Column(name = "LAST_SEASON", length = 4)
	public String getLastSeason() {
		return lastSeason;
	}
	public void setLastSeason(String lastSeason) {
		this.lastSeason = lastSeason;
	}
    @Column(name = "HEIGHT_FEET", precision = 9, scale = 2)
	public BigDecimal getHeightFeet() {
		return heightFeet;
	}
	public void setHeightFeet(BigDecimal heightFeet) {
		this.heightFeet = heightFeet;
	}
    @Column(name = "HEIGHT_INCHES", precision = 9, scale = 2)
	public BigDecimal getHeightInches() {
		return heightInches;
	}
	public void setHeightInches(BigDecimal heightInches) {
		this.heightInches = heightInches;
	}
    @Column(name = "WEIGHT", precision = 9, scale = 2)
	public BigDecimal getWeight() {
		return weight;
	}
	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}
    @Column(name = "COLLEGE", length = 100)
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
}
