package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.RangeValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = RangeValidator.class)
public @interface Range {

    String from();

    String to();

    String message() default "Girilen değer {from} ile {to} aralığında olmalıdır.";

    Class<?> compareClass() default Integer.class;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
