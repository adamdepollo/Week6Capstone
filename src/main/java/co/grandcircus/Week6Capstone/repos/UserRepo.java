package co.grandcircus.Week6Capstone.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import co.grandcircus.Week6Capstone.models.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	User findByUserid(Integer userid);
	User findByEmailAndPassword(String email, String password);
	User findByEmail(String email);
	User findByPassword(String password);
}
