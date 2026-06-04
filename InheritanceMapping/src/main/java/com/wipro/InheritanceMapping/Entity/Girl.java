package com.wipro.InheritanceMapping.Entity;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("Girl")
public class Girl extends User {
	private String danceTeam;

	public String getDanceTeam() {
		return danceTeam;
	}

	public void setDanceTeam(String danceTeam) {
		this.danceTeam = danceTeam;
	}

}