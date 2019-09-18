package com.rsystems.dtos;

import java.io.Serializable;

public class LinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String shortURL;
	private Long dateCreated;
	private String url;

	public String getShortURL() {
		return shortURL;
	}

	public void setShortURL(String shortURL) {
		this.shortURL = shortURL;
	}

	/**
	 * @return the dateCreated
	 */
	public Long getDateCreated() {
		return dateCreated;
	}

	/**
	 * @param dateCreated the dateCreated to set
	 */
	public void setDateCreated(Long dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
