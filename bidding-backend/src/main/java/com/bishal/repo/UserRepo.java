package com.bishal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.bishal.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    public User findByUsername(String username);

}
