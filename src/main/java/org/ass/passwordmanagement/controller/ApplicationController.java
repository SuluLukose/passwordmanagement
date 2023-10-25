package org.ass.passwordmanagement.controller;

import org.ass.passwordmanagement.dto.AppResponseDto;
import org.ass.passwordmanagement.dto.ApplicationDto;
import org.ass.passwordmanagement.service.ApplicationServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@Controller
@RestController
public class ApplicationController {
	@Autowired
	private ApplicationServiceImpl serviceImpl;

	public ApplicationController() {
		System.out.println(this.getClass().getSimpleName());
	}
 @RequestMapping(value="/saveUser")
	public ModelAndView saveUser(ApplicationDto applicationDto) {
		System.out.println(applicationDto);
		serviceImpl.processCreateApp(applicationDto);
		return new ModelAndView("index.jsp");
	}
	@RequestMapping(value="/createApp")
	public @ResponseBody AppResponseDto createApp(@RequestBody ApplicationDto applicationDto)
	{
		return serviceImpl.processCreateApp(applicationDto);
	}
	public @ResponseBody AppResponseDto getapplications()
	{
		return serviceImpl.getAll();
		
	}
	
	
	
}
