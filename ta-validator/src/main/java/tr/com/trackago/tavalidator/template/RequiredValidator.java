package tr.com.trackago.tavalidator.template;

import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.Required;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class RequiredValidator implements ConstraintValidator<Required, Object> {


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }
        return true;
    }
}
