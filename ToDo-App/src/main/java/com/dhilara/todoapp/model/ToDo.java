package com.dhilara.todoapp.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.NonNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="todo")
public class ToDo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NonNull
	private Long id;
	
	@Column
	@NonNull
	private String title;
	
	@Column	
	@NonNull
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date addedOn;
	
	@Column
	@NonNull
	@DateTimeFormat(pattern= "yyyy-mm-dd")
	private Date finishBy;
	
	@Column
	private String status;

	public ToDo() {
		
	}
	
	public ToDo(Long id, String title, Date addedOn, Date finishBy, String status) {
		super();
		this.id = id;
		this.title = title;
		this.addedOn = addedOn;
		this.finishBy = finishBy;
		this.status = status;
	}
		
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	public Date getFinishBy() {
		return finishBy;
	}

	public void setFinishBy(Date finishBy) {
		this.finishBy = finishBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
