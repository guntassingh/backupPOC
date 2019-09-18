package com.rsystems.dtos;

import static com.rsystems.utils.Constants.MAX_LONG_URL_SIZE;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.URL;

public class CreateLinkDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	@NotEmpty
	private String customerId;

	@NotNull
	@NotEmpty
	@URL
	@Length(max = MAX_LONG_URL_SIZE)
	private String url;

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
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
