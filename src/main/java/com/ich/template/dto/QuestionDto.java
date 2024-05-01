package com.ich.template.dto;

import java.util.Date;

import com.ich.template.model.Formularios;

public class QuestionDto {

	private int id;
	private Date created;
	private Date updated;
	private String type;
    private Formularios formularios;
	private String question;
	private String defaultValue;
	
	
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
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Formularios getFormularios() {
		return formularios;
	}
	public void setFormularios(Formularios formularios) {
		this.formularios = formularios;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
	
	
	
}
