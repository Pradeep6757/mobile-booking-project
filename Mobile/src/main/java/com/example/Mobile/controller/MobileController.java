package com.example.Mobile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mobile.model.MobileModel;
import com.example.Mobile.repository.MobileRepository;
import com.example.Mobile.service.MobileService;

@RestController
public class MobileController {
	@Autowired
	MobileRepository mr; 
	@Autowired
	MobileService ms;
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
    @GetMapping("/sort/{field}")
	public List<MobileModel> sortAll(@PathVariable String field)
	{
		return ms.sortMobiles(field);
	}
    @GetMapping("/dsort/{field}")
    public List<MobileModel> sortMobilesDesc(@PathVariable String field)
    {
    	return ms.sortMobilesDesc(field);
    }
    @GetMapping("/dsort/{field1}/{field2}")
    public List<MobileModel> sortMobilesDesc(@PathVariable String field1,@PathVariable String field2)
    {
    	return ms.sortMobilesDesc2(field1,field2);
    }
    @GetMapping("/page/{offset}/{pagesize}")
    public List<MobileModel> paginationMobile(@PathVariable int offset,@PathVariable int pagesize)
    {
    	return ms.pageMobile(offset,pagesize);
    }
    @GetMapping("/page/{offset}/{pagesize}/{field}")
    public List<MobileModel> pagingsort(@PathVariable int offset,@PathVariable int pagesize,@PathVariable String field)
    {
    	return ms.pageSort(offset,pagesize,field);
    }
    @GetMapping("/fetchNamePrefix")
    public List<MobileModel> fetchNamePrefix(@RequestParam String prefix){
		return ms.fetchNamePrefix(prefix);
	}
   @GetMapping("/fetchNameSuffix")
    public List<MobileModel> fetchNameSuffix(@RequestParam String suffix){
		return ms.fetchNameSuffix(suffix);
	}
   @GetMapping("/fetchName")
    public List<MobileModel> fetchName(@RequestParam String name){
		return ms.fetchName(name);
	}
   @GetMapping("/query")
   public List<MobileModel>fetchqueryMobile(@RequestParam String name,@RequestParam String battery )
   {
   	return ms.queryMobiles(name, battery);
   }
   @GetMapping("/query2")
   public List<MobileModel>fetchqueryMobilebattery(@RequestParam String battery)
   {
   	return ms.queryMobilesBattery(battery);
   }
   @DeleteMapping("/deleteMobilesByName")
   public String deleteMobilesByName(@RequestParam String name)
   {
   int result=ms.deleteMobilesByName(name)	;
   if(result >0)
   	return "Mobile record deleted";
   else
   	return "Problem occured while deleting";
   }
   @PutMapping("/updateMobilesByName")
   public int updateMobilesByName(@RequestParam String name,@RequestParam int id)
   {
   	return ms.updateCarsByModelname(name,id);
   }
   
}
