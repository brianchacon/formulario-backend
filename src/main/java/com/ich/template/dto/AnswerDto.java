package com.ich.template.dto;

import java.util.Date;

public class AnswerDto {
	private int id;
	private Date created;//Registrará la creación de una cuenta de usuario
	private int user;
	private int question;
	private String answer;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getQuestion() {
		return question;
	}
	public void setQuestion(int question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	
}
