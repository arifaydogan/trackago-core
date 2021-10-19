package tr.com.trackago.tavalidator.annotations;


import tr.com.trackago.tavalidator.template.TcKimlikNoValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.PARAMETER})
@Constraint(validatedBy = TcKimlikNoValidator.class)
public @interface TcNoValid {

    String message() default "Tc Kimlik Numarası Geçerli Değildir.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}