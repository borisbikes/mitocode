package com.mitocode.jsf.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="OverAgeValidator")
public class OverAgeValidator implements Validator {

	@Override
	public void validate(FacesContext context, UIComponent component, Object value) 
			throws ValidatorException {
		String text = String.valueOf(value);
		int edad = Integer.parseInt(text);
		
		if(edad < 18) {
			FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Age not available", "Person must be over 18 years.");
			//throw the exception at View
			throw new  ValidatorException(msg);
			
		}
		
	}

}
