package com.avviotech.labs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.avviotech.labs.dto.User;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByuserName(String userName);
    User findByid(Long id);
    User findBymobile(String mobile);
    
    @Query("select u from User u " +
            "where u.mobile = ? and u.password = ?")
    User findByDetails(String mobile,String password);
}
