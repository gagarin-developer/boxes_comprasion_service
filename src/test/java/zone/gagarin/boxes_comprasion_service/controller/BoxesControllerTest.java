package zone.gagarin.boxes_comprasion_service.controller;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Map;
import org.json.JSONArray;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import zone.gagarin.boxes_comprasion_service.dto.Box;
import zone.gagarin.boxes_comprasion_service.service.BoxService;

@SpringBootTest
@AutoConfigureMockMvc
class BoxesControllerMockTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private BoxService boxService;

  @Test
  void testCompareBoxes(String json) throws Exception {
    this.mockMvc.perform(
            post("/boxes/compare").content(json).contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk())
        .andExpect(content().string(containsString("Boxes are equal")));
  }

}