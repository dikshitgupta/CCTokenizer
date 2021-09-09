package com.nagal.tokenizer.service;

import com.nagal.tokenizer.model.CreditCard;
import com.nagal.tokenizer.model.Token;
import com.nagal.tokenizer.repository.CardRepository;
import org.hibernate.exception.SQLGrammarException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CardService {

	@Autowired
	private CardRepository cardRepository;

	private static final Logger logger = Logger.getLogger(CardService.class.getName());

	public Boolean saveCard(CreditCard creditCard) {
		Integer hashedCard=creditCard.hashCode();
		Token token=new Token();
		token.setHashedValue(hashedCard);
		if(validateCard(creditCard)){
			logger.info("Card Details are already Saved");
			return true;
		}
		try {
			cardRepository.save(token);
		}
		catch(SQLGrammarException e) {
			logger.severe(e.getMessage());
			return false;
		}
		logger.info("Tokenized Card Details Saved");
		return true;
	}

	public Boolean validateCard(CreditCard creditCard){
		Integer hashedCard=creditCard.hashCode();
		return cardRepository.existsByHashedValue(hashedCard);
	}

}
