package com.demoProject.notificationsreplica.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller  //this is a controller class, if some api request comes , this class also gets checked
@ApiIgnore  //dont show this endpoint in swagger 
public class HomeController {
	@GetMapping(value = "/")  //we can also use @RequestMapping(method = "GET" , value="/")
	public String index() {
		return "redirect:swagger-ui.html";  //redirect to swagger
	} 
}
