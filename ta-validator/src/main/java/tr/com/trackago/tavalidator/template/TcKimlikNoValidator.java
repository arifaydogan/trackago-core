package tr.com.trackago.tavalidator.template;


import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.TcNoValid;
import tr.com.trackago.tavalidator.common.ValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class TcKimlikNoValidator implements ConstraintValidator<TcNoValid, String> {


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidationUtil.isValidTckn(value);
    }


}
