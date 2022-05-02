package com.bishal.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private int price;
	private String description;
	

	

	private String img_url;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

//	@ManyToOne
//	private Category catgory;

	public int getId() {
		return id;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

//	public Product(int id, String productName, int price, String description) {
//		super();
//		this.id = id;
//		this.productName = productName;
//		this.price = price;
//		this.description = description;
//	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

//	public Category getCatgory() {
//		return catgory;
//	}
//
//	public void setCatgory(Category catgory) {
//		this.catgory = catgory;
//	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}

	public String getImg_url() {
		return img_url;
	}

	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
