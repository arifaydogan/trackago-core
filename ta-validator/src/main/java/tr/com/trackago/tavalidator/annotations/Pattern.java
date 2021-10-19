package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.PatternValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = PatternValidator.class)
public @interface Pattern {

    String message() default "Girilen değer veri formatına uygun değildir.";

    String regex();

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
