package model;

import java.time.LocalDateTime;

public class ResponseType {
	private String name;
	private LocalDateTime time;
	
	
	
	public ResponseType(String name, LocalDateTime time) {
		super();
		this.name = name;
		this.time = time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	
	
}
