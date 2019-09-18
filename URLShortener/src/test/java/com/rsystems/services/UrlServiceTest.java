package com.rsystems.services;


import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rsystems.domains.Url;
import com.rsystems.dtos.CreateLinkDTO;
import com.rsystems.dtos.LinkDTO;
import com.rsystems.exceptions.UrlNotFoundException;
import com.rsystems.helpers.UrlShortnerHelper;
import com.rsystems.repositories.UrlRepository;
import com.rsystems.utils.Constants;



public class UrlServiceTest {
	/*
	@InjectMocks
	private UrlService service;

	@Mock
	private UrlRepository repository;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void whenCodeExistsReturnsUrl() {
		// Given
		String existingCode = "3077yW";

		Url existingUrl = new Url(existingCode, "http://www.neueda.com", "12345");
		Optional<Url> optional = Optional.of(existingUrl);
		Mockito.when(repository.findById(existingCode)).thenReturn(optional);

		// When
		Url url = service.find(existingCode);

		// Then
		Assert.assertEquals(existingUrl, url);
	}
	
	@Test
	public void whenCodenotExistReturnNull() {
		// Given
		String existingCode = "3077yW1";

		Url existingUrl = new Url("3077yW", "http://www.neueda.com", "12345");
		Optional<Url> optional = Optional.empty();
		Mockito.when(repository.findById(existingCode)).thenReturn(optional);

		// When
		Url url = service.find(existingCode);

		// Then
		Assert.assertNull(url);
	}
//=================================
	  @Test 
	  public void whenLongUrlDoesNotExistSaveItAndReturnNewUrlCode() { 
		  String existingCode = "3077yW";

			Url existingUrl = new Url(existingCode, "http://www.neueda.com", "12345");
			existingUrl.setCreatedAt(new Date());
			Optional<Url> optional = Optional.of(existingUrl);
			Mockito.when(repository.findById(existingCode)).thenReturn(optional);
		
	  
	  CreateLinkDTO createLinkDTO=new CreateLinkDTO();
	  createLinkDTO.setCustomerId("12345");
	  createLinkDTO.setUrl("http://www.neueda.com");
		//Mockito.when(service.find(existingCode)).thenReturn(existingUrl);
		
	  LinkDTO ldto = new LinkDTO(); 
	  ldto.setShortURL(existingCode);
	  ldto.setUrl("http://www.neueda.com"); 
	  ldto.setDateCreated(new
	  Date().getTime());
	  
	  
	 // Mockito.when(service.createShortURL(createLinkDTO)).thenReturn(ldto); LinkDTO
	 LinkDTO linkDTO=service.createShortURL(createLinkDTO);
	  
	  Assert.assertEquals(linkDTO.getShortURL(), "3077yW");
	 
	 }
	 
	

	

	/*
	 * @Test public void whenLongUrlExistGeneratedU() { // Given String code = null;
	 * String notExistingLongUrl = "http://www.google.com"; Url urlToCreate = new
	 * Url(code, notExistingLongUrl, "");
	 * 
	 * int startIndex = 0; int endIndex = startIndex + Constants.URL_CODE_SIZE - 1;
	 * String existingCode = UrlShortnerHelper.generateShortURL(notExistingLongUrl,
	 * startIndex, endIndex);
	 * 
	 * Url existingUrl = new Url(existingCode, "http://www.neueda.com","12345");
	 * Optional<Url> optional = Optional.of(existingUrl);
	 * Mockito.when(repository.findById(existingCode)).thenReturn(optional);
	 * 
	 * startIndex = startIndex + 1; endIndex = endIndex + 1; String notExistingCode
	 * = UrlShortnerHelper.generateShortURL(notExistingLongUrl, startIndex,
	 * endIndex);
	 * 
	 * Mockito.when(repository.findById(notExistingCode)) .thenThrow(new
	 * UrlNotFoundException(Constants.URL_NOT_FOUND_FOR_CODE + notExistingCode));
	 * 
	 * Url url = new Url(notExistingCode, notExistingLongUrl,"12345");
	 * Mockito.when(repository.save(url)).thenReturn(url);
	 * 
	 * // When Url newUrl = service.find("abcde");
	 * 
	 * // Then Assert.assertEquals(url, newUrl); }
	 */

	
	

}