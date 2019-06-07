package com.nettrack.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nettrack.user.entity.User;



@Repository
public interface UserRepository extends CrudRepository<User, Long>	{

	public User findByEmail(String email);
	
	public User findByEmailAndPassword(String email,String password);

	public User findByUserID(long userId);

}
