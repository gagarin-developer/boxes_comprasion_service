package zone.gagarin.boxes_comprasion_service.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.ExceptionHandler;
import zone.gagarin.boxes_comprasion_service.dto.Box;

@SpringBootTest
@AutoConfigureMockMvc
class BoxesControllerMockMvcTest {

  @Autowired
  private MockMvc mockMvc;

  private final String URI = "/boxes/compare";

  @Test
  void testCompareBoxesIsOk() throws Exception {
    Box firstBox = new Box(10d, 10d, 20d);
    Box secondBox = new Box(10d, 10d, 20d);
    Map<String, Box> mapBoxes = Map.of("first", firstBox, "second", secondBox);
    String expectedMessage = "Boxes are equal";

    mockMvc.perform(post(URI).content(asJsonString(mapBoxes))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(expectedMessage));
  }

  @Test
  void testCompareBoxesIsUnsupportedMediaType() throws Exception {
    mockMvc.perform(post(URI).content("")
            .contentType(MediaType.ALL))
        .andExpect(status().isUnsupportedMediaType());
  }

  @Test
  void testCompareBoxesIsBadRequest() throws Exception {
    mockMvc.perform(post(URI).content(asJsonString(null))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isBadRequest());
  }

  public static String asJsonString(final Object obj) {
    try {
      return new ObjectMapper().writeValueAsString(obj);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  @ExceptionHandler(RuntimeException.class)
  public final ResponseEntity<Exception> handleAllExceptions(RuntimeException ex) {
    return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}