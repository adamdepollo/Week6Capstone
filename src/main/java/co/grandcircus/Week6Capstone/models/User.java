package co.grandcircus.Week6Capstone.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	
	private String email;
	private String password;
	
	@OneToMany(mappedBy = "userAssigned", orphanRemoval = true)
	List<Task> taskList = new ArrayList<>();
	

	public User() {
		super();
	}
	
	public User(String email, String password, List<Task> taskList) {
		super();
		this.email = email;
		this.password = password;
		this.taskList = taskList;
	}

	public User(Integer userid, String email, String password, List<Task> taskList) {
		super();
		this.userid = userid;
		this.email = email;
		this.password = password;
		this.taskList = taskList;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	@Override
	public String toString() {
		return "userid=" + userid + "?email=" + email + "?password=" + password + "?taskList=" + taskList;
	}
	
	

}
