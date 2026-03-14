package br.ufg.inf.onboarding.dto;

import br.ufg.inf.onboarding.model.Pessoa;

import java.time.LocalDateTime;

public record PessoaResponseDto(
        Integer id,
        String nome,
        String cpf,
        String message,
        LocalDateTime timestamp
) {
    public static PessoaResponseDto of(Pessoa pessoa, String message) {
        return new PessoaResponseDto(
                pessoa.getId(),
                pessoa.getNome(),
                pessoa.getCpf(),
                message,
                LocalDateTime.now()
        );
    }
}