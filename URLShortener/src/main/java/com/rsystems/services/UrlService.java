package com.rsystems.services;

import java.net.URL;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rsystems.domains.Url;
import com.rsystems.dtos.CreateLinkDTO;
import com.rsystems.dtos.LinkDTO;
import com.rsystems.exceptions.UrlFoundException;

import com.rsystems.helpers.UrlShortnerHelper;
import com.rsystems.repositories.UrlRepository;
import com.rsystems.utils.Constants;



@Service
public class UrlService {

	Logger logger = LoggerFactory.getLogger(UrlService.class);

	@Autowired
	private UrlRepository repository;

	public Url find(String urlCode) {
		//final String code = urlCode.replaceAll(Constants.PATTERN_BREAKING_CHARACTERS, "_");
		logger.info(Constants.FINDING_URL_BY_CODE, urlCode);
		Optional<Url> optional = repository.findById(urlCode);
		if(optional.isPresent()) {
			return optional.get();	
		}
		return null;
	}

	/*private Url recursiveInsert(String longUrl, int startIndex, int endIndex) {

		longUrl = longUrl.replaceAll(Constants.PATTERN_BREAKING_CHARACTERS, "_");
		longUrl=longUrl
		logger.info(Constants.RECURSIVE_INSERT, longUrl);

		String code = UrlShortnerHelper.generateShortURL(longUrl, startIndex, endIndex);

		Url url;
		try {
			url = find(code);

			if (!url.getLongUrl().equals(longUrl)) {
				logger.info(Constants.FOUND_DIFFERENT_URLS_FOR_SAME_CODE, code);

				url = recursiveInsert(longUrl, startIndex + 1, endIndex + 1);
			}
		} catch (UrlNotFoundException e) {
			logger.warn(Constants.URL_NOT_FOUND_CREATING_NEW_ONE, code, e);

			url = repository.save(new Url(code, longUrl));
		}

		return url;
	}*/
		/**
		 * 
		 * @param urlDto
		 * @return
		 */
	public LinkDTO createShortURL(CreateLinkDTO urlDto) throws UrlFoundException {
		Url url =fromDTO(urlDto);
		String longUrl = url.getLongUrl();
		logger.info(Constants.FINDING_OR_CREATING_URL, longUrl);
		int startIndex = 0;
		int endIndex = startIndex + Constants.URL_CODE_SIZE - 1;
		longUrl = longUrl.replaceAll(Constants.PATTERN_BREAKING_CHARACTERS, "_").concat(urlDto.getCustomerId());
		logger.info(Constants.RECURSIVE_INSERT, longUrl);
		String code = UrlShortnerHelper.generateShortURL(longUrl, startIndex, endIndex);
		Url recievedUrl = find(code);
		if(recievedUrl!=null) {
			throw new UrlFoundException("URL already exist for this customer");
			}
		url.setCode(code);
		url = repository.save(url);
		
		LinkDTO linkDTO=toLinkDTO(url);
		return linkDTO;
	}
	
	




	public Url fromDTO(CreateLinkDTO urlDto) {
		Url url=new Url();
		url.setLongUrl(urlDto.getUrl());
		url.setCustomerId(urlDto.getCustomerId());
		return url;
		
	}
	
	public LinkDTO toLinkDTO(Url url) {
		LinkDTO linkDTO=new LinkDTO();
		linkDTO.setDateCreated(url.getCreatedAt().getTime());
		linkDTO.setShortURL(url.getCode());
		linkDTO.setUrl(url.getLongUrl());
		return linkDTO;
		
	}
}
