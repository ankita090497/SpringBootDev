package com.jpa.bootjpaexample.repository;

import com.jpa.bootjpaexample.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    public List<UserEntity> findByName(String name);
}
