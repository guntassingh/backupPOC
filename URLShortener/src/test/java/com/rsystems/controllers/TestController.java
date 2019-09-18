package com.rsystems.controllers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.google.gson.Gson;
import com.rsystems.dtos.CreateLinkDTO;
import com.rsystems.dtos.LinkDTO;
import com.rsystems.services.StatisticService;
import com.rsystems.services.ThirdPartyServices;
import com.rsystems.services.UrlService;

/* @RunWith(SpringRunner.class)
 @WebMvcTest(UrlController.class)*/
    public class TestController {
	/*
	 * @MockBean private UrlService urlService;
	 * 
	 * @MockBean private ThirdPartyServices thirdPartyServices;
	 * 
	 * @MockBean private StatisticService statisticService;
	 * 
	 * @Autowired private MockMvc mockMvc;
	 * 
	 * 
	 * @Test public void testData() throws Exception { //given CreateLinkDTO urlDto
	 * = new CreateLinkDTO(); urlDto.setCustomerId("12345");
	 * urlDto.setUrl("twitter.com");
	 * 
	 * 
	 * LinkDTO linkDTO=new LinkDTO(); linkDTO.setShortURL("M2M123");
	 * linkDTO.setDateCreated(1234567l); linkDTO.setUrl("twitter1.com");
	 * 
	 * 
	 * Mockito.when(urlService.createShortURL(urlDto)).thenReturn(linkDTO);
	 * 
	 * //when Gson gson=new Gson(); MockHttpServletRequestBuilder requestBuilder =
	 * MockMvcRequestBuilders.post("/s/url").content(gson.toJson(urlDto));
	 * 
	 * MvcResult result = mockMvc.perform(requestBuilder).andReturn();
	 * 
	 * 
	 * String resultFromURL=result.getResponse().getContentAsString(); String
	 * expectedJson =
	 * "[{\"shortURL\":\""+"M2M123"+"\",\"dateCreated\":\""+1234567l+"\",\"url\":\""
	 * +"twitter.com"+"\"}]"; //then JSONAssert.assertEquals(expectedJson,
	 * resultFromURL, false);
	 * assertEquals(org.apache.http.HttpStatus.SC_OK,result.getResponse().getStatus(
	 * ));
	 * 
	 * }
	 */
        
    }