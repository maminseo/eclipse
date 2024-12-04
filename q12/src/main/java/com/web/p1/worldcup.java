package com.web.p1;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class worldcup {
	@Id public Integer huno;
	public String name;
	public Integer fcount;
}
