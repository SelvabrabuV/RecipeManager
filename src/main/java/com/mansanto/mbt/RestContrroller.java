package com.mansanto.mbt;

import java.util.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestContrroller {
	
	ReceipeManager rm = new ReceipeManager();
	
	@RequestMapping(value="/getdetails", method =  RequestMethod.GET)
	public List getReceipedetails(@RequestParam("Id") String id)
	{
		System.out.println(id);
		return rm.getRecipe(Integer.parseInt(id));
	}
	@RequestMapping(value="/include",method =  {RequestMethod.GET, RequestMethod.POST})
	public List uploadAllData(@RequestParam("name") String name,
			@RequestParam("recipe1") String recipe1,@RequestParam("receipe2") String receipe2
			,@RequestParam("receipe3") String receipe3,@RequestParam("receipe4") String receipe4)
	{
		int a = rm.setreceipe(name, recipe1, receipe2, receipe3, receipe4);
		return rm.getRecipe(a);
	}
	@RequestMapping(value="/getall",method = RequestMethod.GET)
	public List getAllData()
	{
		
		return rm.getRecipeWithName();
	}
	
}
