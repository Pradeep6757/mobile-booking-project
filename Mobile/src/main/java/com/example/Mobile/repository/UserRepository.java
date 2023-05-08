package com.example.Mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mobile.model.UserModel;
@Repository
public interface UserRepository extends JpaRepository <UserModel,Integer> {

	UserModel findByusername(String username);

}
