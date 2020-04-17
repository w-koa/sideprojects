package com.techelevator.zinogreFanSite;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.zinogreFanSite.daomodel.JDBCProductDao;
import com.techelevator.zinogreFanSite.daomodel.Product;

@Controller
public class StoreController {
	
	@Autowired
	private JDBCProductDao productDao;
	
	@RequestMapping(path = "/store", method = RequestMethod.GET)
	public String displayStore(ModelMap map, HttpSession session) {
		if (session.getAttribute("cart") == null) {
			session.setAttribute("cart", shoppingCart);
		}
		List<Product> productList = productDao.getAllProducts();
		
		map.addAttribute("productList", productList);
		
		return "store";
	}
	
	@RequestMapping(path = "/detail", method = RequestMethod.GET)
	public String displayDetail(@RequestParam int id, ModelMap map) {
		
		Product product = productDao.getProductById(id);
		map.addAttribute("product", product);
		
		return "detail";
	}
	
	@RequestMapping(path = "/cart", method = RequestMethod.POST)
	public String addToCart(@RequestParam int id) {
		
		return "redirect:/viewCart";
	}
	
	@RequestMapping(path = "/viewCart", method = RequestMethod.GET)
	public String displayCart(ModelMap map, HttpSession session) {
		
		return "viewCart";
	}

}
