package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.Optional;

@Controller
public class PackageController {
	@RequestMapping("/hello") 
	public String index () { 
		return "hello"; 
	}
	
	@RequestMapping("/greeting")
	public String greeting(@RequestParam(value="name", required=false) String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}
	
	@RequestMapping(value= {"/greeting", "/greeting/{name}"})
	public String greetingPath(@PathVariable Optional<String> name, Model model) {
		if(name.isPresent()) {
			model.addAttribute("name", name.get());
		}else {
			model.addAttribute("name", "apap");
		}
		return "greeting";
	}
	
	@RequestMapping("/perkalian")
	public String multiplicate(
			@RequestParam(value = "a",required=false, defaultValue = "0") Integer param1, 
			@RequestParam(value = "b",required=false, defaultValue = "0") Integer param2, 
			Model model
		) {
		model.addAttribute("param1", param1);
		model.addAttribute("param2", param2);
		model.addAttribute("result", (param1 * param2));
		return "perkalian";
	
	}
	
}
