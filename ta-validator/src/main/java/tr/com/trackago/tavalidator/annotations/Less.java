package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.LessValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = LessValidator.class)
public @interface Less {

    boolean isEqual() default false;

    String than();

    Class<?> compareClass() default Integer.class;

    String message() default "{Daha Az Olmalı}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
