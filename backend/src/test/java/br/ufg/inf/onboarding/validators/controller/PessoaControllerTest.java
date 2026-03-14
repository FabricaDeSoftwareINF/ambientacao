package br.ufg.inf.onboarding.validators.controller;

import br.ufg.inf.onboarding.controller.PessoaController;
import br.ufg.inf.onboarding.dto.PessoaDto;
import br.ufg.inf.onboarding.model.Pessoa;
import br.ufg.inf.onboarding.service.PessoaService;
import br.ufg.inf.onboarding.validators.pessoa.BeforeCreatePessoaValidator;
import br.ufg.inf.onboarding.validators.pessoa.BeforeSavePessoaValidator;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.Errors;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PessoaController.class)
class PessoaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PessoaService pessoaService;

    @MockBean
    private BeforeCreatePessoaValidator beforeCreateValidator;

    @MockBean
    private BeforeSavePessoaValidator beforeSaveValidator;

    private Pessoa pessoa;

    @BeforeEach
    void setUp() {
        pessoa = new Pessoa();
        pessoa.setId(1);
        pessoa.setNome("João Silva");
        pessoa.setCpf("529.982.247-25");

        doNothing().when(beforeCreateValidator).validate(any(), any());
        doNothing().when(beforeSaveValidator).validate(any(), any());
        when(beforeCreateValidator.supports(Pessoa.class)).thenReturn(true);
        when(beforeSaveValidator.supports(Pessoa.class)).thenReturn(true);
    }


    @Test
    void deveCadastrarPessoaERetornar201() throws Exception {
        when(pessoaService.salvaUsuario(any())).thenReturn(pessoa);

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PessoaDto("João Silva", "529.982.247-25"))))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andExpect(jsonPath("$.message").value("Cadastro realizado com sucesso!"));
    }

    @Test
    void deveRetornar400AoCadastrarComDadosInvalidos() throws Exception {
        doAnswer(invocation -> {
            Errors errors = invocation.getArgument(1);
            errors.rejectValue("cpf", "validator.error.cpf.invalid");
            return null;
        }).when(beforeCreateValidator).validate(any(), any());

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PessoaDto("João Silva", "111.111.111-11"))))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.status").value(400))
                .andExpect(jsonPath("$.erros").isArray());
    }

    @Test
    void deveListarPessoasERetornar200() throws Exception {
        when(pessoaService.listarTodos()).thenReturn(List.of(pessoa));

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].nome").value("João Silva"));
    }

    @Test
    void deveBuscarPorIdERetornar200() throws Exception {
        when(pessoaService.buscarPorId(1)).thenReturn(Optional.of(pessoa));

        mockMvc.perform(get("/usuarios/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1));
    }

    @Test
    void deveRetornar404QuandoIdNaoExiste() throws Exception {
        when(pessoaService.buscarPorId(99)).thenReturn(Optional.empty());

        mockMvc.perform(get("/usuarios/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveAtualizarPessoaERetornar200() throws Exception {
        when(pessoaService.atualizar(eq(1), any())).thenReturn(Optional.of(pessoa));

        mockMvc.perform(put("/usuarios/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PessoaDto("João Silva", "529.982.247-25"))))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("Cadastro atualizado com sucesso!"));
    }

    @Test
    void deveRetornar404AoAtualizarIdInexistente() throws Exception {
        when(pessoaService.atualizar(eq(99), any())).thenReturn(Optional.empty());

        mockMvc.perform(put("/usuarios/99")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new PessoaDto("João Silva", "529.982.247-25"))))
                .andExpect(status().isNotFound());
    }

    @Test
    void deveDeletarPessoaERetornar204() throws Exception {
        when(pessoaService.deletar(1)).thenReturn(true);

        mockMvc.perform(delete("/usuarios/1"))
                .andExpect(status().isNoContent());
    }

    @Test
    void deveRetornar404AoDeletarIdInexistente() throws Exception {
        when(pessoaService.deletar(99)).thenReturn(false);

        mockMvc.perform(delete("/usuarios/99"))
                .andExpect(status().isNotFound());
    }
}