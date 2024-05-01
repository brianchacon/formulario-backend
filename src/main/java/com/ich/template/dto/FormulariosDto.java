package com.ich.template.dto;

import java.util.List;

public class FormulariosDto {

	private int id;
	private int company;
	private String name;
	private String description;
    private List<QuestionDto> question;

    
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCompany() {
		return company;
	}
	public void setCompany(int company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<QuestionDto> getQuestion() {
		return question;
	}
	public void setQuestion(List<QuestionDto> question) {
		this.question = question;
	}
    
    
    
}
