package com.niit.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.security.Principal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.niit.dao.CartDao;
import com.niit.dao.CartItemDao;
import com.niit.dao.CategoryDao;
import com.niit.dao.ProductDao;
import com.niit.dao.RegisterDao;
import com.niit.model.Cart;
import com.niit.model.CartItem;
import com.niit.model.CreateUser;
import com.niit.model.Product;


@Controller
public class ProductController 
{
@Autowired
ProductDao proDao;

@Autowired(required=true)
HttpServletRequest request;

@Autowired
CategoryDao catDao;

@Autowired
RegisterDao regDao;

@Autowired
CartItemDao cartitemDao;

@Autowired
CartDao cartDao;

@RequestMapping("/mngproduct")
public ModelAndView AdminProd()
{
	ModelAndView mv = new ModelAndView("AdminProduct");
	return mv;
	/*System.out.println("i am in product controller");
	return new ModelAndView("AdminProduct");*/
}

//ajax calling the url for product 
@RequestMapping("/adminproducts/all")
public @ResponseBody List<Product> productsall() {

return proDao.allProducts();

}

//adding new product
@RequestMapping(value="/addproduct",method=RequestMethod.POST)
public String addProduct(Product product,BindingResult result,ModelMap model,@RequestParam("category")String cid)  
{
//System.out.println("im in category"+name);
System.out.println("im in admin product controller="+product);
System.out.println(product.getProductName());
System.out.println(product.getCategory());
product.setCategory(catDao.getCategory(Integer.parseInt(cid)));
@SuppressWarnings("deprecation")
File file=new File(request.getRealPath("//resources//images"));
System.out.println(file.exists());
if(!file.exists()){
file.mkdirs();
}
@SuppressWarnings("deprecation")
File storagepath=new File(request.getRealPath("//resources//images")+File.separator+product.getProductName()+".jpg");
try{
byte[] imagebytes=product.getImage().getBytes();
System.out.println(imagebytes);
BufferedOutputStream bufferedOutputStream=new BufferedOutputStream(new FileOutputStream(storagepath));
bufferedOutputStream.write(imagebytes); 
bufferedOutputStream.close();
}catch (Exception e) {
//TODO: handle exception
System.out.println(e);
}
System.out.println(storagepath);
proDao.addProduct(product);
model.addAttribute("admin", true);
model.addAttribute("adminproducts", true);
return "AdminProduct";
}





@RequestMapping("/{id}/editproduct")
public String eidtproduct(@PathVariable Integer id,ModelMap model) {
//model.addAttribute("admin", true);
model.addAttribute("editproduct", true);
model.addAttribute("product", proDao.get(id));
return "displayproduct";
}


//update product

@RequestMapping("/{id}/updateproduct")
public String updateProduct(@Valid @ModelAttribute("product")Product product,BindingResult result,ModelMap model) {
System.out.println(product.getProductName());
try{
proDao.update(product);
}catch(Exception e)
{
System.out.println("exception in controller:::::::::::::::"+e);
}
//model.addAttribute("admin", true);
model.addAttribute("adminproduct", true);
return "AdminProduct";
}


//to delete product


@RequestMapping("/{id}/deleteproduct")
public String deleteProduct(@PathVariable Integer id,ModelMap model) {
proDao.delete(id);
//model.addAttribute("admin", true);
model.addAttribute("adminproduct", true);
return "AdminProduct";
}




@RequestMapping("/newproduct")
public String newProduct(ModelMap model) {
System.out.println("Entered new category");
model.addAttribute("newproduct", true);
model.addAttribute("product", new Product());
model.addAttribute("categorieslist", catDao.getCatProduct());
return "displayproduct";
}


/*@RequestMapping("/catpro/{id}")
public ModelAndView catprodpage(@PathVariable("id") String id)
{
  System.out.println("Category Id in catpros"+id);
	ModelAndView m = new ModelAndView("catpro");
	
	m.addObject("catid",id);
   int catid=	Integer.parseInt(id);
	m.addObject("catpros",proDao.getCatProducts(catid));
	return m;
}*/


@RequestMapping("/categoryProducts/{id}")
public ModelAndView getCategoryProducts(@PathVariable("id") Integer id)
{
	System.out.println("id");
	ModelAndView m=new ModelAndView("catpro");
	m.addObject("catid",id );
	System.out.println(proDao.getCatProducts(id));
	for(Product p:proDao.getCatProducts(id))
	{
	   System.out.println(p.getProductName());
	}
	m.addObject("catpros",proDao.getCatProducts(id));
	return m;
}


@RequestMapping("/customer/{id}/AddtoCart")
public String addToCart(@PathVariable("id")Integer id,Principal principal)
{
	Product p=proDao.get(id);
	CreateUser user=regDao.getEmail(principal.getName());
	Cart cart=user.getCart();
	if(cart==null)
	{
		cart=new Cart();
		cart.setUser(user);
		cart.setGrandTotal(p.getProductPrice());
		cart.setQuantity(1);
	
		CartItem cItem=new CartItem();
		cItem.setCart(cart);
		cItem.setGrandTotal(p.getProductPrice());
		cItem.setQuantity(1);
		cItem.setProduct(p);
		
		cartDao.addCart(cart);
		cartitemDao.addCartItem(cItem);
		user.setCart(cart);
		regDao.createuserUpdate(user);
		
	}else
	{
		CartItem cartItem=cartitemDao.getExistingCartItemCount(p.getProductId(), cart.getId());
		if(cartItem==null)
		{
			cartItem=new CartItem();
			cartItem.setCart(cart);
			cartItem.setProduct(p);
			cartItem.setQuantity(1);
			cartItem.setGrandTotal(p.getProductPrice());
			
			
			cartitemDao.addCartItem(cartItem);
		}else
		{
			cartItem.setQuantity(cartItem.getQuantity()+1);
			cartItem.setGrandTotal(cartItem.getGrandTotal()+p.getProductPrice());
		    cartitemDao.updateCartItem(cartItem);	
		}
		cart.setGrandTotal(cart.getGrandTotal()+p.getProductPrice());
		cart.setQuantity(cart.getQuantity()+1);
		cartDao.updateCart(cart);
	}
	
	return "redirect:/categoryProducts/"+p.getCategory().getCategoryId();
}
}