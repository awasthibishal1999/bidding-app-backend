package com.bishal.repo;

import java.util.List;



import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bishal.model.Lot;

public interface LotRepo extends CrudRepository<Lot, String> {

    public List<Lot> findBySellerUsername (String username);
    public List<Lot> findByBuyerUsername (String username);
    public List<Lot> findByTopic (String topic);
    public List<Lot> findByEndDate (String topic);
    public Lot findById (Long Id);

    @Transactional
    Long deleteById(Long firstName);
	public Lot findOne(String id);
}
