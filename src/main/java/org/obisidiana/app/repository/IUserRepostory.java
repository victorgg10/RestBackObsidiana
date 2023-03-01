package org.obisidiana.app.repository;

import java.util.List;

import org.obisidiana.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepostory extends CrudRepository<User, Long>{

	List<User> findAllById(long id);
	boolean existsByEmail(String email);
	
}
