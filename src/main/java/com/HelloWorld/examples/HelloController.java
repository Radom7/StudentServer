package com.HelloWorld.examples;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 欢迎页面
 * @author 
 */
@Controller
public class HelloController {

	@RequestMapping("/hello")
	public String hello(){
		return "hello";
	}
}
