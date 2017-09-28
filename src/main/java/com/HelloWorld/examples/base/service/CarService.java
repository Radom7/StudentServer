package com.HelloWorld.examples.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HelloWorld.examples.base.entity.Car;
import com.HelloWorld.orm.mybatis.MyBatisDao;

/**
 * 
 * @author 
 */
@Service
public class CarService {

	@Autowired
	private MyBatisDao myBatisDao;
	
	public List<Car> getCars(){
		return myBatisDao.getList("carMapper.selectByEntity");
	}
	
	public Car getCar(Serializable id){
		return myBatisDao.get("carMapper.selectByPrimaryKey",id);
	}
	
	public void save(Car car){
		    //if(car.getId()== null)
		if(car.getId()==null)
			myBatisDao.save("carMapper.insert", car);
		else
			myBatisDao.save("carMapper.update", car);
	}

	
	public void delete(Serializable id){
		myBatisDao.delete("carMapper.delete", id);
	}
}