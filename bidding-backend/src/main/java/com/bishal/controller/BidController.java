package com.bishal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bishal.model.Lot;
import com.bishal.serviceImpl.BidService;

@RestController
public class BidController {
	  @Autowired
	    private BidService bidService;


	    @RequestMapping("/users/{username}/bids")
	    public List<Lot> getAllBids(@PathVariable String username){
	        return bidService.getAllBids(username);
	    }

	    @RequestMapping("/users/{username}/bids/{id}")
	    public Lot getBid(@PathVariable String id){
	        return bidService.getBid(id);
	    }

	    @RequestMapping(method= RequestMethod.POST, value = "/users/{username}/bids/{amount}")
	    public void addBids(@RequestBody Lot lot, @PathVariable String username, @PathVariable double amount){
	        bidService.addBid(lot,username,amount);
	    }

	    @RequestMapping(method= RequestMethod.PUT, value = "/users/{username}/bids/{id}/{amount}")
	    public void updateLot(@RequestBody Lot lot, @PathVariable String username,@PathVariable String id, @PathVariable double amount){
	        bidService.updateBid(lot,amount);
	    }


}
