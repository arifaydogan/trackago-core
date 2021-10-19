package tr.com.trackago.tavalidator.template;


import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.Length;
import tr.com.trackago.tavalidator.common.ValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Collection;

@Component
public class LengthValidator implements ConstraintValidator<Length, Object> {

    private int to;
    private int from;

    @Override
    public void initialize(Length constraintAnnotation) {
        this.to = constraintAnnotation.to();
        this.from = constraintAnnotation.from();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value instanceof Collection) {
            return ValidationUtil.length((Collection) value, from, to);
        } else {
            return ValidationUtil.length(value, from, to);
        }
    }

}
