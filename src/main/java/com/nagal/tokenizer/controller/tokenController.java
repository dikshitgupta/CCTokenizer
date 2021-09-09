package com.nagal.tokenizer.controller;

import com.nagal.tokenizer.model.CreditCard;
import com.nagal.tokenizer.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class tokenController {

	@Autowired
	private CardService cardService;

	@GetMapping("/hello")
	public String hello(){
		return "hello rest controller";
	}

	@PostMapping("/saveCard")
	public ResponseEntity<?> saveCard(@RequestBody CreditCard card){
		cardService.saveCard(card);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/validate")
	public ResponseEntity<?> validateCard(@RequestBody CreditCard card){
		return ResponseEntity.ok(cardService.validateCard(card));
	}

}

