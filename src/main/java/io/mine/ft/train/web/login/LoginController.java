package io.mine.ft.train.web.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import io.mine.ft.train.service.ShopSupport;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class LoginController {
	
	@Autowired
	private ShopSupport shopSupport;

	@RequestMapping("/menuList")
	public ModelAndView menuList(HttpServletRequest request, HttpServletResponse response) {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping("/update")
	public ModelAndView update(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			shopSupport.update_1();
		} catch (Exception e) {
			log.info("update商品详情：--{}", e);
		}
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
}
