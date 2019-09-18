package com.rsystems.dtos;

import java.io.Serializable;

public class JsonResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private boolean success;
	private String errorMessages;
	private Object object;
	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}
	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}
	/**
	 * @return the errorMessages
	 */
	public String getErrorMessages() {
		return errorMessages;
	}
	/**
	 * @param errorMessages the errorMessages to set
	 */
	public void setErrorMessages(String errorMessages) {
		this.errorMessages = errorMessages;
	}
	/**
	 * @return the object
	 */
	public Object getObject() {
		return object;
	}
	/**
	 * @param object the object to set
	 */
	public void setObject(Object object) {
		this.object = object;
	}
	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
