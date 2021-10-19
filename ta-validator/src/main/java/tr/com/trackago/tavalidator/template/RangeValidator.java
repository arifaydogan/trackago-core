package tr.com.trackago.tavalidator.template;


import org.springframework.stereotype.Component;
import tr.com.trackago.tavalidator.annotations.Range;
import tr.com.trackago.tavalidator.common.CustomObjectMapper;
import tr.com.trackago.tavalidator.common.ValidationUtil;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Component
public class RangeValidator implements ConstraintValidator<Range, Object> {

    private CustomObjectMapper customObjectMapper;
    private Comparable from;
    private Comparable to;

    @Override
    public void initialize(Range constraintAnnotation) {
        customObjectMapper = new CustomObjectMapper();
        this.from = (Comparable) customObjectMapper.convertValue(constraintAnnotation.from(), constraintAnnotation.compareClass());
        this.to = (Comparable) customObjectMapper.convertValue(constraintAnnotation.to(), constraintAnnotation.compareClass());
    }


    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return ValidationUtil.range((Comparable) value, from, to);
    }


}
