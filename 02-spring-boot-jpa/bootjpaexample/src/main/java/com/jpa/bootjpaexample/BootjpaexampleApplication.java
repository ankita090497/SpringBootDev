package com.jpa.bootjpaexample;

import com.jpa.bootjpaexample.entity.UserEntity;
import com.jpa.bootjpaexample.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

@SpringBootApplication
public class BootjpaexampleApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);

        UserRepository userRepository = context.getBean(UserRepository.class);

        // Create User object

        UserEntity userEntity = new UserEntity();
        userEntity.setName("Raj");
        userEntity.setCity("Dholka");
        userEntity.setStatus("Study");

        UserEntity userEntity1 = new UserEntity();
        userEntity1.setName("Kishan");
        userEntity1.setCity("Dholka");
        userEntity1.setStatus("Doctor");

        List<UserEntity> userList = List.of(userEntity, userEntity1);
        Iterable<UserEntity> itrUser = userRepository.saveAll(userList);

        itrUser.forEach(user -> {
            System.out.println(user);
        });

        // Update the User
        Optional<UserEntity> entity = userRepository.findById(52);
        UserEntity fetchedUser = entity.get();
        System.out.println("Fetched user data : " + fetchedUser);
        fetchedUser.setName("Chirag");
        UserEntity updatedUser = userRepository.save(fetchedUser);
        System.out.println("Updated user data : " + updatedUser);

        // Get data for particular user

        Iterable<UserEntity> itr = userRepository.findAll();
        for (UserEntity resultUser : itr) {
            System.out.println(resultUser);
        }
        itr.forEach(user -> System.out.println(user));


        // Delete user element
        userRepository.deleteById(512);
        System.out.println("Deleted");
    }

}
