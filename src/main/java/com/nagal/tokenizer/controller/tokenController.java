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

	@PostMapping("/saveCard")
	public ResponseEntity<?> saveCard(@RequestBody CreditCard card){
		if(cardService.saveCard(card)){
			return ResponseEntity.ok("Card saved in DB");
		}
		else {
			return ResponseEntity.internalServerError().build();
		}
	}

	@GetMapping("/validate")
	public ResponseEntity<?> validateCard(@RequestBody CreditCard card){
		if(cardService.validateCard(card)){
			return ResponseEntity.ok("Card Validated");
		}
		else{
			return ResponseEntity.ok("Card Not Found");
		}
	}

}

