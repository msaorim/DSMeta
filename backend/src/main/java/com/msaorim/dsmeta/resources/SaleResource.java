package com.msaorim.dsmeta.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.msaorim.dsmeta.entities.Sale;
import com.msaorim.dsmeta.services.SaleService;
import com.msaorim.dsmeta.services.SmsService;

@RestController
@RequestMapping(value = "/sales")
public class SaleResource {

	@Autowired
	private SaleService saleService;
	
	@Autowired
	private SmsService smsService;

	@GetMapping
	public Page<Sale> findAll(@RequestParam(value = "minDate", defaultValue = "") String minDate,
			@RequestParam(value = "maxDate", defaultValue = "") String maxDate, Pageable pageable) {
		return saleService.findAll(minDate, maxDate, pageable);
	}

	// @GetMapping
	// public ResponseEntity<List<Sale>> findAll() {
	// return ResponseEntity.ok().body(saleService.findAll());
	// }

	@GetMapping(value = "/{id}")
	public ResponseEntity<Sale> findById(@PathVariable long id) {
		return ResponseEntity.ok().body(saleService.findById(id));
	}
	
	@GetMapping(value = "/{id}/notify")
	public void notifySms(@PathVariable long id) {
		smsService.sendSms(id);
	}
}
