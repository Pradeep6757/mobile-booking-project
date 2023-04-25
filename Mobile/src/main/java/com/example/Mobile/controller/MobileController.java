package com.example.Mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mobile.model.MobileModel;
import com.example.Mobile.repository.MobileRepository;

@RestController
public class MobileController {
	@Autowired
	MobileRepository mr;  
	@GetMapping("/crud")
	public List<MobileModel> getAllDetails(){
		return mr.findAll();
	}
	@GetMapping("/crud/{modelnumber}")
	public MobileModel getDetailsById(@PathVariable int modelnumber)
	{
		return mr.findById(modelnumber).orElse(null);
	}
    @PostMapping("/save")
    public String saveInfo(@RequestBody MobileModel modelnumber)
    {
    	mr.save(modelnumber);
    	return "Mobile Details saved";
    }
    @DeleteMapping("/crud/{modelnumber}")
    public String deleteById(@PathVariable int modelnumber)
    {
    	mr.deleteById(modelnumber);
    	return "Mobile details deleted";
    }
    @PutMapping("/putchat")
    public MobileModel updateId(@RequestBody MobileModel uname)
    {
    	return mr.save(uname);
    }
}
