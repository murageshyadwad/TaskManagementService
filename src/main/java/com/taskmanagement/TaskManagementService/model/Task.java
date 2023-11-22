package com.taskmanagement.TaskManagementService.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Task {
	
	@Id
	@GeneratedValue
	private long taskid;
	private String task;
	private String assignedtaskto;
	private Date dttaskassigned;
	private String taskdescription;
	public String getTaskdescription() {
		return taskdescription;
	}
	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}
	private String taskstatus;
	public long getTaskid() {
		return taskid;
	}
	public void setTaskid(long taskid) {
		this.taskid = taskid;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public String getAssignedtaskto() {
		return assignedtaskto;
	}
	public void setAssignedtaskto(String assignedtaskto) {
		this.assignedtaskto = assignedtaskto;
	}
	public Date getDttaskassigned() {
		return dttaskassigned;
	}
	public void setDttaskassigned(Date dttaskassigned) {
		this.dttaskassigned = dttaskassigned;
	}
	public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	public Task() {
		super();
		this.taskid = taskid;
		this.task = task;
		this.assignedtaskto = assignedtaskto;
		this.dttaskassigned = dttaskassigned;
		this.taskdescription = taskdescription;
		this.taskstatus = taskstatus;
	}
	
	public Task(long l, String string, String string2, String string3, String string4) {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Task [taskid=" + taskid + ", task=" + task + ", assignedtaskto=" + assignedtaskto + ", dttaskassigned="
				+ dttaskassigned + ", taskdescription=" + taskdescription + ", taskstatus=" + taskstatus + "]";
	}
	

}
