package tr.com.trackago.tavalidator.template;


import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.Greater;
import tr.com.trackago.tavalidator.common.CustomObjectMapper;
import tr.com.trackago.tavalidator.common.ValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class GreaterValidator implements ConstraintValidator<Greater, Object> {

    private String than;
    private boolean isEqual;
    private Class<?> compareClass;
    private CustomObjectMapper customObjectMapper;

    @Override
    public void initialize(Greater constraintAnnotation) {
        this.than = constraintAnnotation.than();
        this.isEqual = constraintAnnotation.isEqual();
        this.compareClass = constraintAnnotation.compareClass();
        this.customObjectMapper = new CustomObjectMapper();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Comparable converted = (Comparable) customObjectMapper.convertValue(than, compareClass);
        if (isEqual) {
            return ValidationUtil.greaterOrEqual((Comparable) value, converted);
        } else {
            return ValidationUtil.greater((Comparable) value, converted);
        }
    }

}
