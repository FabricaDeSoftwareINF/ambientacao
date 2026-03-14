package br.ufg.inf.onboarding.controller;

import br.ufg.inf.onboarding.dto.PessoaDto;
import br.ufg.inf.onboarding.dto.PessoaResponseDto;
import br.ufg.inf.onboarding.exception.ValidacaoException;
import br.ufg.inf.onboarding.model.Pessoa;
import br.ufg.inf.onboarding.service.PessoaService;
import br.ufg.inf.onboarding.validators.pessoa.BeforeCreatePessoaValidator;
import br.ufg.inf.onboarding.validators.pessoa.BeforeSavePessoaValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @Autowired
    private BeforeCreatePessoaValidator beforeCreateValidator;

    @Autowired
    private BeforeSavePessoaValidator beforeSaveValidator;

    @PostMapping
    public ResponseEntity<PessoaResponseDto> cadastrar(@RequestBody PessoaDto pessoaDto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setNome(pessoaDto.nome());
        pessoa.setCpf(pessoaDto.cpf());

        Errors errors = new BeanPropertyBindingResult(pessoa, "pessoa");
        beforeCreateValidator.validate(pessoa, errors);

        if (errors.hasErrors()) {
            throw new ValidacaoException(errors);
        }

        Pessoa salvo = pessoaService.salvaUsuario(pessoaDto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(PessoaResponseDto.of(salvo, "Cadastro realizado com sucesso!"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaResponseDto> atualizar(
            @PathVariable Integer id,
            @RequestBody PessoaDto pessoaDto) {

        Pessoa pessoa = new Pessoa();
        pessoa.setId(id);
        pessoa.setNome(pessoaDto.nome());
        pessoa.setCpf(pessoaDto.cpf());

        Errors errors = new BeanPropertyBindingResult(pessoa, "pessoa");
        beforeSaveValidator.validate(pessoa, errors);

        if (errors.hasErrors()) {
            throw new ValidacaoException(errors);
        }

        return pessoaService.atualizar(id, pessoaDto)
                .map(p -> ResponseEntity.ok(PessoaResponseDto.of(p, "Cadastro atualizado com sucesso!")))
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        boolean removido = pessoaService.deletar(id);
        return removido
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<Pessoa>> listar() {
        List<Pessoa> pessoas = pessoaService.listarTodos();
        return ResponseEntity.ok(pessoas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pessoa> buscarPorId(@PathVariable Integer id) {
        return pessoaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}