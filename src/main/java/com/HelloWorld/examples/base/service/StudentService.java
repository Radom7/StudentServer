package com.HelloWorld.examples.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.HelloWorld.examples.base.entity.Student;
import com.HelloWorld.orm.mybatis.MyBatisDao;


@Service
public class StudentService {
	@Autowired
	private MyBatisDao myBatisDao;
	
	public List<Student> getStudent(){
		return myBatisDao.getList("StudentMapper.selectByEntity");
	}
	
	public Student getStudent(Serializable id){
		return myBatisDao.get("StudentMapper.selectByPrimaryKey",id);
	}
	
	public void save(Student student){
		   
		if(student.getId()==null)
			myBatisDao.save("StudentMapper.insert", student);
		else
			myBatisDao.save("StudentMapper.update",student);
	}

	
	public void delete(Serializable id){
		myBatisDao.delete("StudentMapper.delete", id);
	}
}
