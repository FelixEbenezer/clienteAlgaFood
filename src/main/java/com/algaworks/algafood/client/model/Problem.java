package com.algaworks.algafood.client.model;

import java.time.OffsetDateTime;

public class Problem {

	private Integer status;
	private OffsetDateTime timestamp;
	private String userMessage;
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public OffsetDateTime getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(OffsetDateTime timestamp) {
		this.timestamp = timestamp;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	
	
	
}