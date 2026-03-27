package br.ufg.inf.onboarding.controller;

import br.ufg.inf.onboarding.model.Usuario;
import br.ufg.inf.onboarding.repository.UsuarioRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @BeforeEach
    void setUp() {
        usuarioRepository.deleteAll();
    }

    @Test
    void testCadastroUsuarioCpfValido() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("João");
        usuario.setCpf("529.982.247-25");
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(usuario)))
                .andExpect(status().isOk());
    }

    @Test
    void testCadastroUsuarioCpfInvalido() throws Exception {
        Usuario usuario = new Usuario();
        usuario.setNome("Maria");
        usuario.setCpf("123.456.789-00");
        mockMvc.perform(post("/usuarios")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(usuario)))
                .andExpect(status().isBadRequest());
    }
}
