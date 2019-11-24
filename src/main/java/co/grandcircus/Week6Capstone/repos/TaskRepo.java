package co.grandcircus.Week6Capstone.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Week6Capstone.models.Task;

public interface TaskRepo extends JpaRepository<Task, Integer>{
	Task findByTaskid(Integer taskid);
	List<Task> findByUserAssignedUseridOrderByDueDateAsc(Integer userid);
	
	//Sorting queries
	
	List<Task> findByUserAssignedUseridOrderByDueDateAscCompleteAsc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByDueDateAscCompleteDesc(Integer userid);

	List<Task> findByUserAssignedUseridOrderByDueDateDesc(Integer userid);

	List<Task> findByUserAssignedUseridOrderByDueDateDescCompleteAsc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByDueDateDescCompleteDesc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByCompleteAsc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByCompleteAscDueDateAsc(Integer userid);

	List<Task> findByUserAssignedUseridOrderByCompleteAscDueDateDesc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByCompleteDesc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByCompleteDescDueDateAsc(Integer userid);
	
	List<Task> findByUserAssignedUseridOrderByCompleteDescDueDateDesc(Integer userid);
	
	//Search query
	
	List<Task> findByUserAssignedUseridAndDescriptionContaining(Integer userid, String description);
}
