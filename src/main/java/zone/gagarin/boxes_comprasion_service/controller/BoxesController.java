package zone.gagarin.boxes_comprasion_service.controller;

import java.util.Map;
import javax.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zone.gagarin.boxes_comprasion_service.dto.Box;
import zone.gagarin.boxes_comprasion_service.service.BoxService;

@RestController
@RequestMapping("/boxes")
public class BoxesController {

  private final BoxService boxService;

  @Autowired
  public BoxesController(
      BoxService boxService) {
    this.boxService = boxService;
  }

  @PostMapping(value = "/compare", consumes = "application/json")
  public ResponseEntity<String> compareBoxes(@RequestBody @NotNull Map<String, Box> boxes) {
      String response = boxService.compareBoxes(boxes.get("first"), boxes.get("second"));
      return new ResponseEntity<>(response,HttpStatus.OK);
  }
}
