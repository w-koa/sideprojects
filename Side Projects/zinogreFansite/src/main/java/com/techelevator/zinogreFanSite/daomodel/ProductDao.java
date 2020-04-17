package com.techelevator.zinogreFanSite.daomodel;

import java.util.List;

public interface ProductDao {

	public List<Product> getAllProducts();
	public Product getProductById(int id);
	public void saveNewProduct(Product newProduct);
	public void deleteProductById(int id);
}
