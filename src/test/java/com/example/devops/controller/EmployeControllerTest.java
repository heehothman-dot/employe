package com.example.devops.controller;

import com.example.devops.reponse.EmployeReponse;
import com.example.devops.service.EmployeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
class EmployeControllerTest {

    @Mock
    private EmployeService employeService;

    @InjectMocks
    private EmployeController employeController;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(employeController).build();
    }

    @Test
    void getEmployeDetails_retourne200EtLeJson() throws Exception {
        when(employeService.getEmployeById(10)).thenReturn(new EmployeReponse(10, "Benali", 25));

        mockMvc.perform(get("/employes/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(10))
                .andExpect(jsonPath("$.name").value("Benali"))
                .andExpect(jsonPath("$.age").value(25));
    }
}
