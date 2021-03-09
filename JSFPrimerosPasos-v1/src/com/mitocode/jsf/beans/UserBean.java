package com.mitocode.jsf.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import com.mitocode.jsf.dao.UserDAO;
import com.mitocode.jsf.model.User;

@ManagedBean
@RequestScoped
public class UserBean {
	private User user = new User();

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	public String checkInputData() throws Exception{
		
		UserDAO dao = new UserDAO();
		User us;
		String answer = null;
		
		try {
			us = dao.getUser(this.user);
			
			if(us != null) {
				//Manage Session
				//Save into the JSF context the variable user founded 
				FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().put("user", us);
				//redirection to session/success.xhtml page
				answer = "success";
				
			}else {
				//redirection to session/failure.xhtml page
				answer = "failute";
			}
		}catch (Exception e) {
			throw e;
		}
		
		return answer;
	}
	
	
	public boolean checkSession() {
		boolean state;
		
		if(FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().get("user")==null) {
			state = false;
		}else {
			state = true;
		}
		return state;
	}
	
	public String closeSession() {
		FacesContext.getCurrentInstance().getExternalContext()
		.invalidateSession();
		return "login?faces-redirect=true";
	}

}
