package com.mitocode.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Class that manage the request from View UI
 * @author boris
 *
 */

@ManagedBean
@RequestScoped
public class GreetingBean {
	
	private String name;
	private String message;
	
	public GreetingBean() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public void greeting() {
		this.message = "Hi terrestrial " + this.name +  ", my name is Perseverance."  ;
	}

}
