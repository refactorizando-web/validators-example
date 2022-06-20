package com.refactorizando.example.validator;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.http.RequestEntity.post;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.refactorizando.example.validator.dto.CarDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class CarControllerIntegrationTest {

  @Autowired
  private MockMvc mockMvc;


  @Test
  void whenSaveCarIsInvoked_givenACarWithoutPlate_thenExceptionIsThrow() throws Exception {

    mockMvc.perform(
            MockMvcRequestBuilders.post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(createCarDTO())))
        .andExpect(status().is4xxClientError());

  }

  @Test
  void whenSaveCarIsInvoked_givenACorrectCar_thenCarIsSaved() throws Exception {

    CarDTO carDTO = createCarDTO();
    carDTO.setPlate("ASDFGA");
    mockMvc.perform(
            MockMvcRequestBuilders.post("/cars")
                .contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(carDTO)))
        .andExpect(status().is2xxSuccessful());

  }

  @Test
  void whenSaveCarIsInvoked_givenALengthGreaterThan10_thenErrorIsReturned() throws Exception {

    CarDTO carDTO = createCarDTO();
    carDTO.setPlate("ASDFGA");
    carDTO.setOrigin("ASDFGPOIERTUYUWE");
    mockMvc.perform(
                    MockMvcRequestBuilders.post("/cars")
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(asJsonString(carDTO)))
            .andExpect(status().is4xxClientError());

  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  private CarDTO createCarDTO() {
    CarDTO dto = new CarDTO();
    dto.setColor("blue");
    dto.setModel("Mustang");

    return dto;
  }
}
