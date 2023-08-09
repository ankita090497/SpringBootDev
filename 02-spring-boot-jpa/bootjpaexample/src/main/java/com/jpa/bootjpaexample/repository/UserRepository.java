package com.jpa.bootjpaexample.repository;

import com.jpa.bootjpaexample.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

}
