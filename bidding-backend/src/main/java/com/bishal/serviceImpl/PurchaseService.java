package com.bishal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishal.model.Purchase;
import com.bishal.model.User;
import com.bishal.repo.PurchaseRepo;
import com.bishal.repo.UserRepo;

@Service
public class PurchaseService {
	@Autowired
    private PurchaseRepo purchaseRepository;

    @Autowired
    private UserRepo userRepository;

    public List<Purchase> getBuyerPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findByBuyerUsername(username)
                .forEach(purchases::add);
        return purchases;
    }


    public List<Purchase> getSellerPurchases(String username){

        List<Purchase> purchases = new ArrayList<>();
        purchaseRepository.findBySellerUsername(username)
                .forEach(purchases::add);
        return purchases;
    }


    public void paymentPurchase(String username, String idPurchase){
        Purchase tempPurchase = purchaseRepository.findOne(idPurchase);
        if(tempPurchase.getStatus().equals("NOT PAID")) {
            User tempBuyerUser = userRepository.findOne(tempPurchase.getBuyer().getUsername());
            if (tempBuyerUser.getBalance() >= tempPurchase.getPrice()) {
                tempBuyerUser.subtractMoney(tempPurchase.getPrice());
                userRepository.save(tempBuyerUser);
                User tempSellerUser = userRepository.findOne(tempPurchase.getSeller().getUsername());
                tempSellerUser.addMoney(tempPurchase.getPrice());
                userRepository.save(tempSellerUser);
            }
            tempPurchase.setStatus("PAID");
            purchaseRepository.save(tempPurchase);
        }
    }

	

}
