package com.SpringBoot.CrudDemo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.CrudDemo.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

    User findByUserName(String userName);
}
