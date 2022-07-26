package com.example.ordering.form;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class AccountForm {
	@NotBlank
	@Size(min=5,max=20)
	private String accountId;
	@NotBlank
	@Size(min=8,max=30)
	private String password;
	@NotBlank
	@Size(min=8,max=30)
	private String retypedPassword;
	
	@AssertTrue(message="{password_match_check}")
	public boolean isPasswordValid() {
		if (password == null || password.isEmpty()) {
			return false;
		}
		return password.equals(retypedPassword); 
	}
}
