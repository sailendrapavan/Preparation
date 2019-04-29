package com.springmvc;

import javax.ws.rs.Produces;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class loginController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello() {
		return "hellowolrld";
	}
	
	
	@RequestMapping("/view")
	public String renderView() {
		
		return "login";
	}
	
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String postLogin(@RequestParam String name, ModelMap model) {
		
		model.put("name", name);
		return "welcome";
	}

}
