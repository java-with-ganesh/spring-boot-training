package com.i2i.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.i2i.dto.VitalSignDTO;
import com.i2i.repository.VitalSignRepository;
import lombok.SneakyThrows;
import org.apache.hc.core5.http.ContentType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class VitalSignControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockitoBean
    private VitalSignRepository vitalSignRepository;

    @Test
    @SneakyThrows
    @WithMockUser
    public void createVitalSignTest() {
        var vitalSignDto = new VitalSignDTO();
        vitalSignDto.setPatientMrnNumber("MRN-1");
        vitalSignDto.setDocumentedBy("System");
        mockMvc.perform(post("/vitalSigns").content(objectMapper.writeValueAsString(vitalSignDto)).contentType(ContentType.APPLICATION_JSON.toString()))
                .andExpect(status().isOk());

    }
}
