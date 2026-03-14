package br.ufg.inf.onboarding.validators.service;

import br.ufg.inf.onboarding.dto.PessoaDto;
import br.ufg.inf.onboarding.model.Pessoa;
import br.ufg.inf.onboarding.repository.PessoaRepository;
import br.ufg.inf.onboarding.service.PessoaService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class PessoaServiceTest {

    @Mock
    private PessoaRepository pessoaRepository;

    @InjectMocks
    private PessoaService pessoaService;

    private Pessoa pessoa;
    private PessoaDto pessoaDto;

    @BeforeEach
    void setUp() {
        pessoaDto = new PessoaDto("João Silva", "529.982.247-25");

        pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setNome("João Silva");
        pessoa.setCpf("529.982.247-25");
    }
    
    @Test
    void deveSalvarUsuarioComSucesso() {
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(pessoa);

        Pessoa resultado = pessoaService.salvaUsuario(pessoaDto);

        assertNotNull(resultado);
        assertEquals("João Silva", resultado.getNome());
        assertEquals("529.982.247-25", resultado.getCpf());
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void deveListarTodasAsPessoas() {
        when(pessoaRepository.findAll()).thenReturn(List.of(pessoa));

        List<Pessoa> resultado = pessoaService.listarTodos();

        assertEquals(1, resultado.size());
        verify(pessoaRepository, times(1)).findAll();
    }

    @Test
    void deveRetornarListaVaziaQuandoNaoHaPessoas() {
        when(pessoaRepository.findAll()).thenReturn(List.of());

        List<Pessoa> resultado = pessoaService.listarTodos();

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveBuscarPessoaPorIdComSucesso() {
        when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));

        Optional<Pessoa> resultado = pessoaService.buscarPorId(1);

        assertTrue(resultado.isPresent());
        assertEquals(1, resultado.get().getId());
    }

    @Test
    void deveRetornarVazioQuandoIdNaoExiste() {
        when(pessoaRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Pessoa> resultado = pessoaService.buscarPorId(99);

        assertTrue(resultado.isEmpty());
    }

    @Test
    void deveAtualizarPessoaComSucesso() {
        PessoaDto dto = new PessoaDto("Maria Souza", "529.982.247-25");
        Pessoa atualizada = new Pessoa();
        atualizada.setId(1);
        atualizada.setNome("Maria Souza");
        atualizada.setCpf("529.982.247-25");

        when(pessoaRepository.findById(1)).thenReturn(Optional.of(pessoa));
        when(pessoaRepository.save(any(Pessoa.class))).thenReturn(atualizada);

        Optional<Pessoa> resultado = pessoaService.atualizar(1, dto);

        assertTrue(resultado.isPresent());
        assertEquals("Maria Souza", resultado.get().getNome());
        verify(pessoaRepository, times(1)).save(any(Pessoa.class));
    }

    @Test
    void deveRetornarVazioAoAtualizarIdInexistente() {
        when(pessoaRepository.findById(99)).thenReturn(Optional.empty());

        Optional<Pessoa> resultado = pessoaService.atualizar(99, pessoaDto);

        assertTrue(resultado.isEmpty());
        verify(pessoaRepository, never()).save(any());
    }

    // ---- deletar ----

    @Test
    void deveDeletarPessoaComSucesso() {
        when(pessoaRepository.existsById(1)).thenReturn(true);
        doNothing().when(pessoaRepository).deleteById(1);

        boolean resultado = pessoaService.deletar(1);

        assertTrue(resultado);
        verify(pessoaRepository, times(1)).deleteById(1);
    }

    @Test
    void deveRetornarFalseAoDeletarIdInexistente() {
        when(pessoaRepository.existsById(99)).thenReturn(false);

        boolean resultado = pessoaService.deletar(99);

        assertFalse(resultado);
        verify(pessoaRepository, never()).deleteById(any());
    }
}