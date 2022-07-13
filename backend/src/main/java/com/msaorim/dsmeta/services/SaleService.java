package com.msaorim.dsmeta.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msaorim.dsmeta.entities.Sale;
import com.msaorim.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {
	
	@Autowired
	private SaleRepository saleRepository;
	
	public List<Sale> findAll(){
		return saleRepository.findAll();
	}

	public Sale findById(long id) {
		Optional<Sale> obj = saleRepository.findById(id);
		return obj.orElse(null);
	}
}
