package br.com.dentalclinicmanagementsoftware;

import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.app.api.dto.request.PatientRequest;
import br.com.dentalclinicmanagementsoftware.dentalclinicmanagementsoftware.domain.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;


@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
public class PatientApplicationTests {
    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper mapper;
    @SpyBean
    private PatientService gameService;
    @Test
    void contextLoads() {
        Assertions.assertNotNull(mvc);
    }

    @Test
    void dadoUmObjetoValido_quandoChamamosAddPatient_entaoRetornarObjetoMockado() throws Exception {
        PatientRequest patient = PatientFixture.anyPatient();

        String patientAsJson = mapper.writeValueAsString(patient);

        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .post("/v1/patients")
                .content(patientAsJson)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void dado5RegistrosNoBanco_quandoChamamosEndpointGetAllPatients_entaoRetornarRegistrosPaginados() throws Exception {
        MockHttpServletRequestBuilder request = MockMvcRequestBuilders
                .get("/v1/patients")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON);

        this.mvc.perform(request)
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.totalElements", Matchers.equalTo(5)))
                .andExpect(MockMvcResultMatchers.jsonPath("$", Matchers.hasKey("size")));
    }
}
