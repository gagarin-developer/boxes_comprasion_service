package zone.gagarin.boxes_comprasion_service.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zone.gagarin.boxes_comprasion_service.dto.Box;
import zone.gagarin.boxes_comprasion_service.service.BoxService;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BoxesControllerTest {

  @Autowired
  private BoxService boxService;

  @Test
  void testEqualBoxes() throws Exception {
    Box firstBox = new Box(10d, 15d, 20d);
    Box secondBox = new Box(10d, 10d, 20d);

    String expectedMessage = "Boxes are equal";
    String responseMessage = boxService.compareBoxes(firstBox,secondBox);

    assertEquals(expectedMessage,responseMessage);
  }

  @Test
  void testSmallerFirstBox() throws Exception {
    Box firstBox = new Box(10d, 15d, 20d);
    Box secondBox = new Box(20d, 25d, 15d);

    String expectedMessage = "The first box is smaller than the second one";
    String responseMessage = boxService.compareBoxes(firstBox,secondBox);

    assertEquals(expectedMessage,responseMessage);
  }

  @Test
  void testLargerFirstBox() throws Exception {
    Box firstBox = new Box(20d, 25d, 15d);
    Box secondBox = new Box(10d, 15d, 20d);

    String expectedMessage = "The first box is larger than the second one";
    String responseMessage = boxService.compareBoxes(firstBox,secondBox);

    assertEquals(expectedMessage,responseMessage);
  }

  @Test
  void testIncomparableBoxes() throws Exception {
    Box firstBox = new Box(22.2, 25.5, 18d);
    Box secondBox = new Box(22.5, 26.2, 15d);

    String expectedMessage = "Boxes are incomparable";
    String responseMessage = boxService.compareBoxes(firstBox,secondBox);

    assertEquals(expectedMessage,responseMessage);
  }

  @Test
  void testCorrectnessSizeBoxes() throws Exception {
    Box firstBox = new Box(0d, 0d, 0d);
    Box secondBox = new Box(1d, 1d, 1d);

    String expectedMessage = "Incorrect box sizes have been entered";
    String responseMessage = boxService.compareBoxes(firstBox,secondBox);

    assertEquals(expectedMessage,responseMessage);
  }
}