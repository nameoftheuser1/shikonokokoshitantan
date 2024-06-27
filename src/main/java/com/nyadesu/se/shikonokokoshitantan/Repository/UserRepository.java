package com.nyadesu.se.shikonokokoshitantan.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nyadesu.se.shikonokokoshitantan.model.User;

public interface UserRepository extends JpaRepository <User, Long>{

}
