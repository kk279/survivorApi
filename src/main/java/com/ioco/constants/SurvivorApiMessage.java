package com.ioco.constants;

import java.util.List;

public interface SurvivorApiMessage {

	public int getResultCode();

	public String getMessage();

	public List<String> getErrors();
	
}
