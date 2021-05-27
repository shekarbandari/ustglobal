package com.ust.pms.util;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

public class UserUtil {
	
	public static String getUserName() {
		String username = null;

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		if (principal instanceof UserDetails) {
			username = ((UserDetails) principal).getUsername();
			System.out.println("##### user name is : :" + username);

		}
		return username;
		
	}

}
