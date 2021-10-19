package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.LengthValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = LengthValidator.class)
public @interface Length {

    int from();

    int to();

    String message() default "{Uzunluk Hatalı}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
