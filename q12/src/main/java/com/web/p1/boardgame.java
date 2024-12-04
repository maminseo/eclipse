package com.web.p1;

import java.time.LocalDateTime;
import org.hibernate.annotations.CreationTimestamp;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class boardgame {
	
	@Id public Integer num;
	public String mid;
	public String name;
	public Integer ea;
	@CreationTimestamp public LocalDateTime rdate;

}
