package com.bishal.repo;

import java.util.List;


import org.springframework.data.repository.CrudRepository;

import com.bishal.model.Purchase;

public interface PurchaseRepo extends CrudRepository<Purchase, String> {
    public List<Purchase> findBySellerUsername (String username);
    public List<Purchase> findByBuyerUsername (String username);
    public List<Purchase> findByPurchaseDate (String username);
	public Purchase findOne(String idPurchase);
}
