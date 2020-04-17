package com.techelevator.zinogreFanSite.daomodel;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCProductDao implements ProductDao {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCProductDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// Gets a list of all products in the zinogre_store table.
	@Override
	public List<Product> getAllProducts() {

		List<Product> allProductsList = new ArrayList<>();

		String sqlGetAllProducts = "SELECT * FROM zinogre_store";

		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllProducts);
		while (results.next()) {
			allProductsList.add(mapRowToProduct(results));
		}
		return allProductsList;
	}

	@Override
	public Product getProductById(int id) {

		Product product = new Product();

		String sqlGetProductById = "SELECT * FROM zinogre_store WHERE item_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetProductById, id);
		if (result.next()) {
			product = mapRowToProduct(result);
		}
		return product;
	}

	// Saves a new product, made for practice.
	@Override
	public void saveNewProduct(Product newProduct) {

		int id = getNextId();
		String saveNewProduct = "INSERT INTO zinogre_store (item_id, name, price, description, pic_location) "
				+ "VALUES (?, ?, ? ,?, ?) ";
		jdbcTemplate.update(saveNewProduct, id, newProduct.getName(), newProduct.getPrice(), 
				newProduct.getDescription(), newProduct.getPicLocation());
	}

	// Deletes a product by item_id, made for practice.
	@Override
	public void deleteProductById(int id) {

		String deleteProductById = "DELETE FROM zinogre_store WHERE item_id = ?";
		jdbcTemplate.update(deleteProductById, id);
	}

	// Helper method to map row to product
	private Product mapRowToProduct(SqlRowSet row) {
		Product product = new Product();

		product.setId(row.getInt("item_id"));
		product.setName(row.getString("name"));
		product.setPrice(row.getDouble("price"));
		product.setDescription(row.getString("description"));
		product.setPicLocation(row.getString("pic_location"));

		return product;
	}
	
	// Helper method to get next product Id, be careful with use, next id is always used up when this method is called.
	private int getNextId() {
		String sqlSelectNextId = "SELECT NEXTVAL('zinogre_store_item_id_seq')";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSelectNextId);
		if (result.next()) {
			return result.getInt(1);
		} else {
			throw new RuntimeException("Something went wrong while getting the next product id");
		}
	}

}
