package com.dev.generik.service;

import org.springframework.stereotype.Service;

@Service
public class ValidatorFieldService  {
	
    public ValidatorFieldService() {
		super();
	}    

	public boolean isValidSequence(String lookUpStr, String analizeStr ) {		
		final char[] c;
		c = analizeStr.toCharArray();
		String s;
		for (char cAt : c) {
			s = String.valueOf(cAt);
			if (!lookUpStr.contains(s)) {
				return false;
			}
		}		
		return true;
	}

}
