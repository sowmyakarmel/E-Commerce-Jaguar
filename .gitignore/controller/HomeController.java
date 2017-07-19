package com.niit.controller;

import java.security.Principal;
import java.util.List;

import javax.enterprise.inject.Model;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.RegisterDao;
import com.niit.model.Cart;
import com.niit.model.Category;
import com.niit.model.CreateUser;
import com.niit.model.Product;

@Controller
public class HomeController {

	@Autowired
	RegisterDao regdao;

	@Autowired
	ProductDao proDao;


	@Autowired
	CategoryDao categoryDao;

	@Autowired
	HttpSession session;

	@RequestMapping("/")
	public String Home(Principal principal,ModelMap m)
	{
		List<Category>list=categoryDao.allCategories();
		//ModelAndView m=new ModelAndView();
		session.setAttribute("catlist", list);
		if (principal != null) {
			CreateUser user = regdao.getEmail(principal.getName());
			if (user.getRole().equals("ROLE_ADMIN")) {
				return ("Adminhomepage");
			} else {
				Cart cart = user.getCart();
				if (cart != null) {
					session.setAttribute("cartcount", cart.getQuantity());
				} else {
					session.setAttribute("cartcount", 0);
				}
				return ("customerprodpage");
			}

		}
		return "index";
	}
	@RequestMapping("/reg")
	public ModelAndView signup() {
		CreateUser createuser = new CreateUser();
		return new ModelAndView("Createuser", "UserDetails", createuser);
	}

	@RequestMapping("/register")
	public ModelAndView Regi(@ModelAttribute("UserDetails") CreateUser cuser, BindingResult result) {
		System.out.println("I am in reg controller");
		if (result.hasErrors()) {
			return new ModelAndView("CreateUser");
		}
		regdao.addData(cuser);
		return new ModelAndView("index");
	}

	// @RequestMapping("/signin")
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error, ModelMap model) {
		System.out.println(error);
		if (error != null) {
			model.addAttribute("error", "Authentication Failed-Invalid credentials!");
			return "loginform";
		}
		model.addAttribute("title", "login");
		return "loginform";
	}

	// customer want to see the individual product
	@RequestMapping("/{id}/viewproduct")
	public String viewProduct(@PathVariable Integer id, ModelMap model) {
		System.out.println("view product");
		model.addAttribute("product", proDao.get(id));
		return "viewproduct";
	}

	
	@RequestMapping("/customer/viewcart")
	public ModelAndView viewCart(Principal principal) {
		ModelAndView m = new ModelAndView("viewcart");
		CreateUser user = regdao.getEmail(principal.getName());
		Cart cart = user.getCart();
		m.addObject("cart", cart);
		return m;
	}
	
	
	@RequestMapping("/abt")
	public ModelAndView about() {
		return new ModelAndView("aboutus");
	}

	@RequestMapping("/hom")
	public ModelAndView ho() {
		return new ModelAndView("home");
	}

	@RequestMapping("/cont")
	public ModelAndView contact() {
		return new ModelAndView("contactus");
	}

	@RequestMapping("/jxf")
	public ModelAndView ja() {
		return new ModelAndView("jaguarxf");
	}

	@RequestMapping("/jxe")
	public ModelAndView jag() {
		return new ModelAndView("jaguarxe");
	}

	@RequestMapping("/jfpace")
	public ModelAndView jagu() {
		return new ModelAndView("jaguarfpace");
	}

	@RequestMapping("/jxjl")
	public ModelAndView jagua() {
		return new ModelAndView("jaguarxjl");
	}

	@RequestMapping("/jftype")
	public ModelAndView jaguar() {
		return new ModelAndView("jaguarftype");
	}

}
