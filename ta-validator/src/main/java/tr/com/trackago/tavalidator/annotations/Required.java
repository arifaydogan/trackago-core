package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.RequiredValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = RequiredValidator.class)
public @interface Required {

    String message() default "Bir Değer Girilmesi Zorunludur.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}