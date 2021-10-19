package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.GreaterValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = GreaterValidator.class)
public @interface Greater {

    boolean isEqual() default false;

    String than();

    Class<?> compareClass() default Integer.class;

    String message() default "{Daha Büyük Olmalı}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
