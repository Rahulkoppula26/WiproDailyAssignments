package com.wipro.InheritanceMapping.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("Boy")
public class Boy extends User {

	@Column(name = "cricket_team")
	private String cricketTeam;

	public String getCricketTeam() {
		return cricketTeam;
	}

	public void setCricketTeam(String cricketTeam) {
		this.cricketTeam = cricketTeam;
	}
	
}