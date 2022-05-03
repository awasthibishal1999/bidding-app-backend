package com.bishal.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bishal.model.Lot;
import com.bishal.model.User;
import com.bishal.repo.LotRepo;
import com.bishal.repo.UserRepo;


@Service
public class BidService {
	
	   @Autowired
	    private LotRepo lotRepository;

	    @Autowired
	    private UserRepo userRepository;


	    public List<Lot> getAllBids(String username){
	        List<Lot> lots = new ArrayList<>();
	        lotRepository.findByBuyerUsername(username)
	                .forEach(lots::add);
	        return lots;
	    }

	    public void addBid(Lot lot, String username, double amount) {

	        Lot tempLot = lotRepository.findById(lot.getId());
	        User user = userRepository.findOne(username);
	        if(user.getPenalty()==0 && tempLot.getPrice()< amount ) {
	            tempLot.setPrice(amount);
	            lot.setSeller(lotRepository.findById(lot.getId()).getSeller());
	            lot.setBuyer(new User(username,"", "", "", "", 0));
	            lotRepository.save(lot);
	        }

	    }

	    public Lot  getBid(String id){

	        return lotRepository.findOne(id);
	    }

	    public void updateBid(Lot lot,  double amount) {

	        Lot tempLot = lotRepository.findById(lot.getId());
	        if(tempLot.getPrice()< amount ) {
	            tempLot.setPrice(amount);
	            lot.setSeller(tempLot.getSeller());
	            lot.setBuyer(tempLot.getBuyer());
	            lotRepository.save(lot);
	        }
	    }

	
	 

}
