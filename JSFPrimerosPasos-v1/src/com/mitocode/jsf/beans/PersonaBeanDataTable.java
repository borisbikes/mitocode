package com.mitocode.jsf.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import com.mitocode.jsf.model.Persona_;

@ManagedBean
@RequestScoped
public class PersonaBeanDataTable {

	private Persona_ persona  = new Persona_();
	private static List<Persona_> lstPersonas = new ArrayList<Persona_>();
	
	
	public void addPersona() {
		PersonaBeanDataTable.lstPersonas.add(this.persona);
	}
	
	public void deletePersona(Persona_ persona) {
		PersonaBeanDataTable.lstPersonas.remove(persona);
	}
	
	/**
	 * Method that catch the information from the component and can validate from back bean
	 *    
	 */
	public void validateInput(FacesContext context, UIComponent fromComponent, Object value) {
		context = FacesContext.getCurrentInstance();
		String text = (String)value;

		if(!text.equalsIgnoreCase("M") && !text.equalsIgnoreCase("F")){
			// if not is M nor F let the disable the component
			((UIInput)fromComponent).setValid(false);
			// show the message though a new component message at user
			context.addMessage(fromComponent.getClientId(context), new FacesMessage("Sex is not valid"));
		}
	}
	
	
	public Persona_ getPersona() {
		return persona;
	
	}
	public void setPersona(Persona_ persona) {
		this.persona = persona;
	}
	public List<Persona_> getLstPersonas() {
		return lstPersonas;
	}
	public void setLstPersonas(List<Persona_> lstPersonas) {
		PersonaBeanDataTable.lstPersonas = lstPersonas;
	}

	
	
	
}
