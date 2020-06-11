package fr.ing.interview.bank.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Account Not Found")
public class AccountNotFoundException extends Exception {
	 
    public AccountNotFoundException(String message) {
        super(message);
    }
}