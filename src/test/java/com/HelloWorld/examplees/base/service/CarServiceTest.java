package com.HelloWorld.examplees.base.service;

import java.util.List;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.HelloWorld.examples.base.entity.Car;
import com.HelloWorld.examples.base.service.CarService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:service-context.xml")
public class CarServiceTest {

	@Autowired
	private CarService carService;
	
	@Test
	public void savetCarsTest(){
		Car car = new Car();
		car.setName("奔驰");
		carService.save(car);
		carService.getCars();
		List<Car> list = carService.getCars();
		Assert.assertEquals(1, list.size());
	}
		
	@Test
	public void getCarTest(){
		Car car = carService.getCar(0);
		Assert.assertEquals("奔驰", car.getName());
	}

	@Test
	public void deleteCarTest(){
		carService.delete(0);
		List<Car> list = carService.getCars();
		Assert.assertEquals(list.size(), 0);
	}

	
	
}


