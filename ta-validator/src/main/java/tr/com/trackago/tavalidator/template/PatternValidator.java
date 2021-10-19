package tr.com.trackago.tavalidator.template;


import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.Pattern;
import tr.com.trackago.tavalidator.common.ValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class PatternValidator implements ConstraintValidator<Pattern, String> {

    private String regex;

    @Override
    public void initialize(Pattern constraintAnnotation) {
        this.regex = constraintAnnotation.regex();
    }


    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return ValidationUtil.isPatternValid(value, regex);
    }
}
