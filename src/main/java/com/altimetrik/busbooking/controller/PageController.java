package com.altimetrik.busbooking.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.altimetrik.busbooking.constants.AppConstants;

/**
 * @author Prasath
 *
 */
@RestController
public class PageController {
	
	@RequestMapping("/status")
	public String status() {
		return AppConstants.SUCCESS;
	}

}
