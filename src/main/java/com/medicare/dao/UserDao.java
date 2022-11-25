package com.medicare.dao;

import com.medicare.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends CrudRepository<User, String> {
    public User findByUserEmail(String userEmail);
}
