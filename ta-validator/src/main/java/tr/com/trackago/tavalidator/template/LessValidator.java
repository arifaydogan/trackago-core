package tr.com.trackago.tavalidator.template;


import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.Less;
import tr.com.trackago.tavalidator.common.CustomObjectMapper;
import tr.com.trackago.tavalidator.common.ValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class LessValidator implements ConstraintValidator<Less, Object> {

    private String than;
    private boolean isEqual;
    private Class<?> compareClass;
    private CustomObjectMapper customObjectMapper;


    @Override
    public void initialize(Less constraintAnnotation) {
        this.compareClass = constraintAnnotation.compareClass();
        this.isEqual = constraintAnnotation.isEqual();
        this.than = constraintAnnotation.than();
        this.customObjectMapper = new CustomObjectMapper();
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        Comparable converted = (Comparable) customObjectMapper.convertValue(than, compareClass);
        if (isEqual) {
            return ValidationUtil.lessOrEqual((Comparable) value, converted);
        } else {
            return ValidationUtil.less((Comparable) value, converted);
        }
    }


}
