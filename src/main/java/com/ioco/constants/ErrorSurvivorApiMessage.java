package com.ioco.constants;

import java.util.Collections;
import java.util.List;

public final class ErrorSurvivorApiMessage implements SurvivorApiMessage {

	// Project Api Error Message
	public static final SurvivorApiMessage SURVIVOR_NOT_FOUND= new ErrorSurvivorApiMessage(320, "Survivor does exit in the DB for the given Id");

	final int resultCode;
	final String message;
	final List<String> errors;

	public ErrorSurvivorApiMessage(int resultCode, String message) {
		super();
		this.resultCode = resultCode;
		this.message = null;
		this.errors = Collections.singletonList(message);
	}

	public ErrorSurvivorApiMessage(int resultCode, String message, List<String> errors) {
		super();
		this.resultCode = resultCode;
		this.message = message;
		this.errors = errors;
	}

	@Override
	public int getResultCode() {
		return resultCode;

	}

	@Override
	public String getMessage() {
		return message;
	}

	@Override
	public List<String> getErrors() {
		return errors;
	}
}
