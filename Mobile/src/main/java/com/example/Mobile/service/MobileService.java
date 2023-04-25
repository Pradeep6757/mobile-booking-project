package com.example.Mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mobile.model.MobileModel;
import com.example.Mobile.repository.MobileRepository;
 
@Service
public class MobileService {
      @Autowired
      MobileRepository mr;
      public List<MobileModel> getAllDetails(){
    	  return mr.findAll();
      }
}
