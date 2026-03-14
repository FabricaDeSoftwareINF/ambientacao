package br.ufg.inf.onboarding.service;

import br.ufg.inf.onboarding.dto.PessoaDto;
import br.ufg.inf.onboarding.model.Pessoa;
import br.ufg.inf.onboarding.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Transactional
    public Pessoa salvaUsuario(PessoaDto pessoaDto) {
        Pessoa pessoa = new Pessoa();
        pessoa.setCpf(pessoaDto.cpf());
        pessoa.setNome(pessoaDto.nome());
        return pessoaRepository.save(pessoa);
    }

    public List<Pessoa> listarTodos() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }

    public Optional<Pessoa> buscarPorId(Integer id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public Optional<Pessoa> atualizar(Integer id, PessoaDto pessoaDto) {
        return pessoaRepository.findById(id).map(pessoa -> {
            pessoa.setNome(pessoaDto.nome());
            pessoa.setCpf(pessoaDto.cpf());
            return pessoaRepository.save(pessoa);
        });
    }

    @Transactional
    public boolean deletar(Integer id) {
        if (pessoaRepository.existsById(id)) {
            pessoaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}