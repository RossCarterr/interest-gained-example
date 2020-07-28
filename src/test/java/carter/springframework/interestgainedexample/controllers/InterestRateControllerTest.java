package carter.springframework.interestgainedexample.controllers;

import carter.springframework.interestgainedexample.models.InterestRate;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
@AutoConfigureMockMvc
class InterestRateControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    void getInterestRatesOver5000() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/interestRateCalculator/10000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"interestAmount\":240.0}"));
    }

    @Test
    @Order(2)
    void getInterestRatesUnder1000() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.post("/interestRateCalculator/100"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":2,\"interestAmount\":1.0}"));
    }

    @Test
    @Order(3)
    void getInterestRatesUnder5000() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/interestRateCalculator/1000"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":3,\"interestAmount\":10.0}"));
    }

    @Test
    @Order(4)
    void getInterestRatesThrow() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/interestRateCalculator/string"))
                .andDo(print())
                .andExpect(status().isBadRequest());
    }

    @Test
    @Order(5)
    void getAmounts() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/interestAmount"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[{\"id\":1,\"interestAmount\":240.0},{\"id\":2,\"interestAmount\":1.0},{\"id\":3,\"interestAmount\":10.0}]"));
    }
}