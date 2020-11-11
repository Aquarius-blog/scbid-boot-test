package com.scbid.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 系统页面视图
 * 
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2016年11月24日 下午11:05:27
 */
@Controller
public class SysPageController {
	
	@RequestMapping("modules/{module}/{url}.html")
	public String module(@PathVariable("module") String module, @PathVariable("url") String url){
		return "modules/" + module + "/" + url;
	}

	@RequestMapping(value = {"/", "index.html"})
	public String index(){
		return "index";
	}

	@RequestMapping("index1.html")
	public String index1(){
		return "index1";
	}

	@RequestMapping("login.html")
	public String login(){
		return "login";
	}
	
	@RequestMapping("register.html")
	public String register(){
		return "register";
	}

	@RequestMapping("main.html")
	public String main(){
		return "main";
	}
	@RequestMapping("bondorderindex.html")
	public String bondorderindex(){
		return "bondorderindex";
	}

	@RequestMapping("404.html")
	public String notFound(){
		return "404";
	}
	
	@RequestMapping("home.html")
	public String home(){
		return "web/index";
	}
	
	@RequestMapping("about.html")
	public String about(){
		return "web/about";
	}
	
	@RequestMapping("services.html")
	public String services(){
		return "web/services";
	}
	
	@RequestMapping("portfolio.html")
	public String portfolio(){
		return "web/portfolio";
	}
	
	@RequestMapping("pricing.html")
	public String pricing(){
		return "web/pricing";
	}
	
	@RequestMapping("contact.html")
	public String contact(){
		return "web/contact";
	}

}
