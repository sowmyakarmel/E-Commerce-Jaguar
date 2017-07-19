package com.niit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CategoryDao;
import com.niit.model.Category;

@Controller
public class AdminCategoryController 
{
	@Autowired
	CategoryDao catDao;
	@RequestMapping("/admincat")
	public ModelAndView CategoryId()
	{
		ModelAndView mv=new ModelAndView("AdminCategory");
		return mv;
	}
	//listing the category data from database to datatable
	
	@RequestMapping("/categories/all")
	public @ResponseBody List<Category> categoriesall()
	{
		System.out.println("display category list");
		return catDao.allCategories();
	}
	
	
	@RequestMapping("/addcategory")
	public String addCategory(@ModelAttribute("category") Category category,BindingResult result,ModelMap model){
	System.out.println("entered into add category");
		catDao.newCategory(category);
		return "AdminCategory";
	}
	
	
	@RequestMapping("/{id}/updatecategory")
	public String updateCategory(@ModelAttribute("category") Category category,BindingResult result,ModelMap model){
	System.out.println("Entered into update category");
	catDao.update(category);
	model.addAttribute("categories",true);
	return "AdminCategory";
	}
	
	
	@RequestMapping("/{id}/deletecategory")
	public String deleteCategory(@PathVariable Integer id, ModelMap model) {
		catDao.deleteCategory(id);
		model.addAttribute("categories", true);
		return "AdminCategory";
	}
	
	@RequestMapping("/{id}/editcategory")
	public String editcategory(@PathVariable Integer id,ModelMap model)
	{
		System.out.println("I am in edit category control form");
		model.addAttribute("editcategory",true);
		model.addAttribute("category",catDao.getCategory(id));
		return "AdminCatDml";
	}
	
	@RequestMapping("/newcat")
	public ModelAndView NewAddCat()
	{
		ModelAndView m=new ModelAndView("AdminCatDml");
		m.addObject("newcategory",true);
		m.addObject("category", new Category());
		return m;
				
	}
			
	
	
}
