package com.bishal.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

@Entity
public class User {
	@Id
	@GeneratedValue
	private Long Id;
	private String username;
	private String password;
	private String name;
	private double balance;
	private double penalty = 0;// 20% from unpaid lot

	public User(Long id, String username, String password, String name, double balance, double penalty) {
		super();
		Id = id;
		this.username = username;
		this.password = password;
		this.name = name;
		this.balance = balance;
		this.penalty = penalty;
	}

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getPenalty() {
		return penalty;
	}

	public void setPenalty(double penalty) {
		this.penalty = penalty;
	}

	public User(String username, String password, String name, String surname, String email, double balance) {
		this.username = username;
		this.password = password;
		this.name = name;
		this.balance = balance;
	}

	public void addPenalty(double penalty) {
		this.penalty += penalty;
	}

	public void addMoney(double amount) {
		this.balance += amount;
	}

	public void subtractMoney(double amount) {
		this.balance -= amount;
	}

}
