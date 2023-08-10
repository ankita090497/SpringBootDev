package com.jpa.bootjpaexample.repository;

import com.jpa.bootjpaexample.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<UserEntity, Integer> {

    public List<UserEntity> findByName(String name);

    @Query("select u from UserEntity u")
    public List<UserEntity> getAllUser();

    @Query("select u from UserEntity u where u.name = :n")
    public List<UserEntity> getUserByName(@Param("n") String name);
}
