package br.ufg.inf.onboarding.validators.pessoa;

import br.ufg.inf.onboarding.model.Pessoa;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;

import static org.junit.jupiter.api.Assertions.*;

class PessoaValidatorTest {

    private PessoaValidator validator;

    @BeforeEach
    void setUp() {
        validator = new PessoaValidator();
    }

    @Test
    void deveSuportarClassePessoa() {
        assertTrue(validator.supports(Pessoa.class));
    }

    @Test
    void naoDeveSuportarOutraClasse() {
        assertFalse(validator.supports(String.class));
    }

    @Test
    void devePassarComDadosValidos() {
        Pessoa pessoa = pessoaValida();
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertFalse(errors.hasErrors());
    }

    @Test
    void deveRejeitarCpfNulo() {
        Pessoa pessoa = pessoaValida();
        pessoa.setCpf(null);
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertTrue(errors.hasFieldErrors("cpf"));
        assertEquals("validator.error.cpf.empty", errors.getFieldError("cpf").getCode());
    }

    @Test
    void deveRejeitarCpfVazio() {
        Pessoa pessoa = pessoaValida();
        pessoa.setCpf("   ");
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertTrue(errors.hasFieldErrors("cpf"));
        assertEquals("validator.error.cpf.empty", errors.getFieldError("cpf").getCode());
    }

    @Test
    void deveRejeitarCpfInvalido() {
        Pessoa pessoa = pessoaValida();
        pessoa.setCpf("111.111.111-11");
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertTrue(errors.hasFieldErrors("cpf"));
        assertEquals("validator.error.cpf.invalid", errors.getFieldError("cpf").getCode());
    }

    @Test
    void deveRejeitarNomeNulo() {
        Pessoa pessoa = pessoaValida();
        pessoa.setNome(null);
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertTrue(errors.hasFieldErrors("nome"));
        assertEquals("validator.error.nome.empty", errors.getFieldError("nome").getCode());
    }

    @Test
    void deveRejeitarNomeVazio() {
        Pessoa pessoa = pessoaValida();
        pessoa.setNome("   ");
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertTrue(errors.hasFieldErrors("nome"));
        assertEquals("validator.error.nome.empty", errors.getFieldError("nome").getCode());
    }

    @Test
    void deveRejeitarNomeMaiorQue200Caracteres() {
        Pessoa pessoa = pessoaValida();
        pessoa.setNome("A".repeat(201));
        Errors errors = erros(pessoa);

        validator.validate(pessoa, errors);

        assertTrue(errors.hasFieldErrors("nome"));
        assertEquals("validator.error.nome.invalid-size", errors.getFieldError("nome").getCode());
    }

    private Pessoa pessoaValida() {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("João Silva");
        pessoa.setCpf("529.982.247-25"); // CPF válido
        return pessoa;
    }

    private Errors erros(Pessoa pessoa) {
        return new BeanPropertyBindingResult(pessoa, "pessoa");
    }
}