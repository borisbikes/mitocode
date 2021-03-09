package com.webproject.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.commons.codec.digest.DigestUtils;

import com.webproject.dao.UserDAO;
import com.webproject.entity.User;

@ManagedBean
@SessionScoped
public class UserBean {
	
	private User user = new User();

	public String checkInputData() throws Exception{
		
		UserDAO dao = new UserDAO();
		User us;
		String answer = null;
		
		try {
			//seting up encoding password
			this.user.setPassword(encode(this.user.getPassword(), "md5"));
			us = dao.findUser(this.user);
			
			if(us != null) {
				//Manage Session
				//Save into the JSF context the variable user founded 
				FacesContext.getCurrentInstance().getExternalContext()
				.getSessionMap().put("user", us);
				//redirection to session/success.xhtml page
				answer = "success";
				
			}else {
				//redirection to session/failure.xhtml page
				answer = "failure";
			}
		}catch (Exception e) {
			throw e;
		}
		
		return answer;
	}
	
	/**
	 * This method help us to check if the session was initialized before 
	 * @return true if the session was founded
	 */
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
		return "index?faces-redirect=true";
	}
	
	/**
	 * This method help us to encode a password
	 * @param String pass: text to decode
	 * @param String encryptingType: md5Hex or sha1Hex type encode  
	 * @return String decoded
	 */
	private String encode(String code, String encryptingType) {
		if("md5".equalsIgnoreCase(encryptingType))
		return DigestUtils.md5Hex(code);
		else return DigestUtils.sha1Hex(code);
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
