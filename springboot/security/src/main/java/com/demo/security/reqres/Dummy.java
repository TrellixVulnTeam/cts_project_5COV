package com.demo.security.reqres;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Dummy {

	public static void main(String[] args) {
		PasswordEncoder passEncode=new BCryptPasswordEncoder();
		System.out.println(passEncode.encode("priya@123"));
	}
}
