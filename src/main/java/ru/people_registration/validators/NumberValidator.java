package ru.people_registration.validators;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("NumberValidator")
public class NumberValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        try{
            int num = Integer.valueOf(value.toString());
            if(num <= 0)
                throw new NumberFormatException();
        }catch(NumberFormatException ignore){
            FacesMessage message = new FacesMessage(component.getId() + ": Номер введен неверно!");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(message);
        }
    }
}
