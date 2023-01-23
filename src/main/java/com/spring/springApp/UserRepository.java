package com.spring.springApp;


import org.springframework.data.repository.CrudRepository;

import com.spring.springApp.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
