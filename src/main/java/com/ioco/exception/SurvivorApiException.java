package com.ioco.exception;

import com.ioco.constants.SurvivorApiMessage;

public class SurvivorApiException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private SurvivorApiMessage survivorApiMessage;

	public SurvivorApiException() {
		super();
	}

	public SurvivorApiException(SurvivorApiMessage survivorApiMessage) {
		super();
		this.survivorApiMessage = survivorApiMessage;
	}

	public SurvivorApiMessage getSurvivorApiMessage() {
		return survivorApiMessage;
	}

}
