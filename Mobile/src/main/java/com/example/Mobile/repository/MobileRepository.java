
package com.example.Mobile.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Mobile.model.MobileModel;

@Repository
public interface MobileRepository extends JpaRepository <MobileModel,Integer> {
	public List<MobileModel> findByNameStartingWith(String prefix);
	public List<MobileModel> findByNameEndingWith(String suffix);
	public List<MobileModel> findByName(String name);
	//positional parameters
		@Query("select s from MobileModel s where s.name=?1 and s.battery=?2")
		 public List<MobileModel>getMobilesByName(String name,String battery);
		//named parameters
		@Query("select s from MobileModel s where s.battery=:battery")
		public List<MobileModel> getMobilesByBattery(String battery);
		//DML
		@Modifying
		@Query("delete from MobileModel s where s.name=?1")
		public int deleteMobilesByName(String name);
		//update query
		@Modifying
		@Query("update  MobileModel s set s.name=?1 where s.id=?2")
		public int updateMobilesByName(String name,int id);
}
