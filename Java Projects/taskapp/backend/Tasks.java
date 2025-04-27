package com.example.demo.Entity;


import jakarta.persistence.*;

@Entity
@Table(name = "tasks")
public class Tasks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "task_id")
	private Integer id;
	
	@Column(name = "taskname")
	private String taskName;
	
	@Column(name = "task_description")
	private String taskDescription;
	
	@Column(name = "start_date")
	private String startDate;
	
	@Column(name = "due_date")
	private String dueDate;
	
	 @ManyToOne
	 @JoinColumn(name = "user_id")
	 private Users user;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Tasks(String taskName, String taskDescription, String startDate, String dueDate, Users user) {
		super();
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.user = user;
	}

	public Tasks(Integer id, String taskName, String taskDescription, String startDate, String dueDate,Users user) {
		super();
		this.id = id;
		this.taskName = taskName;
		this.taskDescription = taskDescription;
		this.startDate = startDate;
		this.dueDate = dueDate;
		this.user = user;
	}

	public Tasks() {
		super();
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
