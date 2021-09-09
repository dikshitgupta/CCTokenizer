package com.nagal.tokenizer.repository;
import com.nagal.tokenizer.model.Token;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Token,Integer> {
	boolean existsByHashedValue(Integer hashedValue);
}

