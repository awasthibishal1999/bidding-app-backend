package com.bishal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Lot {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String topic;
	private String description;
	private double price;
	private String endDate;

	public Lot(Long id, String name, String topic, String description, double price, String endDate, User seller,
			User buyer) {
		super();
		this.id = id;
		this.name = name;
		this.topic = topic;
		this.description = description;
		this.price = price;
		this.endDate = endDate;
		this.seller = seller;
		this.buyer = buyer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public User getSeller() {
		return seller;
	}

	public void setSeller(User seller) {
		this.seller = seller;
	}

	public User getBuyer() {
		return buyer;
	}

	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}

	@ManyToOne
	private User seller;

	@ManyToOne
	private User buyer;

	public boolean hasBuyer() {
		if (this.buyer != null)
			return true;
		else
			return false;
	}

}
