package com.nagal.tokenizer.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreditCard {

	private String cardNumber;

	@JsonFormat(shape= JsonFormat.Shape.STRING, pattern="yyyy-MM")
	private Date validDate;

	private String cvvNumber;

	@Override
	public String toString() {
		return "CreditCard{" +
				", cardNumber='" + cardNumber + '\'' +
				", validDate=" + validDate +
				", cvvNumber='" + cvvNumber + '\'' +
				'}';
	}


	public int hashCode() {
		int hash = 7;
		hash = 31 * hash + cardNumber.hashCode();
		hash = 31 * hash +  validDate.hashCode();
		hash = 31 * hash +  cvvNumber.hashCode();
		System.out.println("hashCode() called - Computed hash: " + hash);
		return hash;
	}

}
