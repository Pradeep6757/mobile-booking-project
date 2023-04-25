package com.example.Mobile.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Mobile.model.MobileModel;

@Repository
public interface MobileRepository extends JpaRepository <MobileModel,Integer> {

}
