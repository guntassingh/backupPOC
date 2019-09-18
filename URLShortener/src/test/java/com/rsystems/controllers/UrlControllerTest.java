package com.rsystems.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.rsystems.dtos.CreateLinkDTO;
import com.rsystems.dtos.LinkDTO;
import com.rsystems.services.UrlService;




//@RunWith(MockitoJUnitRunner.class)
public class UrlControllerTest {
	
	
	@Mock	
	private UrlService urlService;
	/*
	 * @Before public void init() { urlService = new UrlService(); }
	 * 
	 * @Test public void testCreateShortURL() { UrlController controller = new
	 * UrlController(); CreateLinkDTO urlDto = new CreateLinkDTO();
	 * urlDto.setCustomerId("12345"); urlDto.setUrl("twitter.com");
	 * 
	 * LinkDTO linkDTO=new LinkDTO();
	 * 
	 * Mockito.when(urlService.createShortURL(urlDto)).thenReturn(linkDTO); //
	 * controller.createShortURL(urlDto, "12345");
	 * 
	 * assertEquals(controller.createShortURL(urlDto, "12345"), linkDTO);
	 * 
	 * }
	 */

	

}
