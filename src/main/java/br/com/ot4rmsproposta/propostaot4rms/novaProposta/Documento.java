package br.com.ot4rmsproposta.propostaot4rms.novaProposta;


import org.hibernate.validator.constraints.CompositionType;
import org.hibernate.validator.constraints.ConstraintComposition;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import java.lang.annotation.*;

@CNPJ
@ConstraintComposition(CompositionType.OR)
@CPF
@ReportAsSingleViolation
@Constraint(validatedBy = { })
@Documented
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Documento {

    String message() default "Documento (CNPJ ou CPF) invalido";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
