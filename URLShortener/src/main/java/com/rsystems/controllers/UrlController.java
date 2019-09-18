package com.rsystems.controllers;

import java.net.URI;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.rsystems.domains.Statistic;
import com.rsystems.domains.Url;
import com.rsystems.dtos.CreateLinkDTO;
import com.rsystems.dtos.JsonResponse;
import com.rsystems.dtos.LinkDTO;
import com.rsystems.exceptions.UrlFoundException;
import com.rsystems.exceptions.UrlNotFoundException;
import com.rsystems.services.StatisticService;
import com.rsystems.services.ThirdPartyServices;
import com.rsystems.services.UrlService;
import com.rsystems.utils.Constants;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "URL Controller")
public class UrlController {
	Logger logger = LoggerFactory.getLogger(UrlController.class);

	@Autowired
	private UrlService urlService;
	
	@Autowired
	private ThirdPartyServices thirdPartyServices;
	
	@Autowired
	private StatisticService statisticService;

	
	
	@ApiOperation(value = "Create Shortern URL", response = LinkDTO.class)
	@PostMapping(value = "/s/url")
	@ResponseBody
	public LinkDTO createShortURL(@Valid @RequestBody CreateLinkDTO urlDto, @RequestHeader("token") String userToken ) {
		logger.info(Constants.FINDING_OR_CREATING_URL, urlDto);
		thirdPartyServices.validateToken();
		
		LinkDTO linkDTO = null;
	
			linkDTO = urlService.createShortURL(urlDto);
		

		/*URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{code}").buildAndExpand(url.getCode())
				.toUri();*/
		return linkDTO;
	}
	
	
	
	@GetMapping(path = "/{code}")
	public ResponseEntity<Url> findAndRedirect(@PathVariable String code,
			@RequestHeader Map<String, String> headersMap) {

		code = code.replaceAll(Constants.PATTERN_BREAKING_CHARACTERS, "_");

		logger.info(Constants.FINDING_URL_FOR_REDIRECTING, code);

		Url url = urlService.find(code);
		if(url ==null) {
			throw new UrlNotFoundException("URL not found");
		}
			
		Statistic statistic = statisticService.mapFrom(headersMap, url);
		statisticService.create(statistic);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(URI.create(url.getLongUrl()));

		return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
	}
/*
	@GetMapping(path = "/{code}/longUrl")
	public ResponseEntity<Url> find(@PathVariable String code) {

		code = code.replaceAll(Constants.PATTERN_BREAKING_CHARACTERS, "_");

		logger.info(Constants.FINDING_LONG_URL, code);

		ResponseEntity<Url> responseEntity;

		Url url = service.find(code);
		responseEntity = ResponseEntity.ok().body(url);

		return responseEntity;
	}*/
	 


}