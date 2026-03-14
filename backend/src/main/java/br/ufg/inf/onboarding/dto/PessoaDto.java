package br.ufg.inf.onboarding.dto;

import org.springframework.beans.factory.annotation.Required;

public record PessoaDto(@Required String nome, @Required String cpf) {
}
