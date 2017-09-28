package com.HelloWorld.examples.base.entity;

/**
 * 汽车管理
 * @author 
 */
public class Car {

	private Integer id; //主键
	private String name; //名称
	private Integer price;//价格
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
}
