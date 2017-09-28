package com.HelloWorld.examples.base.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.HelloWorld.examples.base.entity.Car;
import com.HelloWorld.examples.base.service.CarService;

/**
 * 
 * @author 
 */
@Controller
@RequestMapping("/car")
public class CarController {

	@Autowired
	private  CarService carService;
	
	@RequestMapping(method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("list", carService.getCars());
		return "base/car_list";
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String create(Model model, Car car){
		model.addAttribute("entity",car);
		return "base/car_edit";
	}
	
	@RequestMapping(value="/edit/{id}", method = RequestMethod.GET)
	public String edit(Model model, @PathVariable Integer id){
		model.addAttribute("entity", carService.getCar(id));
		return "base/car_edit";
	}
	
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Model model, Car car){
		carService.save(car);
		return "redirect:/car";
	}
	
	@RequestMapping(value="/view/{id}", method = RequestMethod.GET)
	public String view(Model model, @PathVariable Integer id){
		model.addAttribute("entity", carService.getCar(id));
		return "base/car_view";
	}
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String delete(Model model, @PathVariable Integer id){
		carService.delete(id);
		return "redirect:/car";
	}
	

}
