package com.ich.template.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="question")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "created")
	private Date created = new Date();//Registrará la creación de una cuenta de usuario
	
	@Column(name = "updated")
	private Date updated = new Date();//Registrará la creación de una cuenta de usuario
	
	@Column(name = "type")
	private String type;
	
	@ManyToOne
    @JoinColumn(name = "formularios", referencedColumnName = "id")
    private Formularios formularios;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "defaultValue")
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
