package com.example.Mobile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.example.Mobile.model.MobileModel;
import com.example.Mobile.repository.MobileRepository;

import jakarta.transaction.Transactional;
 
@Service
public class MobileService {
      @Autowired
      MobileRepository mr;
      public List<MobileModel> getAllDetails(){
    	  return mr.findAll();
      }
	public List<MobileModel> sortMobiles(String field) {
		return mr.findAll(Sort.by(field));
	}

  	public List<MobileModel> sortMobilesDesc(String field) {
  		// TODO Auto-generated method stub
  		return mr.findAll(Sort.by(Direction.DESC,field));
  	}

  	public List<MobileModel> sortMobilesDesc2(String field1, String field2) {
  		return mr.findAll(Sort.by(Direction.DESC,field1).and (Sort.by(Direction.DESC,field2)));
  	}
  	
  	public List<MobileModel> pageMobile(int offset, int pagesize) {
  		Page<MobileModel> paging=mr.findAll(PageRequest.of(offset,pagesize));
  		return paging.getContent();
  	}
  	public List<MobileModel> pageSort(int offset, int pagesize, String field) {
  		Pageable paging=PageRequest.of(offset,pagesize).withSort(Sort.by(field));
  		Page<MobileModel>Mobile=mr.findAll(paging);
  		return Mobile.getContent();
  	}
  	public List<MobileModel> fetchNamePrefix(String prefix){
		return mr.findByNameStartingWith(prefix);
	}
	public List<MobileModel> fetchNameSuffix(String suffix){
		return mr.findByNameEndingWith(suffix);
	}
	public List<MobileModel> fetchName(String name){
		return mr.findByName(name);
	}
	public List<MobileModel> queryMobiles(String name,String battery)
	{
		return mr.getMobilesByName(name,battery);
	}
    public List<MobileModel> queryMobilesBattery(String battery)
	{
		return mr.getMobilesByBattery(battery);
	}
    @Transactional
    public int deleteMobilesByName(String name)
    {
    	return mr.deleteMobilesByName(name);
    }
    @Transactional
    public int updateCarsByModelname(String name,int id)
    {
    	return mr.updateMobilesByName(name,id);
    }
  	}
