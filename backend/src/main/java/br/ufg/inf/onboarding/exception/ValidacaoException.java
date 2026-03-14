package br.ufg.inf.onboarding.exception;

import lombok.Getter;
import org.springframework.validation.Errors;

@Getter
public class ValidacaoException extends RuntimeException {

    private final Errors errors;

    public ValidacaoException(Errors errors) {
        super("Erro de validação");
        this.errors = errors;
    }

}