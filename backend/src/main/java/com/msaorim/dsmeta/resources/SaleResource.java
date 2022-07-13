package com.msaorim.dsmeta.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.msaorim.dsmeta.entities.Sale;
import com.msaorim.dsmeta.services.SaleService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {

	@Autowired
	private SaleService saleService;

	//@GetMapping
	//public List<Sale> findAll() {
	//	return saleService.findAll();
	//}

	@GetMapping
	public ResponseEntity<List<Sale>> findAll() {
		return ResponseEntity.ok().body(saleService.findAll());
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sale> findById(@PathVariable long id) {
		return ResponseEntity.ok().body(saleService.findById(id));
	}
}
