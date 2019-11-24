package co.grandcircus.Week6Capstone.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="tasks")
public class Task {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer taskid;
	
	private String description;
	private String dueDate;
	private Boolean complete;
	
	@ManyToOne
	private User userAssigned;

	public Task() {
		super();
	}

	public Task(String description, String dueDate, Boolean complete, User userAssigned) {
		super();
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
		this.userAssigned = userAssigned;
	}

	public Task(Integer taskid, String description, String dueDate, Boolean complete, User userAssigned) {
		super();
		this.taskid = taskid;
		this.description = description;
		this.dueDate = dueDate;
		this.complete = complete;
		this.userAssigned = userAssigned;
	}

	public Integer getTaskid() {
		return taskid;
	}

	public void setTaskid(Integer taskid) {
		this.taskid = taskid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public Boolean getComplete() {
		return complete;
	}

	public void setComplete(Boolean complete) {
		this.complete = complete;
	}

	public User getUserAssigned() {
		return userAssigned;
	}

	public void setUserAssigned(User userAssigned) {
		this.userAssigned = userAssigned;
	}

}
